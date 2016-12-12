package edu.bsuir.ss.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.bsuir.ss.R;

public class ManageFragment extends BaseFragment {
    public ManageFragment() {

    }
    public static ManageFragment newInstance() {
        return new ManageFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manage, container, false);
        initViews(view);
        return view;
    }

    @Override
    protected void initViews(View view) {

    }
}
