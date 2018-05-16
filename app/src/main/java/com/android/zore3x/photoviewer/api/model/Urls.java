package com.android.zore3x.photoviewer.api.model;

import com.google.gson.annotations.SerializedName;

class Urls {

    @SerializedName("raw")
    private String mRaw;
    @SerializedName("full")
    private String mFull;
    @SerializedName("regular")
    private String mRegular;
    @SerializedName("small")
    private String mSmall;
    @SerializedName("thumb")
    private String mThumb;

    public Urls() {
    }

    public Urls(String raw, String full, String regular, String small, String thumb) {
        mRaw = raw;
        mFull = full;
        mRegular = regular;
        mSmall = small;
        mThumb = thumb;
    }

    public String getRaw() {
        return mRaw;
    }

    public void setRaw(String raw) {
        mRaw = raw;
    }

    public String getFull() {
        return mFull;
    }

    public void setFull(String full) {
        mFull = full;
    }

    public String getRegular() {
        return mRegular;
    }

    public void setRegular(String regular) {
        mRegular = regular;
    }

    public String getSmall() {
        return mSmall;
    }

    public void setSmall(String small) {
        mSmall = small;
    }

    public String getThumb() {
        return mThumb;
    }

    public void setThumb(String thumb) {
        mThumb = thumb;
    }
}
