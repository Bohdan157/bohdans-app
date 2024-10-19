package com.bohdan157.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.bohdan157.app.ui.friends.FriendsFragment;
import com.bohdan157.app.ui.home.HomeFragment;
import com.bohdan157.app.ui.links.LinksFragment;
import com.bohdan157.app.ui.devices.DevicesFragment;

import dev.oneuiproject.oneui.layout.ToolbarLayout;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ToolbarLayout toolbarLayout;

    @SuppressLint({"ShowToast", "MissingInflatedId", "WrongThread"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.tabs_bottomnav_icon);
        toolbarLayout = findViewById(R.id.toolbarLayout);

        toolbarLayout.setTitle(getString(R.string.home));

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main, new HomeFragment()).commit();

        bottomNavigationView.setOnItemSelectedListener(menuItem -> {
            Fragment fragment = getFragmentBottomNavView(menuItem);
            if (fragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main, fragment);
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction.commit();
            }
            return true;
        });
    }
    public Fragment getFragmentBottomNavView(MenuItem menuItem) {
        toolbarLayout.findViewById(R.id.toolbarLayout);
        Fragment fragment = null;
        int itemId = menuItem.getItemId();
        if (itemId == R.id.navigation_home) {
            toolbarLayout.setTitle(getString(R.string.home));
            fragment = new HomeFragment();
        } else if (itemId == R.id.navigation_devices) {
            toolbarLayout.setTitle("Devices");
            fragment = new DevicesFragment();
        } else if (itemId == R.id.navigation_friends) {
            toolbarLayout.setTitle(getString(R.string.friends));
            fragment = new FriendsFragment();
        } else if (itemId == R.id.navigation_links) {
            toolbarLayout.setTitle("Links");
            fragment = new LinksFragment();
        }
        return fragment;
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuCompat.setGroupDividerEnabled(menu, true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_about_app) {
            startActivity(new Intent(this, AboutActivity.class));
        } else if (item.getItemId() == R.id.menu_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        return false;
    }
}