package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    private CityList mockCityList() {
        CityList list = new CityList();
        list.add(mockCity());
        return list;
    }

    @Test
    void testAdd() {
        CityList list = mockCityList();
        assertEquals(1, list.countCities());

        City regina = new City("Regina", "Saskatchewan");
        list.add(regina);

        assertEquals(2, list.countCities());
        assertTrue(list.hasCity(regina));
    }

    @Test
    void testAddExceptionOnDuplicate() {
        CityList list = mockCityList();
        City dup = new City("Edmonton", "Alberta");
        assertThrows(IllegalArgumentException.class, () -> list.add(dup));
    }

    @Test
    void testHasCity() {
        CityList list = mockCityList();
        assertTrue(list.hasCity(new City("Edmonton", "Alberta")));
        assertFalse(list.hasCity(new City("Calgary", "Alberta")));
    }

    @Test
    void testDelete() {
        CityList list = mockCityList();
        City regina = new City("Regina", "Saskatchewan");
        list.add(regina);

        list.delete(regina);
        assertEquals(1, list.countCities());
        assertFalse(list.hasCity(regina));
    }

    @Test
    void testDeleteExceptionWhenMissing() {
        CityList list = mockCityList();
        City calgary = new City("Calgary", "Alberta");
        assertThrows(IllegalArgumentException.class, () -> list.delete(calgary));
    }

    @Test
    void testGetCitiesSortedByName() {
        CityList list = new CityList();
        City calgary = new City("Calgary", "Alberta");
        City banff   = new City("Banff", "Alberta");
        City edmonton= new City("Edmonton", "Alberta");

        list.add(calgary);
        list.add(banff);
        list.add(edmonton);

        assertEquals("Banff",    list.getCities().get(0).getCityName());
        assertEquals("Calgary",  list.getCities().get(1).getCityName());
        assertEquals("Edmonton", list.getCities().get(2).getCityName());
    }

    @Test
    void testCountCities() {
        CityList list = mockCityList();
        assertEquals(1, list.countCities());
        list.add(new City("Calgary", "Alberta"));
        assertEquals(2, list.countCities());
    }
}

