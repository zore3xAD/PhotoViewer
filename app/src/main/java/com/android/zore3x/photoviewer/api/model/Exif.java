package com.android.zore3x.photoviewer.api.model;

import com.google.gson.annotations.SerializedName;

public class Exif {

    @SerializedName("make")
    private String mMake;
    @SerializedName("model")
    private String mModel;
    @SerializedName("exposure_time")
    private String mExposureTime;
    @SerializedName("aperture")
    private String mAperture;
    @SerializedName("focal_length")
    private String mFocalLength;
    @SerializedName("iso")
    private int mIso;

    public Exif() {
    }

    public Exif(String make, String model, String exposureTime, String aperture, String focalLength, int iso) {
        mMake = make;
        mModel = model;
        mExposureTime = exposureTime;
        mAperture = aperture;
        mFocalLength = focalLength;
        mIso = iso;
    }

    public String getMake() {
        return mMake;
    }

    public void setMake(String make) {
        mMake = make;
    }

    public String getModel() {
        return mModel;
    }

    public void setModel(String model) {
        mModel = model;
    }

    public String getExposureTime() {
        return mExposureTime;
    }

    public void setExposureTime(String exposureTime) {
        mExposureTime = exposureTime;
    }

    public String getAperture() {
        return mAperture;
    }

    public void setAperture(String aperture) {
        mAperture = aperture;
    }

    public String getFocalLength() {
        return mFocalLength;
    }

    public void setFocalLength(String focalLength) {
        mFocalLength = focalLength;
    }

    public int getIso() {
        return mIso;
    }

    public void setIso(int iso) {
        mIso = iso;
    }
}
