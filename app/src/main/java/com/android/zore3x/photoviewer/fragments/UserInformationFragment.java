package com.android.zore3x.photoviewer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.zore3x.photoviewer.App;
import com.android.zore3x.photoviewer.R;
import com.android.zore3x.photoviewer.adapters.UsersPhotoAdapter;
import com.android.zore3x.photoviewer.api.Order;
import com.android.zore3x.photoviewer.api.Unsplash;
import com.android.zore3x.photoviewer.api.model.Photo;
import com.android.zore3x.photoviewer.api.model.User;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserInformationFragment extends Fragment implements View.OnClickListener{

    private static final String ARG_USER_NAME = "user_name";

    private String mUsername;

    private CircleImageView mUserPhoto;
    private TextView mUsernameTextView;
    private TextView mUserLocationTextView;
    private TextView mUserPhotosTextView;
    private TextView mUserLikesTextView;
    private TextView mUserCollectionsTextView;
    private TextView mUserBioTextView;

    private RecyclerView mUserPhotosRecyclerView;

    private User mUser;
    private List<Photo> mUserPhotoList;

    private UsersPhotoAdapter mAdapter;

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
        mUserPhotosRecyclerView = view.findViewById(R.id.userPhotos_recyclerView);

        mUserLikesTextView.setOnClickListener(this);
        mUserPhotosTextView.setOnClickListener(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mUserPhotosRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

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

        App.getUnsplash().getUserPhotos(mUsername, 1, null, Order.LATEST, new Unsplash.OnPhotosLoadedListener() {
            @Override
            public void onComplete(List<Photo> photos) {
                mUserPhotoList = photos;
                updateUI(mUserPhotoList);
            }

            @Override
            public void onError(String error) {

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

    private void updateUI(List<Photo> userPhotos) {
        if(mAdapter == null) {
            mAdapter = new UsersPhotoAdapter(userPhotos);
            mUserPhotosRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setUserPhotoList(userPhotos);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.userLikesCount_textView:
                App.getUnsplash().getUserLikes(mUsername, 1, 10, Order.LATEST, new Unsplash.OnPhotosLoadedListener() {
                    @Override
                    public void onComplete(List<Photo> photos) {
                        mUserPhotoList = photos;
                        updateUI(photos);
                    }

                    @Override
                    public void onError(String error) {

                    }
                });
                break;
            case R.id.userPhotosCount_textView:
                App.getUnsplash().getUserPhotos(mUsername, 1, null, Order.LATEST, new Unsplash.OnPhotosLoadedListener() {
                    @Override
                    public void onComplete(List<Photo> photos) {
                        mUserPhotoList = photos;
                        updateUI(mUserPhotoList);
                    }

                    @Override
                    public void onError(String error) {

                    }
                });
                break;
        }
    }
}
