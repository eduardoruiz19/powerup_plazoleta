package com.example.hexagonal.domain.spi;

import com.example.hexagonal.domain.model.CategoryModel;

import java.util.List;


/*  PUERTO DE PERSISTENCIA */
public interface ICategoryPersistencePort {
    CategoryModel saveCategory(CategoryModel categoryModel);

    List<CategoryModel> getAllCategories();

    List<CategoryModel> getCategoriesByRestaurant_id(long l);
    CategoryModel getCategoryByCategory_id(long id);
}