package com.android.zore3x.photoviewer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.android.zore3x.photoviewer.App;
import com.android.zore3x.photoviewer.R;
import com.android.zore3x.photoviewer.adapters.PhotosLineAdapter;
import com.android.zore3x.photoviewer.api.Order;
import com.android.zore3x.photoviewer.api.Unsplash;
import com.android.zore3x.photoviewer.api.model.Photo;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mAllPhotosButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAllPhotosButton = findViewById(R.id.allPhoto_button);

        mAllPhotosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(AllPhotosActivity.newIntent(getApplicationContext()));
            }
        });

    }
}
