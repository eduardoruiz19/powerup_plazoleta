package com.example.hexagonal.domain.spi;

import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.ObjectModel;

import java.util.List;


/*  PUERTO DE PERSISTENCIA */
public interface ICategoryPersistencePort {
    CategoryModel saveCategory(CategoryModel categoryModel);

    List<CategoryModel> getAllCategories();

    CategoryModel getCategoryByCategory_id(long id);
}