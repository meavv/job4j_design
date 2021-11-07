package ru.job4j.ood.lsp.car;

import ru.job4j.collection.List;

import java.util.ArrayList;

public class Park implements Parking {

    private final int placeAuto;
    private final int placeTruck;
    private int count = 0;

    private int freePlaceAuto;
    private int freePlatTruck;

    private final Car[] cars;

    public Park(int placeAuto, int placeTruck) {
        this.placeAuto = placeAuto;
        this.placeTruck = placeTruck;
        freePlaceAuto = placeAuto;
        freePlatTruck = placeTruck;
        cars = new Car[placeAuto + placeTruck];
    }

    @Override
    public int getPlacesPassAuto() {
        return placeAuto;
    }

    @Override
    public int getPlacesTrack() {
        return placeTruck;
    }

    @Override
    public int freePlacesPassAuto() {
        return freePlaceAuto;
    }

    @Override
    public int freePlacesTrack() {
        return freePlatTruck;
    }

    @Override
    public boolean addCar(Car car) {
        boolean rsl = false;
        if (car.getSize() == 1) {
            if (freePlaceAuto > 0) {
                cars[count] = car;
                count++;
                freePlaceAuto--;
                rsl = true;
            } else {
                throw new ArrayIndexOutOfBoundsException("На парковке нет места");
            }
        } else {
            if (freePlatTruck > 0) {
                cars[count] = car;
                count = count++;
                freePlatTruck--;
                rsl = true;
            } else if (freePlaceAuto >= car.getSize()) {
                cars[count] = car;
                count = count + car.getSize();
                freePlaceAuto = freePlaceAuto - car.getSize();
                rsl = true;
            } else {
                throw new ArrayIndexOutOfBoundsException("На парковке нет места");
            }
        }
        return rsl;
    }

    @Override
    public Car[] get() {
        return cars;
    }


    @Override
    public int size() {
        return cars.length;
    }


}
