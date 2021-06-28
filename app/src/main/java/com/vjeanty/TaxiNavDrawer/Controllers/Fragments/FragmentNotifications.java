package com.vjeanty.TaxiNavDrawer.Controllers.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.vjeanty.TaxiNavDrawer.R;

public class FragmentNotifications extends Fragment {

    public static FragmentNotifications newInstance() {
        return (new FragmentNotifications());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notifications, container, false);
    }
}