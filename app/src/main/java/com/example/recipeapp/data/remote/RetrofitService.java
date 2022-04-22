package com.example.recipeapp.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static String BASE_URL ="https://localhost:5001/api/";
    private static Retrofit retrofit;
    private static ICategoriesApi categoriesApi;

    private static Retrofit getInstance(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static ICategoriesApi getCategoriesApi(){
        if(categoriesApi==null)
            categoriesApi=getInstance().create(ICategoriesApi.class);
        return categoriesApi;
    }

}
