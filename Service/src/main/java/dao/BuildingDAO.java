package dao;

import RealEstate.Exceptions.*;
import RealEstate.Modules.Building;
import com.sun.management.GarbageCollectionNotificationInfo;

import java.util.Collection;
import java.util.UUID;

public interface BuildingDAO {
    void createBuilding(Building building);
    Collection<Building> readAllBuildings();
    Building readBuilding(UUID id) throws NoMatchingIdException;
    void updateBuilding(UUID id, Building building) throws NoMatchingIdException;
    void deleteBuilding(Building building) throws NoMatchingIdException;
}
