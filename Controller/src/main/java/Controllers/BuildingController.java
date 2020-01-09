package Controllers;

import RealEstate.Exceptions.*;
import RealEstate.Modules.Building;
import RealEstate.Modules.BuildingType;
import Service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@RestController
public class BuildingController {
    private BuildingService service;

    public BuildingController(@Autowired BuildingService service) {
        this.service = service;
    }

    @RequestMapping(value = "/buildings/count", method = RequestMethod.GET)
    @ResponseBody
    public String showNumberOfBuildings(){
        return String.valueOf(service.getAllBuilding().size());
    }

    @RequestMapping(value = "/buildings", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Building> getAllBuildings(){
        return service.getAllBuilding();
    }

    @RequestMapping(value = "/buildings/add", method = RequestMethod.POST)
    @ResponseBody
    public Building addNewBuilding(Building building) throws InvalidDateException, InvalidAVValueException, InvalidRValueException,
                                                             InvalidUValueException, NoMatchingIdException {
        service.insertBuilding(building);
        return service.getBuilding(building.getId());
    }

    @RequestMapping(value = "/buildings/type/{type}", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Building> getBuildingByType(@PathVariable BuildingType type){
        Collection<Building> buildings = service.getAllBuilding();
        Collection<Building> list = new ArrayList<Building>();
        for (Building item : buildings){
            if (item.getBuildingType() == type){
                list.add(item);
            }
        }
        return list;
    }

    @RequestMapping(value = "/buildings/U/{U}", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Building> getBuildingByUValue(@PathVariable double U){
        Collection<Building> buildings = service.getAllBuilding();
        Collection<Building> list = new ArrayList<Building>();
        for (Building item : buildings){
            if (item.getU_Value() <= U){
                list.add(item);
            }
        }
        return list;
    }

    @RequestMapping(value = "/buildings/R/{R}", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Building> getBuildingByRValue(@PathVariable double R){
        Collection<Building> buildings = service.getAllBuilding();
        Collection<Building> list = new ArrayList<Building>();
        for (Building item : buildings){
            if (item.getR_Value() >= R){
                list.add(item);
            }
        }
        return list;
    }

    @RequestMapping(value = "/buildings/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Building getBuildingById(@PathVariable UUID id) throws NoMatchingIdException {
        return service.getBuilding(id);
    }

    @RequestMapping(value="/buildings/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteBuildingById(@PathVariable UUID id) throws NoMatchingIdException {
        service.deleteBuilding(id);
    }

    @RequestMapping(value="/buildings/update", method = RequestMethod.PUT)
    @ResponseBody
    public void updateBuilding(Building building) throws InvalidDateException, InvalidAVValueException, NoMatchingIdException,
                                                         InvalidRValueException, InvalidUValueException {
        service.updateBuilding(building);
    }
}