package test;

import fileworks.DataExport;
import fileworks.DataImport;

import java.util.ArrayList;

public class test1 {
    String name;
    Integer year;
    String genre;
    Double rating;

    public test1(String name, Integer year, String genre, Double rating) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "test1{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public Double getRating() {
        return rating;
    }

    public static void main(String[] args) {
        DataImport di = new DataImport("data/movieList.txt");
        DataExport de = new DataExport("data/horrors.txt");
        Integer countNewMovies = 0;
        test1 bestRating = new test1("TBD", 0, "TBD", Double.MIN_VALUE);
        ArrayList<test1> horrorMovies = new ArrayList<>();
                while (di.hasNext()) {
                    String line = di.readLine();
                    String[] tokens = line.split(";");

                    test1 movies = new test1(tokens[0], Integer.parseInt(tokens[1]), tokens[2], Double.parseDouble(tokens[3]));

                    String name = tokens[0];
                    Integer year = Integer.parseInt(tokens[1]);
                    String genre = tokens[2];
                    Double rating = Double.parseDouble(tokens[3]);

                    if (rating > bestRating.getRating()) {
                        bestRating.name = name;
                        bestRating.year = year;
                        bestRating.genre = genre;
                        bestRating.rating = rating;
                    }




                    if (year > 2000) {
                        countNewMovies++;
                    }

                    if (tokens[2].equals("Horror")) {
                        de.writeLine(movies.toString());
                    }




                }
                System.out.println("Počet filmů po roce 2000: " + countNewMovies);
                System.out.println(bestRating);

                de.writeLine(String.valueOf(horrorMovies));
                de.finishExport();
                di.finishImport();
    }
}
