package com.android.zore3x.photoviewer.api.endpoints;

import com.android.zore3x.photoviewer.api.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UsersEndpoints {

    @GET("/users/{username}")
    Call<User> getUser(@Path("username") String username);

}
