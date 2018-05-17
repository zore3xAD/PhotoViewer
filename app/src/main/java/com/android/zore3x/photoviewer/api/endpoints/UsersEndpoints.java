package com.android.zore3x.photoviewer.api.endpoints;

import com.android.zore3x.photoviewer.api.Order;
import com.android.zore3x.photoviewer.api.model.Photo;
import com.android.zore3x.photoviewer.api.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UsersEndpoints {

    @GET("/users/{username}")
    Call<User> getUser(@Path("username") String username);

    @GET("/users/{username}/photos")
    Call<List<Photo>> getUserPhotos(@Path("username") String username,
                                    @Query("page") Integer page,
                                    @Query("per_page") Integer perPage,
                                    @Query("order_by") String orderBy);

}
