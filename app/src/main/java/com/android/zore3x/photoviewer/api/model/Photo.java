package com.android.zore3x.photoviewer.api.model;

import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("id")
    private String mId;
    @SerializedName("created_at")
    private String mCreateAt;
    @SerializedName("updated_at")
    private String mUpdateAt;
    @SerializedName("width")
    private long mWidth;
    @SerializedName("height")
    private long mHeight;
    @SerializedName("color")
    private String mColor;
    @SerializedName("downloads")
    private long mDownloads;
    @SerializedName("likes")
    private long mLikes;
    @SerializedName("liked_by_user")
    private boolean isLikedByUser;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("exif")
    private Exif mExif;
    @SerializedName("location")
    private Location mLocation;
    @SerializedName("urls")
    private Urls mUrls;
    @SerializedName("links")
    private DownloadLinks mLinks;
    @SerializedName("user")
    private User mUser;

    public Photo() {
    }

    public Photo(String id, String createAt, String updateAt, long width, long height, String color, long downloads, long likes, boolean isLikedByUser, String description, Exif exif, Location location, Urls urls, DownloadLinks links, User user) {
        mId = id;
        mCreateAt = createAt;
        mUpdateAt = updateAt;
        mWidth = width;
        mHeight = height;
        mColor = color;
        mDownloads = downloads;
        mLikes = likes;
        this.isLikedByUser = isLikedByUser;
        mDescription = description;
        mExif = exif;
        mLocation = location;
        mUrls = urls;
        mLinks = links;
        mUser = user;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getCreateAt() {
        return mCreateAt;
    }

    public void setCreateAt(String createAt) {
        mCreateAt = createAt;
    }

    public String getUpdateAt() {
        return mUpdateAt;
    }

    public void setUpdateAt(String updateAt) {
        mUpdateAt = updateAt;
    }

    public long getWidth() {
        return mWidth;
    }

    public void setWidth(long width) {
        mWidth = width;
    }

    public long getHeight() {
        return mHeight;
    }

    public void setHeight(long height) {
        mHeight = height;
    }

    public String getColor() {
        return mColor;
    }

    public void setColor(String color) {
        mColor = color;
    }

    public long getDownloads() {
        return mDownloads;
    }

    public void setDownloads(long downloads) {
        mDownloads = downloads;
    }

    public long getLikes() {
        return mLikes;
    }

    public void setLikes(long likes) {
        mLikes = likes;
    }

    public boolean isLikedByUser() {
        return isLikedByUser;
    }

    public void setLikedByUser(boolean likedByUser) {
        isLikedByUser = likedByUser;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Exif getExif() {
        return mExif;
    }

    public void setExif(Exif exif) {
        mExif = exif;
    }

    public Location getLocation() {
        return mLocation;
    }

    public void setLocation(Location location) {
        mLocation = location;
    }

    public Urls getUrls() {
        return mUrls;
    }

    public void setUrls(Urls urls) {
        mUrls = urls;
    }

    public DownloadLinks getLinks() {
        return mLinks;
    }

    public void setLinks(DownloadLinks links) {
        mLinks = links;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }
}
