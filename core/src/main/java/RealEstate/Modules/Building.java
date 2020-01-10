package RealEstate.Modules;

import java.time.LocalDate;
import java.util.UUID;

public class Building {
    private UUID id;
    private BuildingType buildingType;
    private double usefulFloorSpace;
    private LocalDate yearOfConstruction;
    private String city;
    private double u_Value;
    private double r_Value;
    private double av_Value;
    private boolean lowEGlazingWindows;
    private Orientation orientation;
    private boolean water;
    private boolean gas;
    private boolean electricity;
    private boolean canal;

    public Building(BuildingType buildingType, double usefulFloorSpace, LocalDate yearOfConstruction, String city, double u_Value,
                    double r_Value, double av_Value, boolean lowEGlazingWindows, Orientation orientation, boolean water,
                    boolean gas, boolean electricity, boolean canal) {
        this();
        this.buildingType = buildingType;
        this.usefulFloorSpace = usefulFloorSpace;
        this.yearOfConstruction = yearOfConstruction;
        this.city = city;
        this.u_Value = u_Value;
        this.r_Value = r_Value;
        this.av_Value = av_Value;
        this.lowEGlazingWindows = lowEGlazingWindows;
        this.orientation = orientation;
        this.water = water;
        this.gas = gas;
        this.electricity = electricity;
        this.canal = canal;
    }

    public Building() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public double getUsefulFloorSpace() {
        return usefulFloorSpace;
    }

    public void setUsefulFloorSpace(double usefulFloorSpace) {
        this.usefulFloorSpace = usefulFloorSpace;
    }

    public LocalDate getYearOfConstruction() {
        return yearOfConstruction;
    }

    public void setYearOfConstruction(LocalDate yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getU_Value() {
        return u_Value;
    }

    public void setU_Value(double u_Value) {
        this.u_Value = u_Value;
    }

    public double getR_Value() {
        return r_Value;
    }

    public void setR_Value(double r_Value) {
        this.r_Value = r_Value;
    }

    public double getAV_Value() {
        return av_Value;
    }

    public void setAV_Value(double AV_Value) {
        this.av_Value = AV_Value;
    }

    public boolean isLowEGlazingWindows() {
        return lowEGlazingWindows;
    }

    public void setLowEGlazingWindows(boolean lowEGlazingWindows) {
        this.lowEGlazingWindows = lowEGlazingWindows;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isGas() {
        return gas;
    }

    public void setGas(boolean gas) {
        this.gas = gas;
    }

    public boolean isElectricity() {
        return electricity;
    }

    public void setElectricity(boolean electricity) {
        this.electricity = electricity;
    }

    public boolean isCanal() {
        return canal;
    }

    public void setCanal(boolean canal) {
        this.canal = canal;
    }
}
