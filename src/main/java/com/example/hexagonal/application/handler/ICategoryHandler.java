package com.example.hexagonal.application.handler;


import com.example.hexagonal.application.dto.request.CategoryRequestDto;
import com.example.hexagonal.application.dto.response.CategoryResponseDto;
import com.example.hexagonal.domain.model.CategoryModel;

import java.util.List;

public interface ICategoryHandler {

    void saveCategory(CategoryRequestDto categoryRequestDto);

    List<CategoryResponseDto> getAllCategories();

    List<CategoryResponseDto> findAllPlatesByRestaurantIdWithPagination(long l);

    CategoryModel getCategoryModelByCategory_id(Long idCategory);



}