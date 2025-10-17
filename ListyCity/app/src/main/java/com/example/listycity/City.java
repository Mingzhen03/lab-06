package com.example.listycity;

import java.util.Objects;

/**
 * Represents a Canadian city with a name and province/territory.
 * <p>
 * Implements {@link Comparable} so lists of cities can be sorted
 * alphabetically by city name.
 */
public class City implements Comparable<City> {
    /** The city name, e.g., "Edmonton". */
    private final String city;

    /** The province/territory name, e.g., "Alberta". */
    private final String province;

    /**
     * Constructs a City.
     * @param city     the city name
     * @param province the province/territory name
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /** @return the city name */
    public String getCityName() { return city; }

    /** @return the province/territory name */
    public String getProvinceName() { return province; }

    /**
     * Sort by city name (lexicographic).
     */
    @Override
    public int compareTo(City o) {
        return this.city.compareTo(o.getCityName());
    }

    /**
     * Two City objects are equal if both name and province match.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof City)) return false;
        City other = (City) obj;
        return Objects.equals(city, other.city)
                && Objects.equals(province, other.province);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
