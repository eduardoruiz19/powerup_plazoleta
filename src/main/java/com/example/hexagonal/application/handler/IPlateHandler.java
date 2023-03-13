package com.example.hexagonal.application.handler;


import com.example.hexagonal.application.dto.request.CategoryRequestDto;
import com.example.hexagonal.application.dto.request.PlateRequestDto;
import com.example.hexagonal.application.dto.response.CategoryResponseDto;
import com.example.hexagonal.application.dto.response.PlateResponseDto;
import com.example.hexagonal.domain.model.PlateModel;

import java.util.List;

public interface IPlateHandler {

    void savePlate(PlateRequestDto plateRequestDto);

    List<PlateResponseDto> getAllPlates();

    PlateModel getPlateById(Long idPlate);
}