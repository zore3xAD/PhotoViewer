package com.android.zore3x.photoviewer.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.zore3x.photoviewer.R;
import com.android.zore3x.photoviewer.api.Order;
import com.android.zore3x.photoviewer.api.Unsplash;
import com.android.zore3x.photoviewer.api.model.Photo;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String CLIENT_ID = "e83deeb4b720fde9e40ae1cb8ea68b9d5cb8357b5415cdfd567881b234c9bbbc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Unsplash unsplash = new Unsplash(CLIENT_ID);
        unsplash.getPhotos(1, null, null, new Unsplash.OnPhotosLoadedListener() {
            @Override
            public void onComplete(List<Photo> photos) {
                int d =4;
            }

            @Override
            public void onError(String error) {
                int d = 3;
            }
        });
    }
}
