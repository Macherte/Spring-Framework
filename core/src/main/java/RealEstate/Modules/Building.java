package RealEstate.Modules;

import java.time.LocalDate;

public class Building {
    private BuildingType buildingType;
    private double usefulFloorSpace;
    private LocalDate yearOfConstruction;
    private String city;
    private double U_Value;
    private double R_Value;
    private double AV_Value;
    private boolean lowEGlazingWindows;
    private Orientation orientation;
    private boolean water;
    private boolean gas;
    private boolean electricity;
    private boolean canal;

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
        return U_Value;
    }

    public void setU_Value(double u_Value) {
        U_Value = u_Value;
    }

    public double getR_Value() {
        return R_Value;
    }

    public void setR_Value(double r_Value) {
        R_Value = r_Value;
    }

    public double getAV_Value() {
        return AV_Value;
    }

    public void setAV_Value(double AV_Value) {
        this.AV_Value = AV_Value;
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
