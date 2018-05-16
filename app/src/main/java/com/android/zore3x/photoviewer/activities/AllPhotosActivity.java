package com.android.zore3x.photoviewer.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.zore3x.photoviewer.App;
import com.android.zore3x.photoviewer.R;
import com.android.zore3x.photoviewer.adapters.PhotosLineAdapter;
import com.android.zore3x.photoviewer.api.Unsplash;
import com.android.zore3x.photoviewer.api.model.Photo;
import com.android.zore3x.photoviewer.fragments.AllPhotosFragment;

import java.util.List;

public class AllPhotosActivity extends SingleFragmentActivity{



    @Override
    protected Fragment createFragment() {
        return AllPhotosFragment.newInstance();
    }

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, AllPhotosActivity.class);

        return intent;
    }

}
