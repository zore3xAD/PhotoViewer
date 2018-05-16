package com.android.zore3x.photoviewer;

import android.app.Application;

import com.android.zore3x.photoviewer.api.Unsplash;

public class App extends Application {

    private static final String CLIENT_ID = "e83deeb4b720fde9e40ae1cb8ea68b9d5cb8357b5415cdfd567881b234c9bbbc";

    private static Unsplash mUnsplash;

    @Override
    public void onCreate() {
        super.onCreate();

        mUnsplash = new Unsplash(CLIENT_ID);

    }

    public static Unsplash getUnsplash() {
        return mUnsplash;
    }
}
