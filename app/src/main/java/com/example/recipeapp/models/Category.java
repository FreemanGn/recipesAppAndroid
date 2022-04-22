package com.example.recipeapp.models;

public class Category {
    private int id;
    private String Categorie_name;
    private String Image_link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategorie_name() {
        return Categorie_name;
    }

    public void setCategorie_name(String categorie_name) {
        Categorie_name = categorie_name;
    }

    public String getImage_link() {
        return Image_link;
    }

    public void setImage_link(String image_link) {
        Image_link = image_link;
    }
}
