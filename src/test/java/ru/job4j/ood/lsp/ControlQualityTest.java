package ru.job4j.ood.lsp;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ControlQualityTest {

    List<Store> storeList = new ArrayList<>();

    @Before
    public void before() {
        storeList.add(new Warehouse());
        storeList.add(new Trash());
        storeList.add(new Shop());
    }

    @Test
    public void whenWarehouse() {
        Store store = new Warehouse();
        ControlQuality controlQuality = new ControlQuality(storeList);
        Food meat = new Meat("Мясо", LocalDate.of(2025, 11, 30),
                LocalDate.of(2021, 10, 30), 100, 0);
        assertEquals(store, controlQuality.control(meat));
    }

    @Test
    public void whenTrash() {
        Store store = new Trash();
        ControlQuality controlQuality = new ControlQuality(storeList);
        Food meat = new Meat("Мясо", LocalDate.of(2021, 11, 6),
                LocalDate.of(2021, 11, 5), 100, 0);
        assertEquals(store, controlQuality.control(meat));
    }

    @Test
    public void whenShop() {
        Store store = new Shop();
        ControlQuality controlQuality = new ControlQuality(storeList);
        Food meat = new Meat("Мясо", LocalDate.of(2021, 11, 15),
                LocalDate.of(2021, 10, 15), 100, 0);
        assertEquals(store, controlQuality.control(meat));
    }

    @Ignore
    @Test
    public void whenSaleShop() {
        ControlQuality controlQuality = new ControlQuality(storeList);
        Food meat = new Meat("Мясо", LocalDate.of(2021, 11, 7),
                LocalDate.of(2021, 11, 5), 100, 0);
        controlQuality.control(meat);
        assertEquals(50, meat.getDiscount(), 0);
    }

}