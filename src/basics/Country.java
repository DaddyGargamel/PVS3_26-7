package basics;

import fileworks.DataImport;



public class Country {
    String name, continent;
    long population;
    double avgAge;
    public Country(String name, String continent, long population, Double avgAge) {
        this.name =  name;
        this.continent = continent;
        this.population = population;
        this.avgAge = avgAge;
    }

    public static void main(String[] args) {
        String path = "data/countries.txt";
        DataImport di = new DataImport(path);

        //...

        Country czechia = new Country("Czech Republic",
                "Europe",
                10_800_000,
                85.0);
        System.out.println(czechia);

        // Vypsat všechny řádky jako instance objekty (třídy Country)
        // 1. přešíst soubor
        // 1.1 přečíst řádek
        // 1.2 do souboru output vypsat pouze
        // 2. Do konzole vypsat:
        // země s nejvetším avgAge
        // země s nejmenší populací

        //parsing
        String line = di.readLine();
        String []tokens = line.split(";");
        String name = tokens[0];
        String continent = tokens[1];
        long population = Long.parseLong(tokens[2]);
        double avgAge = Double.parseDouble(tokens[3]);

        // vytvoření objektu
        Country oneCountry = new Country(
                name,
                continent,
                population,
                avgAge
        );
        double highestAvgAge = 0;
        long minPopulation = 0;
        System.out.println();
        di.finishImport();
        public String toString() {

        }


    }
}
