package com.company;

public class City {
    private String city; //1
    private String country; //4
    private String capital; //8
    private int population; //9

    public City(String city, String country, String capital, int population) {
        this.city = city;
        this.country = country;
        this.capital = capital;
        this.population = population;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }
}
