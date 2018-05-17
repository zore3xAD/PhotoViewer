package com.android.zore3x.photoviewer.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.android.zore3x.photoviewer.fragments.UserInformationFragment;

public class UserInformationActivity extends SingleFragmentActivity {

    private static final String EXTRA_USER_ID = "com.android.zore3x.photoviewer.activities.extra_user_id";

    @Override
    protected Fragment createFragment() {

        if(getIntent().hasExtra(EXTRA_USER_ID)) {
            String userId = getIntent().getStringExtra(EXTRA_USER_ID);

            return UserInformationFragment.newInstance(userId);
        }
        return null;
    }

    public static Intent newIntent(Context packageContext, String userId) {
        Intent intent = new Intent(packageContext, AllPhotosActivity.class);

        intent.putExtra(EXTRA_USER_ID, userId);

        return intent;
    }

}
