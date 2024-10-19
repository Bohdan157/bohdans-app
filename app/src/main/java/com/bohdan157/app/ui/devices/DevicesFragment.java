package com.bohdan157.app.ui.devices;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.bohdan157.app.R;
import com.bohdan157.app.databinding.FragmentDevicesBinding;

public class DevicesFragment extends Fragment implements View.OnClickListener {
    public FragmentDevicesBinding binding;
    private long mLastClickTime;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDevicesBinding.inflate(inflater, container, false);

        initContent();
        return binding.getRoot();
    }

    private void initContent() {
        //binding.utilitiesAndroid.setOnClickListener(this);
        //eto kak primer tebe
    }

    @Override
    public void onClick(View v) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - mLastClickTime > 600L) {

        }
        mLastClickTime = uptimeMillis;
    }

    private FragmentManager getSupportFragmentManager() {
        return getSupportFragmentManager();
    }
}