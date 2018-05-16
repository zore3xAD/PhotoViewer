package com.android.zore3x.photoviewer.api.endpoints;

import com.android.zore3x.photoviewer.api.model.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PhotosEndpoints {

    @GET("/photos")
    Call<List<Photo>> getPhotos(@Query("page") int page, @Query("per_page") int perPage,
                                @Query("order_by") String orderBy);

}
