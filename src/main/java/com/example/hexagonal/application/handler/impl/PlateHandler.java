package com.example.hexagonal.application.handler.impl;

import com.example.hexagonal.application.dto.request.CategoryRequestDto;
import com.example.hexagonal.application.dto.request.PlateRequestDto;
import com.example.hexagonal.application.dto.response.CategoryResponseDto;
import com.example.hexagonal.application.dto.response.PlateResponseDto;
import com.example.hexagonal.application.handler.ICategoryHandler;
import com.example.hexagonal.application.handler.IPlateHandler;
import com.example.hexagonal.application.mapper.ICategoryRequestMapper;
import com.example.hexagonal.application.mapper.ICategoryResponseMapper;
import com.example.hexagonal.application.mapper.IPlateRequestMapper;
import com.example.hexagonal.application.mapper.IPlateResponseMapper;
import com.example.hexagonal.domain.api.ICategoryServicePort;
import com.example.hexagonal.domain.api.IPlateServicePort;
import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.PlateModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor //Crea los constructores para los atributos definidos como finales
@Transactional
public class PlateHandler implements IPlateHandler {

    private final IPlateServicePort plateServicePort;
    private final IPlateRequestMapper plateRequestMapper;
    private final IPlateResponseMapper plateResponseMapper;

    @Override
    public void savePlate(PlateRequestDto plateRequestDto) {
        PlateModel plateModel = plateRequestMapper.toPlateModel(plateRequestDto);
        plateServicePort.savePlate(plateModel);
    }

    @Override
    public List<PlateResponseDto> getAllPlates() {

        return plateResponseMapper.toResponseList(plateServicePort.getAllPlates());
    }

    @Override
    public PlateModel getPlateById(Long idPlate) {
        PlateModel plate=plateServicePort.getPlateByIdPlate(idPlate);

        return plate;


    }


}