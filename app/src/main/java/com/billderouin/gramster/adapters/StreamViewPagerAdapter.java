package com.billderouin.gramster.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.billderouin.gramster.fragments.RecentFragment;
import com.billderouin.gramster.fragments.TrendingFragment;

/**
 * Created by bill on 7/11/15.
 */
public class StreamViewPagerAdapter extends FragmentPagerAdapter {

    private static final String TAG_RECENT = "tag_recent";
    private static final String TAG_TRENDING = "tag_trending";
    private static final String[] TAB_TITLES = new String[] { "Recent", "Trending" };

    private RecentFragment mRecentFragment;
    private TrendingFragment mTrendingFragment;

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
                    mRecentFragment = new RecentFragment();
                }
                fragment = mRecentFragment;
                break;
            // Trending
            case 1:
                if (mTrendingFragment == null) {
                    mTrendingFragment = new TrendingFragment();
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
