package com.bohdan157.app.ui.links;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.bohdan157.app.ModulesFragment;
import com.bohdan157.app.PetsFragment;
import com.bohdan157.app.R;
import com.bohdan157.app.databinding.FragmentLinksBinding;

public class LinksFragment extends Fragment implements View.OnClickListener{
    FragmentLinksBinding binding;
    private long mLastClickTime;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLinksBinding.inflate(inflater, container, false);
        initContent();

        return binding.getRoot();
    }

    public void onPause() {
        super.onPause();
    }
    public void onResume() {
        super.onResume();
    }

    private void initContent() {
        binding.linkModules.setOnClickListener(this);
        binding.linkAppsa.setOnClickListener(this);
        binding.linkAppswin.setOnClickListener(this);
        binding.linkRT.setOnClickListener(this);
        binding.linkModules.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - mLastClickTime > 600L) {
            String url = null;
            if (v.getId() == binding.linkAppsa.getId()) {
                url = "https://drive.google.com/drive/folders/1CSkHzPmgmEtl8R06AUjkX9Klr0HN2qwb?usp=drive_link";
            } else if (v.getId() == binding.linkAppswin.getId()) {
                url = "https://drive.google.com/file/d/1ll8MfSVpTJdaVJmjcUfi_7ijgGt4CpDs/view?usp=sharing";
            }
            else if (v.getId() == binding.linkRT.getId()) {
                url = "https://github.com/MADWIN11/MITOOLS/releases/tag/V1";
            }
            if (v.getId() == binding.linkModules.getId()) {
                Fragment ModulesFragment = new ModulesFragment();
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_main, ModulesFragment, "findThisFragment")
                        .addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
            }
            if (url != null) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Log.d("Link error", "Activity is not detected");
                }
            }
        }
        mLastClickTime = uptimeMillis;
    }
}