package com.example.applyv.ui.api;

import android.util.Log;

import com.example.applyv.ui.api.models.FoodSearchResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper {
    private Retrofit retrofit;

    public ApiHelper() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public void getFoodInfo() {
        FoodService service = retrofit.create(FoodService.class);
        Call<FoodSearchResponse> foodInfo = service.getFoodInfo("chocolate");
        foodInfo.enqueue(new Callback<FoodSearchResponse>() {
            @Override
            public void onResponse(Call<FoodSearchResponse> call, Response<FoodSearchResponse> response) {
                if (response.isSuccessful()) {
                    FoodSearchResponse foodSearchResponse = response.body();

                }
            }

            @Override
            public void onFailure(Call<FoodSearchResponse> call, Throwable t) {

            }
        });
    }
}
