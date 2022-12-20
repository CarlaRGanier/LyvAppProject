package com.example.applyv.ui.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodSearchResponse {
    @SerializedName("count")
    private int count;

    @SerializedName("products")
    List<Product> products;

    public int getCount() {
        return count;
    }
}
