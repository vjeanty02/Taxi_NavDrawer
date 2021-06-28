package com.vjeanty.TaxiNavDrawer.Controllers.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.vjeanty.TaxiNavDrawer.R;

public class FragmentLogout extends Fragment {

    public static FragmentLogout newInstance() {
        return (new FragmentLogout());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_logout, container, false);
    }
}