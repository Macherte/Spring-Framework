package dao.impl.json;

import RealEstate.Exceptions.*;
import RealEstate.Modules.Building;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dao.BuildingDAO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class BuildingDAOJSON implements BuildingDAO {
    File jsonFile;
    ObjectMapper mapper;

    public BuildingDAOJSON(File jsonFile) {
        this.jsonFile = jsonFile;

        if(!jsonFile.exists()){
            try{
                jsonFile.createNewFile();
                FileWriter writer = new FileWriter(jsonFile);
                writer.write("[]");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
    }

    public BuildingDAOJSON(String jsonFilePath) {
        this.jsonFile = new File(jsonFilePath);

        if(!jsonFile.exists()){
            try{
                jsonFile.createNewFile();
                FileWriter writer = new FileWriter(jsonFilePath);
                writer.write("[]");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
    }

    public void createBuilding(Building building) {
        Collection<Building> buildings = readAllBuildings();
        buildings.add(building);

        try{
            mapper.writeValue(jsonFile, buildings);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Collection<Building> readAllBuildings() {
        Collection<Building> buildings = new ArrayList<Building>();
        try{
            buildings = mapper.readValue(jsonFile, new TypeReference<ArrayList<Building>>() {});
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return buildings;
    }

    public Building readBuilding(UUID id) throws NoMatchingIdException{
        Collection<Building> buildings = readAllBuildings();
        for(Building item : buildings){
            if (item.getId().toString().equalsIgnoreCase(id.toString())){
                return item;
            }
        }
        throw new NoMatchingIdException(id.toString());
    }

    public void updateBuilding(UUID id, Building building) throws NoMatchingIdException {

        Building toDelete = readBuilding(id);
        deleteBuilding(toDelete);
        createBuilding(building);
    }

    public void deleteBuilding(Building building) throws NoMatchingIdException {
        Collection<Building> buildings = readAllBuildings();
        Collection<Building> list = new ArrayList<Building>();
        try{
            Building toDelete = readBuilding(building.getId());
            for (Building item : buildings){
                if(!item.getId().equals(toDelete.getId())){
                    list.add(item);
                }
            }
            mapper.writeValue(jsonFile, list);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
