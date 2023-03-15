package com.example.hexagonal.domain.api;

import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.ObjectModel;

import java.util.List;


/* MÉTODOS QUE NOS INTERESA QUE EXPONGA NUESTRO DOMINIO  */
public interface ICategoryServicePort {

    void saveCategory(CategoryModel categoryModel);

    List<CategoryModel> getAllCategories();


    CategoryModel getCategoryByCategory_id(long id);



}