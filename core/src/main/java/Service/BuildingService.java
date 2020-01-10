package Service;

import RealEstate.Exceptions.*;
import RealEstate.Modules.Building;

import java.util.Collection;
import java.util.UUID;

public interface BuildingService {
    Building getBuilding(UUID id) throws NoMatchingIdException;
    Collection<Building> getAllBuilding();
    void deleteBuilding(Building building) throws NoMatchingIdException;
    void deleteBuilding(UUID id) throws NoMatchingIdException;
    void updateBuilding(UUID id, Building building) throws InvalidAVValueException, InvalidDateException, InvalidRValueException, InvalidUValueException, NoMatchingIdException;;
    void insertBuilding(Building building) throws InvalidAVValueException, InvalidDateException, InvalidRValueException, InvalidUValueException;;
}
