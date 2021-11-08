package ru.job4j.ood.lsp.car;

import java.util.Arrays;

public class Park implements Parking {

    private int count = 0;
    private int countForTruck = 0;

    private final int placeAuto;
    private final int placeTruck;
    private int freePlaceAuto;
    private int freePlatTruck;

    private ParkingInfo parkingInfo;

    private final Car[] autos;
    private final Car[] trucks;

    public Park(int placeAuto, int placeTruck) {
        this.placeAuto = placeAuto;
        this.placeTruck = placeAuto;
        freePlaceAuto = placeAuto;
        freePlatTruck = placeTruck;
        autos = new Car[placeAuto];
        trucks = new Car[placeTruck];
    }


    @Override
    public boolean addCar(Car car) {
        boolean rsl = false;
        if (car.getSize() == Auto.SIZE) {
            if (freePlaceAuto > 0) {
                autos[count] = car;
                count++;
                freePlaceAuto--;
                rsl = true;
            }
        } else {
            if (freePlatTruck > 0) {
                trucks[count] = car;
                countForTruck = countForTruck++;
                freePlatTruck--;
                rsl = true;
            } else if (freePlaceAuto >= car.getSize()) {
                autos[count] = car;
                count = count + car.getSize();
                freePlaceAuto = freePlaceAuto - car.getSize();
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public ParkingInfo get() {
        return new ParkingInfo(freePlaceAuto, freePlatTruck, placeAuto, placeTruck);
    }


}
