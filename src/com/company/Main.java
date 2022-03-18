package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("fixed.txt"));
            String line;
            ArrayList<City> cities = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                if (line.contains("NA")) continue;
                String[] oneLine = line.split(",");
                for (int i = 0; i < oneLine.length; i++) {
                    oneLine[i] = oneLine[i].replaceAll("\"", "");
                }
                double population = Double.parseDouble(oneLine[10]);
                cities.add(new City(oneLine[1], oneLine[5], oneLine[9], (int) population));
            }
            System.out.println(cities.stream().filter(city -> city.getCountry().equals("Czechia")).collect(Collectors.toList()).size());
            System.out.println(cities.stream().filter(city -> city.getCapital().equals("primary")).filter(city -> city.getCountry().equals(("Australia"))).map(city -> city.getCity()).collect(Collectors.toList()));
            System.out.println(cities.stream().filter(city -> city.getCity().equals(city.getCountry())).map(city -> city.getCity() + " (" + (Math.round((double) city.getPopulation() / 1000) * 1000)  + ")").collect(Collectors.toList()));
            var heh = cities.stream().filter(city -> city.getCountry().equals("United States")).sorted((o1, o2) -> o2.getPopulation() - o1.getPopulation()).limit(7).collect(Collectors.toList());
            int newYork = heh.get(0).getPopulation();
            System.out.println(heh.stream().skip(1).map(city -> city.getCity() + " " + (double) Math.round(((double) city.getPopulation() /  newYork) * 10000) / 100 + "%").collect(Collectors.toList()));
            /*
            for (int i = 1; i < heh.size(); i++) {
                System.out.println(heh.get(i).getCity() + " " + (float) ((double) heh.get(i).getPopulation() /  heh.get(0).getPopulation()) * 100 + "%");
            }
             */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
