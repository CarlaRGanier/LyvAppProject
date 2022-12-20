package com.example.applyv.ui.api;

import com.example.applyv.ui.api.models.FoodSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FoodService {

    @GET("search")
    Call<FoodSearchResponse> getFoodInfo(@Query("categories_tags_en") String categories);

}
