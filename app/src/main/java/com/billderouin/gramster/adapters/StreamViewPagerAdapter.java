package com.billderouin.gramster.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;

import com.billderouin.gramster.fragments.StreamRecentFragment;
import com.billderouin.gramster.fragments.StreamTrendingFragment;

/**
 * Created by bill on 7/11/15.
 */
public class StreamViewPagerAdapter extends FragmentPagerAdapter {

    private static final String TAG_RECENT = "tag_recent";
    private static final String TAG_TRENDING = "tag_trending";
    private static final String[] TAB_TITLES = new String[] { "Recent", "Trending" };

    private StreamRecentFragment mRecentFragment;
    private StreamTrendingFragment mTrendingFragment;

    public StreamViewPagerAdapter(FragmentActivity activity) {
        super(activity.getSupportFragmentManager());
    }

    @Override
    public int getCount() {
        return TAB_TITLES.length;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            // Recent tab is first
            default:
            case 0:
                if (mRecentFragment == null) {
                    mRecentFragment = new StreamRecentFragment();
                }
                fragment = mRecentFragment;
                break;
            // Trending
            case 1:
                if (mTrendingFragment == null) {
                    mTrendingFragment = new StreamTrendingFragment();
                }
                fragment = mTrendingFragment;
                break;
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return TAB_TITLES[position];
    }
}
