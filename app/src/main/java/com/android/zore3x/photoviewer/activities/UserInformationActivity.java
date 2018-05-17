package com.android.zore3x.photoviewer.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.android.zore3x.photoviewer.fragments.UserInformationFragment;

public class UserInformationActivity extends SingleFragmentActivity {

    private static final String EXTRA_USER_NAME = "com.android.zore3x.photoviewer.activities.extra_user_name";

    @Override
    protected Fragment createFragment() {

        if(getIntent().hasExtra(EXTRA_USER_NAME)) {
            String username = getIntent().getStringExtra(EXTRA_USER_NAME);

            return UserInformationFragment.newInstance(username);
        }
        return null;
    }

    public static Intent newIntent(Context packageContext, String username) {
        Intent intent = new Intent(packageContext, UserInformationActivity.class);

        intent.putExtra(EXTRA_USER_NAME, username);

        return intent;
    }

}
