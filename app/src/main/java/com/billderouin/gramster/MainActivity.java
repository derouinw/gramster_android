package com.billderouin.gramster;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.billderouin.gramster.fragments.SettingsFragment;
import com.billderouin.gramster.fragments.StreamFragment;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String TAG_STREAM = "tag_stream";
    private static final String TAG_SETTINGS = "tag_settings";

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        // Toolbar
        mToolbar = (Toolbar)findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Gramster");
        mToolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        // Navigation view
        mNavigationView = (NavigationView)findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        // First fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new StreamFragment(), TAG_STREAM).commit();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        // Handle nav drawer item selections
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = null;
        String tag = null;

        switch (menuItem.getItemId()) {
            case R.id.navigation_stream:
                tag = TAG_STREAM;
                fragment = fragmentManager.findFragmentByTag(TAG_STREAM);
                if (fragment == null) {
                    fragment = new StreamFragment();
                }
                break;
            case R.id.navigation_settings:
                tag = TAG_SETTINGS;
                fragment = fragmentManager.findFragmentByTag(TAG_SETTINGS);
                if (fragment == null) {
                    fragment = new SettingsFragment();
                }
                break;
        }

        if (fragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment, tag).commit();
        }

        menuItem.setChecked(true);
        mDrawerLayout.closeDrawer(Gravity.LEFT);

        return fragment != null;
    }
}
