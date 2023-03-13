package com.example.hexagonal.infrastructure.out.jpa.adapter;

import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.PlateModel;
import com.example.hexagonal.domain.spi.ICategoryPersistencePort;
import com.example.hexagonal.domain.spi.IPlatePersistencePort;
import com.example.hexagonal.infrastructure.exception.NoDataFoundException;
import com.example.hexagonal.infrastructure.out.jpa.entity.CategoryEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.PlateEntity;
import com.example.hexagonal.infrastructure.out.jpa.mapper.ICategoryEntityMapper;
import com.example.hexagonal.infrastructure.out.jpa.mapper.IPlateEntityMapper;
import com.example.hexagonal.infrastructure.out.jpa.repository.ICategoryRepository;
import com.example.hexagonal.infrastructure.out.jpa.repository.IPlateRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PlateJpaAdapter implements IPlatePersistencePort {

    private final IPlateRepository plateRepository;
    private final IPlateEntityMapper plateEntityMapper;


    @Override
    public PlateModel savePlate(PlateModel plateModel) {
        System.out.println("platemodel.getCategoryEntity:"+plateModel.getCategoryEntity());
        System.out.println("platemodel.idcategory:"+plateModel.getIdCategory());
        PlateEntity plateEntity = plateRepository.save(plateEntityMapper.toEntity(plateModel));
        return plateEntityMapper.toPlateModel(plateEntity);
    }

    @Override
    public List<PlateModel> getAllPlates() {
        List<PlateEntity> entityList = plateRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return plateEntityMapper.toPlateModelList(entityList);
    }

    @Override
    public PlateModel getPlateByIdPlate(Long idPlate) {
        PlateEntity plateEntity=plateRepository.findByIdPlate(idPlate);
        PlateModel plateModel=plateEntityMapper.toPlateModel(plateEntity);
        return plateModel;

    }
}