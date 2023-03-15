package com.example.hexagonal.domain.usecase;

import com.example.hexagonal.domain.api.ICategoryServicePort;
import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.spi.ICategoryPersistencePort;

import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {

    /* APLICAR INYECCIÓN DE DEPENDENCIAS EN EL CONSTRUCTOR  -  NO USAR AUTOWIRED */
    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(CategoryModel objectModel) {
        categoryPersistencePort.saveCategory(objectModel);
    }

    @Override
    public List<CategoryModel> getAllCategories() {
        return categoryPersistencePort.getAllCategories();
    }



    @Override
    public CategoryModel getCategoryByCategory_id(long id) {
        return  categoryPersistencePort.getCategoryByCategory_id(id);
    }



}