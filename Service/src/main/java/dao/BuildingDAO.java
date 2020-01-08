package dao;

import RealEstate.Exceptions.*;
import RealEstate.Modules.Building;
import com.sun.management.GarbageCollectionNotificationInfo;

import java.util.Collection;
import java.util.UUID;

public interface BuildingDAO {
    void createBuilding(Building building) throws InvalidAVValueException, InvalidDateException, InvalidRValueException, InvalidUValueException;
    Collection<Building> readAllBuildings();
    Building readBuilding(UUID id);
    void updateBuilding(Building building) throws InvalidAVValueException, InvalidDateException, InvalidRValueException, InvalidUValueException, NoMatchingIdException;
    void deleteBuilding(Building building) throws NoMatchingIdException;
}
