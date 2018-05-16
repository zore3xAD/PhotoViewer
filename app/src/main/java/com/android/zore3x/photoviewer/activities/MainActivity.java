package com.android.zore3x.photoviewer.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.zore3x.photoviewer.App;
import com.android.zore3x.photoviewer.R;
import com.android.zore3x.photoviewer.adapters.PhotosLineAdapter;
import com.android.zore3x.photoviewer.api.Order;
import com.android.zore3x.photoviewer.api.Unsplash;
import com.android.zore3x.photoviewer.api.model.Photo;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mPhotoLineRecyclerView;
    private PhotosLineAdapter mPhotosLineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPhotoLineRecyclerView = findViewById(R.id.photosLine_recyclerVeiw);
        mPhotoLineRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));



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
