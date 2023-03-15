package com.example.hexagonal.application.handler.impl;

import com.example.hexagonal.application.dto.request.CategoryRequestDto;
import com.example.hexagonal.application.dto.response.CategoryResponseDto;
import com.example.hexagonal.application.handler.ICategoryHandler;
import com.example.hexagonal.application.mapper.ICategoryRequestMapper;
import com.example.hexagonal.application.mapper.ICategoryResponseMapper;
import com.example.hexagonal.domain.api.ICategoryServicePort;
import com.example.hexagonal.domain.model.CategoryModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor //Crea los constructores para los atributos definidos como finales
@Transactional
public class CategoryHandler implements ICategoryHandler {

    private final ICategoryServicePort categoryServicePort;
    private final ICategoryRequestMapper categoryRequestMapper;
    private final ICategoryResponseMapper categoryResponseMapper;

    @Override
    public void saveCategory(CategoryRequestDto categoryRequestDto) {
        CategoryModel categoryModel = categoryRequestMapper.toCategory(categoryRequestDto);
        categoryServicePort.saveCategory(categoryModel);
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return categoryResponseMapper.toResponseList(categoryServicePort.getAllCategories());
    }




    @Override
    public List<CategoryResponseDto> findAllPlatesByRestaurantIdWithPagination(long l) {
        return null;
    }

    @Override
    public CategoryModel getCategoryModelByCategory_id(Long idCategory) {
        CategoryModel categoryModel = categoryServicePort.getCategoryByCategory_id(idCategory);
        return categoryModel;
    }



}