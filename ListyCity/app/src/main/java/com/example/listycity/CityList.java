package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Keeps track of a list of {@link City} objects.
 */
public class CityList {
    private final List<City> cities = new ArrayList<>();

    /**
     * Adds a city if it does not already exist.
     * @param city candidate city
     * @throws IllegalArgumentException if the city already exists
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already in list");
        }
        cities.add(city);
    }

    /**
     * @param city the city to check
     * @return true if the city exists in the list
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Removes the city if present.
     * @param city the city to remove
     * @throws IllegalArgumentException if the city is not in the list
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found");
        }
        cities.remove(city);
    }

    /**
     * @return how many cities are tracked
     */
    public int countCities() {
        return cities.size();
    }

    /**
     * Returns a fresh, sorted copy of the cities by city name.
     * @return sorted list (do not mutate the returned list)
     */
    public List<City> getCities() {
        List<City> copy = new ArrayList<>(cities);
        Collections.sort(copy); // uses City.compareTo
        return copy;
    }
}

