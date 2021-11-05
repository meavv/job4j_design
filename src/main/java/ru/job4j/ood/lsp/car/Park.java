package ru.job4j.ood.lsp.car;

import ru.job4j.collection.List;

import java.util.ArrayList;

public class Park implements Parking {

    private ArrayList<Car> cars;

    @Override
    public int getPlacesPassAuto() {
        return 0;
    }

    @Override
    public int getPlacesTrack() {
        return 0;
    }

    @Override
    public int freePlacesPassAuto() {
        return 0;
    }

    @Override
    public int freePlacesTrack() {
        return 0;
    }

    @Override
    public boolean addCar(Car car) {
        return false;
    }

    @Override
    public ArrayList<Car> get() {
        return cars;
    }

    @Override
    public boolean delCar(Car car) {
        return false;
    }
}
