package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;

import com.example.recipeapp.data.remote.CategoriesApiManager;

public class MainApplication extends Application {

    public static CategoriesApiManager categoriesApiManager;
    @Override
    public void onCreate() {
        super.onCreate();
        categoriesApiManager = CategoriesApiManager.getInstance();

    }
}