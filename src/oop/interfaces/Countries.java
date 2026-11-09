package oop.interfaces;

import basics.Country;
import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Comparator;

public class Countries {
    // Aruba;North America;103000;78.4

    String name;
    String continent;
    long population;
    double avgAge;

    public Countries(String name, String continent, long population, double avgAge) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.avgAge = avgAge;
    }

    public static void main(String[] args) {
        DataImport di = new DataImport("data/countries.txt");


        ArrayList<Countries> countries = new ArrayList<>();
        countries.add(country);
        while (di.hasNext()) {
            String line = di.readLine();
            String[] tokens = line.split(";");

            String name = tokens[0];
            String continent = tokens[1];
            long population = Long.parseLong(tokens[2]);
            double avgAge = Double.parseDouble(tokens[3]);


            Countries country = new Countries(
                    name, continent, population, avgAge
            );


        }
        di.finishImport();
    }
    public static final Comparator<Country> BY_NAME = new Comparator<Country> () {

        @Override
        public int compare(Country country1, Country country2) {
            if (country1.name.length() > country2.name.length()) {
                return 1;
            }
            if (country1.name.length() < country2.name.length()) {
                return 1;
            }

            return 0;
        }
    };
}
