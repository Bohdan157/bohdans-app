package com.bohdan157.app.ui.friends;

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

import com.bohdan157.app.databinding.FragmentFriendsBinding;

public class FriendsFragment extends Fragment implements View.OnClickListener {

    private FragmentFriendsBinding binding;
    private long mLastClickTime;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFriendsBinding.inflate(inflater, container, false);

        initContent();
        return binding.getRoot();
    }

    private void initContent() {
        binding.friendsOst.setOnClickListener(this);
        binding.friendsZhenya.setOnClickListener(this);
        binding.friendsMelamit.setOnClickListener(this);
        binding.friendsKernel.setOnClickListener(this);
        binding.friendsHackuser.setOnClickListener(this);
        binding.friendsAnton.setOnClickListener(this);
        binding.friendsDima.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - mLastClickTime > 600L) {
            String url = null;
            if (v.getId() == binding.friendsOst.getId()) {
                url = "https://ost-sys.github.io/";
            }
            if (v.getId() == binding.friendsZhenya.getId()) {
                url = "https://www.youtube.com/@zhh4eny";
            }
            if (v.getId() == binding.friendsMelamit.getId()) {
                url = "https://t.me/melamitd";
            }
            if (v.getId() == binding.friendsHackuser.getId()) {
                url = "https://hackintoshuser137.github.io";
            }
            if (v.getId() == binding.friendsDima.getId()) {
                url = "https://dima-lq.github.io";
            }
            if (v.getId() == binding.friendsAnton.getId()) {
                url = "https://t.me/antonaprilbl0g";
            }
            if (v.getId() == binding.friendsKernel.getId()) {
                url = "https://t.me/GalaxyS2_S3_Updates";
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
    }
}