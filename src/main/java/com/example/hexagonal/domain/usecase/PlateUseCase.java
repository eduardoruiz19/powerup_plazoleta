package com.example.hexagonal.domain.usecase;

import com.example.hexagonal.application.dto.request.PlateRequestDto;
import com.example.hexagonal.domain.api.ICategoryServicePort;
import com.example.hexagonal.domain.api.IPlateServicePort;
import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.PlateModel;
import com.example.hexagonal.domain.spi.ICategoryPersistencePort;
import com.example.hexagonal.domain.spi.IPlatePersistencePort;

import java.util.List;

public class PlateUseCase implements IPlateServicePort {

    /* APLICAR INYECCIÓN DE DEPENDENCIAS EN EL CONSTRUCTOR  -  NO USAR AUTOWIRED */
    private final IPlatePersistencePort platePersistencePort;

    public PlateUseCase(IPlatePersistencePort platePersistencePort) {
        this.platePersistencePort = platePersistencePort;
    }

    @Override
    public void savePlate(PlateModel plateModel) {
        platePersistencePort.savePlate(plateModel);
    }

    @Override
    public List<PlateModel> getAllPlates() {
        return platePersistencePort.getAllPlates();
    }

    @Override
    public List<PlateModel> getAllPlatesByid_restaurantOrderByidCategory(long restaurant_id) {
        return null;
    }

    @Override
    public PlateModel getPlateByIdPlate(Long idPlate) {
        return platePersistencePort.getPlateByIdPlate(idPlate);
    }
}