package com.example.recipeapp.data.remote;

import com.example.recipeapp.models.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class CategoriesApiManager {
    private ICategoriesApi categoriesApi;
    private static CategoriesApiManager apiManager;

    private CategoriesApiManager(){
        categoriesApi = RetrofitService.getCategoriesApi();
    }

    public static CategoriesApiManager getInstance() {
        if (apiManager == null) {
            apiManager = new CategoriesApiManager();
        }
        return apiManager;
    }
    public void getCategories(Callback<List<Category>> callback){
        Call<List<Category>> categoriesCall = categoriesApi.getCategories();
        categoriesCall.enqueue(callback);
    }

    public void getCategoryById(String  id , Callback<Category> callback){
        Call<Category> categoryByIdCall = categoriesApi.getCategoriesById(id);
        categoryByIdCall.enqueue(callback);
    }
}
