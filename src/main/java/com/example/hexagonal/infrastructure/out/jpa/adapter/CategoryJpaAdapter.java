package com.example.hexagonal.infrastructure.out.jpa.adapter;

import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.ObjectModel;
import com.example.hexagonal.domain.spi.ICategoryPersistencePort;
import com.example.hexagonal.domain.spi.IObjectPersistencePort;
import com.example.hexagonal.infrastructure.exception.NoDataFoundException;
import com.example.hexagonal.infrastructure.out.jpa.entity.CategoryEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.ObjectEntity;
import com.example.hexagonal.infrastructure.out.jpa.mapper.ICategoryEntityMapper;
import com.example.hexagonal.infrastructure.out.jpa.mapper.IObjectEntityMapper;
import com.example.hexagonal.infrastructure.out.jpa.repository.ICategoryRepository;
import com.example.hexagonal.infrastructure.out.jpa.repository.IObjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort {

    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;


    @Override
    public CategoryModel saveCategory(CategoryModel categoryModel) {
        CategoryEntity categoryEntity = categoryRepository.save(categoryEntityMapper.toEntity(categoryModel));
        return categoryEntityMapper.toCategoryModel(categoryEntity);
    }

    @Override
    public List<CategoryModel> getAllCategories() {
        List<CategoryEntity> entityList = categoryRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return categoryEntityMapper.toCategoryModelList(entityList);
    }




    @Override
    public CategoryModel getCategoryByCategory_id(long id) {
    CategoryEntity categoryEntity = categoryRepository.findByIdCategory(id);
        return categoryEntityMapper.toCategoryModel(categoryEntity);
    }
}