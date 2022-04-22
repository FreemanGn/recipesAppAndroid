package com.example.recipeapp.data.repositories;

import android.util.Log;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.recipeapp.data.remote.CategoriesApiManager;
import com.example.recipeapp.models.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesRepository {
    private final String TAG = Category.class.getSimpleName();
    private static volatile CategoriesRepository instance;
    private final CategoriesApiManager apiManager;
    private final MutableLiveData categories = new MutableLiveData();
    private final MutableLiveData category = new MutableLiveData();

    private CategoriesRepository (CategoriesApiManager apiManager){
        this.apiManager =apiManager;
    }

    public static CategoriesRepository getInstance(CategoriesApiManager apiManager){
        if (instance == null) {
            instance = new CategoriesRepository(apiManager);
        }
        return instance;
    }

    public MutableLiveData getCategories(){
        Log.d(TAG, "onResponse: " );
        apiManager.getCategories(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {

                if(response.isSuccessful())
                    categories.setValue(response.body());
                else
                    categories.postValue(null);
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.d(TAG, "onResponse: "+ t.getMessage() );
                categories.postValue(null);
            }
        });
        return categories;
    }
    public MutableLiveData getCategoryById(String id) {
        apiManager.getCategoryById(id, new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                if(response.isSuccessful())
                    category.setValue(response.body());
                else
                    category.postValue(null);
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                category.postValue(null);
            }
        });
        return category;
    }


}
