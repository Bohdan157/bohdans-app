package com.bohdan157.app.ui.home;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bohdan157.app.ModulesFragment;
import com.bohdan157.app.PetsFragment;
import com.bohdan157.app.R;
import com.bohdan157.app.abtdevFragment;
import com.bohdan157.app.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private FragmentHomeBinding binding;
    private long mLastClickTime;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);



        initContent();
        return binding.getRoot();
    }

    private void initContent() {
        binding.telegramAcc.setOnClickListener(this);
        binding.pets.setOnClickListener(this);
        binding.blog.setOnClickListener(this);
        binding.gh.setOnClickListener(this);
        binding.acaa.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - mLastClickTime > 600L) {
            String url = null;
            if (v.getId() == binding.telegramAcc.getId()) {
                url = "https://t.me/Bohdanr9q";
            }
            if (v.getId() == binding.blog.getId()) {
                url = "https://t.me/blog157";
            }
            if (v.getId() == binding.gh.getId()) {
                url = "https://github.com/Bohdan157";
            }
            if (v.getId() == binding.acaa.getId()) {
                Fragment ModulesFragment = new abtdevFragment();
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_main, ModulesFragment, "findThisFragment")
                        .addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
            }
            if (v.getId() == binding.pets.getId()) {
                Fragment PetsFragment = new PetsFragment();
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_main, PetsFragment, "findThisFragment")
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
