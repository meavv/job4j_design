package ru.job4j.ood.lsp.car;

import java.util.ArrayList;

public interface Parking {


    int getPlacesPassAuto();
    int getPlacesTrack();
    int freePlacesPassAuto();
    int freePlacesTrack();

    boolean addCar(Car car);
    Car[] get();
    int size();

}