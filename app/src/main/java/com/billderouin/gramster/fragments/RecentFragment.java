package com.billderouin.gramster.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.billderouin.gramster.R;

/**
 * Created by bill on 7/11/15.
 */
public class RecentFragment extends Fragment {

    // Required default constructor
    public RecentFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recent, container, false);

        return rootView;
    }
}
