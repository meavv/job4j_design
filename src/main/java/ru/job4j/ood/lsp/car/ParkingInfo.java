package ru.job4j.ood.lsp.car;

public class ParkingInfo {

    private final int freePlaceAuto;
    private final int freePlatTruck;
    private final int placeAuto;
    private final int placeTruck;


    public ParkingInfo(int freePlaceAuto, int freePlatTruck, int placeAuto, int placeTruck) {
        this.freePlaceAuto = freePlaceAuto;
        this.freePlatTruck = freePlatTruck;
        this.placeAuto = placeAuto;
        this.placeTruck = placeTruck;
    }


    public int getFreePlaceAuto() {
        return freePlaceAuto;
    }

    public int getFreePlatTruck() {
        return freePlatTruck;
    }

    public int getPlaceAuto() {
        return placeAuto;
    }

    public int getPlaceTruck() {
        return placeTruck;
    }
}
