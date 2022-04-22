package com.example.recipeapp.data.remote;

import com.example.recipeapp.models.Category;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ICategoriesApi {

    @GET("Categories")
    Call<List<Category>> getCategories();

    @GET("Categories/{id}")
    Call<Category> getCategoriesById(@Path("id") String id);
}
