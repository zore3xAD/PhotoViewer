package com.android.zore3x.photoviewer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.zore3x.photoviewer.R;

public class UserInformationFragment extends Fragment {

    private static final String ARG_USER_ID = "user_id";

    public static UserInformationFragment newInstance(String userId) {

        Bundle args = new Bundle();

        args.putString(ARG_USER_ID, userId);

        UserInformationFragment fragment = new UserInformationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_information, container, false);

        return view;
    }
}
