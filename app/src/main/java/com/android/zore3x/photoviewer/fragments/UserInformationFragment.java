package com.android.zore3x.photoviewer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.zore3x.photoviewer.App;
import com.android.zore3x.photoviewer.R;
import com.android.zore3x.photoviewer.api.Unsplash;
import com.android.zore3x.photoviewer.api.model.User;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserInformationFragment extends Fragment {

    private static final String ARG_USER_NAME = "user_name";

    private String mUsername;

    private CircleImageView mUserPhoto;
    private TextView mUsernameTextView;
    private TextView mUserLocationTextView;
    private TextView mUserPhotosTextView;
    private TextView mUserLikesTextView;
    private TextView mUserCollectionsTextView;
    private TextView mUserBioTextView;

    private User mUser;

    public static UserInformationFragment newInstance(String username) {

        Bundle args = new Bundle();

        args.putString(ARG_USER_NAME, username);

        UserInformationFragment fragment = new UserInformationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_information, container, false);

        mUsername = getArguments().getString(ARG_USER_NAME);

        mUserPhoto = view.findViewById(R.id.userPhoto_circleImageView);
        mUsernameTextView = view.findViewById(R.id.userName_textView);
        mUserLocationTextView = view.findViewById(R.id.userLocation_textView);
        mUserPhotosTextView = view.findViewById(R.id.userPhotosCount_textView);
        mUserLikesTextView = view.findViewById(R.id.userLikesCount_textView);
        mUserCollectionsTextView = view.findViewById(R.id.userCollectionsCount_textView);
        mUserBioTextView = view.findViewById(R.id.userBio_textView);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        App.getUnsplash().getUser(mUsername, new Unsplash.OnUserLoadedListener() {
            @Override
            public void onComplete(User user) {
                mUser = user;
                updateUI(mUser);
            }

            @Override
            public void onError(String error) {
                int d = 4;
            }
        });
    }

    private void updateUI(User user) {

        Picasso.get().load(user.getProfileImage().getMedium()).into(mUserPhoto);
        mUsernameTextView.setText(user.getName());
        mUserLocationTextView.setText(user.getLocation());
        mUserPhotosTextView.setText(String.format(getString(R.string.user_total_photos), user.getTotalPhotos()));
        mUserLikesTextView.setText(String.format(getString(R.string.user_total_likes), user.getTotalLikes()));
        mUserCollectionsTextView.setText(String.format(getString(R.string.user_total_collections), user.getTotalCollections()));
        mUserBioTextView.setText(user.getBio());
    }
}
