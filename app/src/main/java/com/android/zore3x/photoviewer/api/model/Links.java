package com.android.zore3x.photoviewer.api.model;

import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("self")
    private String mSelf;
    @SerializedName("html")
    private String mHtml;
    @SerializedName("photos")
    private String mPhotos;
    @SerializedName("likes")
    private String mLikes;
    @SerializedName("portfolio")
    private String mPortfolio;

    public Links() {
    }

    public Links(String self, String html, String photos, String likes, String portfolio) {
        mSelf = self;
        mHtml = html;
        mPhotos = photos;
        mLikes = likes;
        mPortfolio = portfolio;
    }

    public String getSelf() {
        return mSelf;
    }

    public void setSelf(String self) {
        mSelf = self;
    }

    public String getHtml() {
        return mHtml;
    }

    public void setHtml(String html) {
        mHtml = html;
    }

    public String getPhotos() {
        return mPhotos;
    }

    public void setPhotos(String photos) {
        mPhotos = photos;
    }

    public String getLikes() {
        return mLikes;
    }

    public void setLikes(String likes) {
        mLikes = likes;
    }

    public String getPortfolio() {
        return mPortfolio;
    }

    public void setPortfolio(String portfolio) {
        mPortfolio = portfolio;
    }
}
