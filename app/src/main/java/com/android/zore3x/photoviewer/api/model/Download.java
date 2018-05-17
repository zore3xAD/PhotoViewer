package com.android.zore3x.photoviewer.api.model;

import com.google.gson.annotations.SerializedName;

public class Download {

    @SerializedName("url")
    private String mUrl;

    public Download() {
    }

    public Download(String url) {
        mUrl = url;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
