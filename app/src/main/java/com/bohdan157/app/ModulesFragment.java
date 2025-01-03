package com.bohdan157.app;

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

import com.bohdan157.app.R;
import com.bohdan157.app.databinding.FragmentModules2Binding;

public class ModulesFragment extends Fragment implements View.OnClickListener{
    FragmentModules2Binding binding;
    private long mLastClickTime;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentModules2Binding.inflate(inflater, container, false);
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
        binding.linkPif.setOnClickListener(this);
        binding.linkNl.setOnClickListener(this);
        binding.linkLp.setOnClickListener(this);
        binding.linkZn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - mLastClickTime > 600L) {
            String url = null;
            if (v.getId() == binding.linkPif.getId()) {
                url = "https://github.com/chiteroman/PlayIntegrityFix/releases";
            }
            if (v.getId() == binding.linkNl.getId()) {
                url = "https://github.com/salvogiangri/KnoxPatch/releases";
            }
            if (v.getId() == binding.linkLp.getId()) {
                url = "https://github.com/LSPosed/LSPosed/releases";
            }
            if (v.getId() == binding.linkZn.getId()) {
                url = "https://github.com/Dr-TSNG/ZygiskNext/releases";
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