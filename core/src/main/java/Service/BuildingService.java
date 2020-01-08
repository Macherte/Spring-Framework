package Service;

import RealEstate.Modules.Building;

import java.util.Collection;
import java.util.UUID;

public interface BuildingService {
    Building getBuilding(UUID id);
    Collection<Building> getAllBuilding();
    void deleteBuilding(Building building);
    void deleteBuilding(UUID id);
    void updateBuilding(Building building);
    void insertBuilding(Building building);
}
