package com.android.zore3x.photoviewer.api.endpoints;

import android.support.annotation.Nullable;

import com.android.zore3x.photoviewer.api.model.Download;
import com.android.zore3x.photoviewer.api.model.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PhotosEndpoints {

    @GET("/photos")
    Call<List<Photo>> getPhotos(@Query("page") Integer page, @Query("per_page") @Nullable Integer perPage,
                                @Query("order_by") @Nullable String orderBy);

    @GET("/photos/{id}")
    Call<Photo> getPhoto(@Path("id") String id, @Query("w") Integer w, @Query("h") Integer h);

    @GET("/photos/{id}/download")
    Call<Download> getDownloadLink(@Path("id") String id);

}
