package com.example.hexagonal.domain.api;

import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.PlateModel;

import java.util.List;


/* MÉTODOS QUE NOS INTERESA QUE EXPONGA NUESTRO DOMINIO  */
public interface IPlateServicePort {

    void savePlate(PlateModel plateModel);

    List<PlateModel> getAllPlates();
}