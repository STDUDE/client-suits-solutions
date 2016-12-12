package edu.bsuir.ss.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.bsuir.ss.R;

import com.google.android.gms.plus.PlusOneButton;

public class WorkTasksFragment extends BaseFragment {


    public WorkTasksFragment() {

    }
    public static WorkTasksFragment newInstance() {
        return new WorkTasksFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_work_tasks, container, false);
        initViews(view);
        return view;
    }

    @Override
    protected void initViews(View view) {

    }
}
