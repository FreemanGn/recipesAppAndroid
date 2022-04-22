package com.example.recipeapp.ui.fragments.categories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.databinding.CategoryItemBinding;
import com.example.recipeapp.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder>  {
    @NonNull
    private final Context context;
    private List<Category> categories;
    //private final AdapterView.OnItemClickListener<Category> onCategoryClickListener;

/*    public List<Category> getCategories() {
        return categories;
    }*/

    public void setCategories(List<Category> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }

    public CategoriesAdapter(@NonNull Context context) {
        this.context = context;
        categories = new ArrayList<>();
        //this.onCategoryClickListener = onCategoryClickListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CategoryItemBinding itemBinding = CategoryItemBinding.inflate(layoutInflater, parent, false);
        ViewHolder holder = new ViewHolder(itemBinding);
        holder.itemView.setOnClickListener((view -> {
            //fragment.editExpense(view, expenses.get(holder.getAdapterPosition()));
        }));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryItemBinding.setCategory(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories == null ? 0 : categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CategoryItemBinding categoryItemBinding;

        public ViewHolder(@NonNull CategoryItemBinding itemView) {
            super(itemView.getRoot());
            categoryItemBinding = itemView;
        }
    }
}
