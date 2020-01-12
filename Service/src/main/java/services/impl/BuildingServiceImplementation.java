package services.impl;

import RealEstate.Exceptions.*;
import RealEstate.Modules.Building;
import Service.BuildingService;
import dao.BuildingDAO;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public class BuildingServiceImplementation implements BuildingService {
    BuildingDAO dao;

    public BuildingServiceImplementation(BuildingDAO dao) {
        this.dao = dao;
    }

    public Building getBuilding(UUID id) throws NoMatchingIdException {
        return dao.readBuilding(id);
    }

    public Collection<Building> getAllBuilding() {
        return dao.readAllBuildings();
    }

    public void deleteBuilding(UUID id) throws NoMatchingIdException {
        Building building = dao.readBuilding(id);
        dao.deleteBuilding(building);
    }

    public void updateBuilding(UUID id, Building building) throws InvalidAVValueException, InvalidDateException, InvalidRValueException,
                                                         InvalidUValueException, NoMatchingIdException {
        if (building.getAV_Value() < 0) throw new InvalidAVValueException();
        if (!(building.getR_Value() > 0 && building.getR_Value() < 60)) throw new InvalidRValueException();
        if (!(building.getU_Value() > 0 && building.getU_Value() < 10)) throw new InvalidUValueException();
        if (building.getYearOfConstruction().isAfter(LocalDate.now().plusYears(3))) throw new InvalidDateException();

        dao.updateBuilding(id, building);
    }

    public void insertBuilding(Building building) throws InvalidAVValueException, InvalidDateException, InvalidRValueException,
                                                         InvalidUValueException {
        if (building.getAV_Value() < 0) throw new InvalidAVValueException();
        if (!(building.getR_Value() > 0 && building.getR_Value() < 60)) throw new InvalidRValueException();
        if (!(building.getU_Value() > 0 && building.getU_Value() < 10)) throw new InvalidUValueException();
        if (building.getYearOfConstruction().isAfter(LocalDate.now().plusYears(3))) throw new InvalidDateException();

        dao.createBuilding(building);
    }
}
