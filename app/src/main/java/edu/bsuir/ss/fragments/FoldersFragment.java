package edu.bsuir.ss.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.bsuir.ss.R;

public class FoldersFragment extends BaseFragment {
    public FoldersFragment() {

    }
    public static FoldersFragment newInstance() {
        return new FoldersFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_folders, container, false);
        initViews(view);
        return view;
    }

    @Override
    protected void initViews(View view) {

    }
}
