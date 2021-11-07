package ru.job4j.ood.lsp.car;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.ood.lsp.*;
import ru.job4j.serialization.java.A;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void whenAddAuto() {
        Parking parking = new Park(2, 2);
        Car car = new Auto();
        parking.addCar(car);
        assertTrue(parking.addCar(car));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddAutoInvalid() {
        Parking parking = new Park(1, 0);
        Car car = new Auto();
        parking.addCar(car);
        assertFalse(parking.addCar(car));
    }

    @Test
    public void whenAddTruck() {
        Parking parking = new Park(0, 1);
        Car car = new Truck(5);
        assertTrue(parking.addCar(car));
        assertEquals(parking.freePlacesTrack(), 0);
    }

    @Test
    public void whenAddTruckButPlacesTrackTaken() {
        Parking parking = new Park(5, 0);
        Car car = new Truck(5);
        assertTrue(parking.addCar(car));
        assertEquals(parking.freePlacesPassAuto(), 0);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddTruckButPlacesAllTaken() {
        Parking parking = new Park(4, 0);
        Car car = new Truck(5);
        assertTrue(parking.addCar(car));
        assertEquals(parking.freePlacesPassAuto(), 0);
    }

    @Test
    public void whenAddCarAndGetFreePlace() {
        Parking parking = new Park(10, 10);
        Car car = new Auto();
        parking.addCar(car);
        assertEquals(parking.getPlacesPassAuto() - 1, parking.freePlacesPassAuto());
    }

    @Test
    public void whenAddTruckAndGetFreePlace() {
        Parking parking = new Park(10, 10);
        Car car = new Truck(4);
        parking.addCar(car);
        assertEquals(parking.getPlacesTrack() - 1, parking.freePlacesTrack());
    }

    @Test
    public void whenManyTruck() {
        Parking parking = new Park(5, 4);
        Car carTruck = new Truck(4);
        Car car = new Auto();
        parking.addCar(carTruck);
        parking.addCar(carTruck);
        parking.addCar(carTruck);
        parking.addCar(carTruck);
        parking.addCar(carTruck);
        parking.addCar(car);
        assertEquals(parking.freePlacesPassAuto(), 0);
    }

    @Test
    public void whenManyTruck2() {
        Parking parking = new Park(5, 0);
        Car carTruck = new Truck(2);
        Car car = new Auto();
        parking.addCar(carTruck);
        parking.addCar(carTruck);
        parking.addCar(car);
        assertEquals(parking.freePlacesPassAuto(), 0);
    }


}