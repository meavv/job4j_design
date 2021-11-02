package ru.job4j.ood.lsp.car;

import ru.job4j.collection.List;

public interface CarService {

    int freePlacesPassAuto();
    int freePlacesTrack();

    boolean addCar(Car car);
    List<Car> get();
    boolean delCar(Car car);

}
