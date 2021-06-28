package com.vjeanty.TaxiNavDrawer.Controllers.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.vjeanty.TaxiNavDrawer.R;

public class FragmentSettings extends Fragment {

    public static FragmentSettings newInstance() {
        return (new FragmentSettings());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }
}