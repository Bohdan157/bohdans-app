package com.bohdan157.app.ui.devices;

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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bohdan157.app.PetsFragment;
import com.bohdan157.app.PhoneFrag;
import com.bohdan157.app.R;
import com.bohdan157.app.TabFragment;
import com.bohdan157.app.WearsFragment;
import com.bohdan157.app.abtdevFragment;
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
            binding.acaa.setOnClickListener(this);
        binding.aasdcaaa.setOnClickListener(this);
        binding.aasadcaaa.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - mLastClickTime > 600L) {
                String url = null;
                if (v.getId() == binding.acaa.getId()) {
                    Fragment ModulesFragment = new PhoneFrag();
                    requireActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment_activity_main, ModulesFragment, "findThisFragment")
                            .addToBackStack(null)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .commit();
                }
                if (v.getId() == binding.aasdcaaa.getId()) {
                    Fragment ModulesFragment = new TabFragment();
                    requireActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment_activity_main, ModulesFragment, "findThisFragment")
                            .addToBackStack(null)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .commit();
                }
                if (v.getId() == binding.aasadcaaa.getId()) {
                    Fragment ModulesFragment = new WearsFragment();
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

