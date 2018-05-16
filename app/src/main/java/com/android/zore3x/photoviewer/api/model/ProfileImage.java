package com.android.zore3x.photoviewer.api.model;

import com.google.gson.annotations.SerializedName;

public class ProfileImage {

    @SerializedName("small")
    private String mSmall;
    @SerializedName("medium")
    private String mMedium;
    @SerializedName("large")
    private String mLarge;

    public ProfileImage() {
    }

    public ProfileImage(String small, String medium, String large) {
        mSmall = small;
        mMedium = medium;
        mLarge = large;
    }

    public String getSmall() {
        return mSmall;
    }

    public void setSmall(String small) {
        mSmall = small;
    }

    public String getMedium() {
        return mMedium;
    }

    public void setMedium(String medium) {
        mMedium = medium;
    }

    public String getLarge() {
        return mLarge;
    }

    public void setLarge(String large) {
        mLarge = large;
    }
}
