package com.android.zore3x.photoviewer.api.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private String mId;
    @SerializedName("update_at")
    private String mUpdatedAt;
    @SerializedName("username")
    private String mUsername;
    @SerializedName("name")
    private String mName;
    @SerializedName("portfolio_url")
    private String mPortfolioUrl;
    @SerializedName("bio")
    private String mBio;
    @SerializedName("location")
    private String mLocation;
    @SerializedName("total_likes")
    private int mTotalLikes;
    @SerializedName("total_collections")
    private int mTotalCollections;
    @SerializedName("links")
    private Links mLinks;
    @SerializedName("profile_image")
    private ProfileImage mProfileImage;

    public User() {
    }

    public User(String id, String updatedAt, String username, String name, String portfolioUrl, String bio, String location, int totalLikes, int totalCollections, Links links, ProfileImage profileImage) {
        mId = id;
        mUpdatedAt = updatedAt;
        mUsername = username;
        mName = name;
        mPortfolioUrl = portfolioUrl;
        mBio = bio;
        mLocation = location;
        mTotalLikes = totalLikes;
        mTotalCollections = totalCollections;
        mLinks = links;
        mProfileImage = profileImage;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPortfolioUrl() {
        return mPortfolioUrl;
    }

    public void setPortfolioUrl(String portfolioUrl) {
        mPortfolioUrl = portfolioUrl;
    }

    public String getBio() {
        return mBio;
    }

    public void setBio(String bio) {
        mBio = bio;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public int getTotalLikes() {
        return mTotalLikes;
    }

    public void setTotalLikes(int totalLikes) {
        mTotalLikes = totalLikes;
    }

    public int getTotalCollections() {
        return mTotalCollections;
    }

    public void setTotalCollections(int totalCollections) {
        mTotalCollections = totalCollections;
    }

    public Links getLinks() {
        return mLinks;
    }

    public void setLinks(Links links) {
        mLinks = links;
    }

    public ProfileImage getProfileImage() {
        return mProfileImage;
    }

    public void setProfileImage(ProfileImage profileImage) {
        mProfileImage = profileImage;
    }
}
