package com.example.recipeapp.ui.fragments.categories;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recipeapp.R;
import com.example.recipeapp.databinding.FragmentCategoriesBinding;
import com.example.recipeapp.models.Category;

import java.util.List;


public class CategoriesFragment extends Fragment {

    private FragmentCategoriesBinding binding;
    private CategoriesViewModel viewModel;
    private CategoriesAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentCategoriesBinding.inflate(inflater, container, false);
        binding.categoriesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter=new CategoriesAdapter(getContext());

        viewModel=new ViewModelProvider(this, new CategoriesViewModelFactory()).get(CategoriesViewModel.class);
        viewModel.getCategories().observe(getViewLifecycleOwner(), new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                if (categories!=null)
                    adapter.setCategories(categories);
            }
        });
        binding.setAdapter(adapter);
        return binding.getRoot();
    }
}