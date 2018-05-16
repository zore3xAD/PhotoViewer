package com.android.zore3x.photoviewer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.zore3x.photoviewer.App;
import com.android.zore3x.photoviewer.R;
import com.android.zore3x.photoviewer.adapters.PhotosLineAdapter;
import com.android.zore3x.photoviewer.api.Unsplash;
import com.android.zore3x.photoviewer.api.model.Photo;

import java.util.List;

public class AllPhotosFragment extends Fragment {

    private RecyclerView mPhotoLineRecyclerView;
    private PhotosLineAdapter mPhotosLineAdapter;

    public static AllPhotosFragment newInstance() {
        
        Bundle args = new Bundle();
        
        AllPhotosFragment fragment = new AllPhotosFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_all_photos, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPhotoLineRecyclerView = view.findViewById(R.id.photosLine_recyclerVeiw);
        mPhotoLineRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        App.getUnsplash().getPhotos(1, null, null, new Unsplash.OnPhotosLoadedListener() {
            @Override
            public void onComplete(List<Photo> photos) {
                updateUi(photos);
            }

            @Override
            public void onError(String error) {
                int d = 3;
            }
        });
    }

    private void updateUi(List<Photo> photos) {

        if(mPhotosLineAdapter != null) {
            mPhotosLineAdapter.setPhotoList(photos);
            mPhotosLineAdapter.notifyDataSetChanged();
        } else {
            mPhotosLineAdapter = new PhotosLineAdapter(photos);
            mPhotoLineRecyclerView.setAdapter(mPhotosLineAdapter);
        }

    }
}
