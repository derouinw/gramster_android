package com.billderouin.gramster.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.billderouin.gramster.R;

/**
 * Created by bill on 7/11/15.
 */
public class SettingsFragment extends Fragment {

    // Required default constructor
    public SettingsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        return rootView;
    }
}
