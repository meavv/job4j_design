package ru.job4j.ood.lsp.car;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.ood.lsp.*;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ParkingTest {

    @Ignore
    @Test
    public void whenAddAuto() {
        Parking parking = new Park();
        Car car = new Auto();
        parking.addCar(car);
        assertTrue(parking.get().contains(car));
    }

    @Ignore
    @Test
    public void whenAddAutoInvalid() {
        Parking parking = new Park();
        Car car = new Auto();
        parking.addCar(car);
        assertFalse(parking.get().contains(car));
    }

    @Ignore
    @Test
    public void whenAddTruck() {
        Parking parking = new Park();
        Car car = new Truck();
        parking.addCar(car);
        assertTrue(parking.get().contains(car));
    }

    @Ignore
    @Test
    public void whenAddCarAndGetFreePlace() {
        Parking parking = new Park();
        Car car = new Auto();
        parking.addCar(car);
        assertEquals(parking.getPlacesPassAuto() - 1, parking.freePlacesPassAuto());
    }

    @Ignore
    @Test
    public void whenAddTruckAndGetFreePlace() {
        Parking parking = new Park();
        Car car = new Truck();
        parking.addCar(car);
        assertEquals(parking.getPlacesTrack() - 1, parking.freePlacesTrack());
    }

    @Ignore
    @Test
    public void whenDelAuto() {
        Parking parking = new Park();
        Car car = new Auto();
        parking.addCar(car);
        parking.delCar(car);
        assertFalse(parking.get().contains(car));
    }

    @Ignore
    @Test (expected = NullPointerException.class)
    public void whenDelAutoException() {
        Parking parking = new Park();
        Car car = new Auto();
        parking.delCar(car);
        assertTrue(parking.get().contains(car));
    }

}