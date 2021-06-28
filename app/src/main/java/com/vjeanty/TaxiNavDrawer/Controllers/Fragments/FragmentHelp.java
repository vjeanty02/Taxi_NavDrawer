package com.vjeanty.TaxiNavDrawer.Controllers.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vjeanty.TaxiNavDrawer.R;


public class FragmentHelp extends Fragment {

    public static FragmentHelp newInstance() {
        return (new FragmentHelp());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_help, container, false);
    }
}