package com.example.hexagonal.domain.spi;

import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.PlateModel;

import java.util.List;


/*  PUERTO DE PERSISTENCIA */
public interface IPlatePersistencePort {
    PlateModel savePlate(PlateModel plateModel);

    List<PlateModel> getAllPlates();


    PlateModel getPlateByIdPlate(Long idPlate);
}