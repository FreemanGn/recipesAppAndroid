package com.example.recipeapp.ui.fragments.categories;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.recipeapp.data.repositories.CategoriesRepository;
import com.example.recipeapp.models.Category;

import java.util.List;

public class CategoriesViewModel extends ViewModel {

    private final CategoriesRepository repository;

    public CategoriesViewModel(CategoriesRepository repository){
        this.repository=repository;
    }
    public MutableLiveData<List<Category>> getCategories(){

        return repository.getCategories();
    }

    public MutableLiveData<Category> getCategoryById(String id){
        return repository.getCategoryById(id);
    }
}
