package com.android.zore3x.photoviewer.api;

import com.android.zore3x.photoviewer.api.endpoints.PhotosEndpoints;
import com.android.zore3x.photoviewer.api.model.Photo;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Unsplash {

    // Listeners

    public interface OnPhotosLoadedListener {
        void onComplete(List<Photo> photos);

        void onError(String error);
    }



    public static final String BASE_URL = "https://api.unsplash.com";

    private String mClientId;

    private PhotosEndpoints mPhotosApiService;

    public Unsplash(String clientId) {
        mClientId = clientId;

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor(mClientId)).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mPhotosApiService = retrofit.create(PhotosEndpoints.class);
    }

    // Функция вызываемая из вне
    public void getPhotos(Integer page, Integer perPage, Order order, final OnPhotosLoadedListener listener){
        Call<List<Photo>> call;
        if(order == null) {
            call = mPhotosApiService.getPhotos(page, perPage, null);
        } else {
            call = mPhotosApiService.getPhotos(page, perPage, order.getOrder());
        }
        call.enqueue(getMultiplePhotoCallback(listener));
    }

    // Callbacks

    // обработка запроса
    private Callback<List<Photo>> getMultiplePhotoCallback(final OnPhotosLoadedListener listener) {
        return new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {

                int statusCode = response.code();

                if (statusCode == 200) {
                    List<Photo> photos = response.body();
                    // передача слушателю полученные данные
                    listener.onComplete(photos);
                }

            }
            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                // передача случателю сообщения об ошибке
                listener.onError(t.getMessage());
            }
        };
    }
}
