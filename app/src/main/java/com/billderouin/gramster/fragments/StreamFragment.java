package com.billderouin.gramster.fragments;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.billderouin.gramster.R;
import com.billderouin.gramster.adapters.StreamViewPagerAdapter;

/**
 * Created by bill on 7/11/15.
 */
public class StreamFragment extends Fragment {
    private static final String TAG = StreamFragment.class.getSimpleName();

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private PagerAdapter mPagerAdapter;

    // Required default constructor
    public StreamFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_stream, container, false);

        mViewPager = (ViewPager)rootView.findViewById(R.id.view_pager);
        mPagerAdapter = new StreamViewPagerAdapter(getActivity());
        mViewPager.setAdapter(mPagerAdapter);

        mTabLayout = (TabLayout) rootView.findViewById(R.id.sliding_tabs);
        mTabLayout.setTabTextColors(Color.WHITE, Color.WHITE);
        mTabLayout.setupWithViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        return rootView;
    }
}
