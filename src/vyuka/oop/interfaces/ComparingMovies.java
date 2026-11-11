package vyuka.oop.interfaces;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparingMovies {

    static ArrayList<Movies> loadData(String path) {
        ArrayList<Movies> movies = new ArrayList<>();
        DataImport di = new DataImport(path);
        String line;
        String[] tokens;

        while (di.hasNext()) {
            line = di.readLine();
            tokens = line.split(";");

            movies.add(new Movies(
                   tokens[0],
                   tokens[1],
                   Integer.parseInt(tokens[2]),
                   Double.parseDouble(tokens[3])
            ));
        }
        di.finishImport();

        return movies;


    }
    static void printList(ArrayList<Movies> movies) {
        System.out.println("Movies:");
        for (Movies m : movies) {
            System.out.println(m);
        }
        System.out.println();
        System.out.println("------");
        System.out.println();
    }

    static void nejlepeHodnocene(ArrayList<Movies> movies) {
        System.out.println("Movies:");
        for (Movies m : movies) {
            if (m.rating >= 8.5) {
                System.out.println(m);
            }
        }
        System.out.println();
        System.out.println("------");
        System.out.println();
    }

    static void prumerneHodnoceni(ArrayList<Movies> movies) {
        double rating = 0;
        for (Movies m : movies) {
            rating += m.rating;
        }
        double prumer = rating / movies.size();
        System.out.println(prumer);

    }

    static void nejnovejsiFilm(ArrayList<Movies> movies) {
        Movies newest = movies.get(0);
        for (Movies m : movies) {
            if (m.year > newest.year) {
                newest = m;
            }
        }
        System.out.println(newest);
    }

    static void genreScifi(ArrayList<Movies> movies) {
        Movies newest = movies.get(0);
        for (Movies m : movies) {
            if (m.year > newest.year) {
                newest = m;
            }
        }
        System.out.println(newest);
    }

    public static void main(String[] args) {
        ArrayList<Movies> movies = loadData("data/movies.txt");

        Collections.shuffle(movies);
        printList(movies);

        movies.sort(Movies.BY_YEAR);
        printList(movies);

        movies.sort(Movies.BY_YEAR.reversed());
        printList(movies);

        movies.sort(Movies.BY_RATING);
        nejlepeHodnocene(movies);

        prumerneHodnoceni(movies);

        nejnovejsiFilm(movies);

    }
}
class Movies implements Comparable<Movies> {
    String name;
    String genre;
    Integer year;
    Double rating;

    public Movies(String name, String genre, Integer year, Double rating) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public static final Comparator<Movies> BY_YEAR = new Comparator<Movies>() {
        @Override
        public int compare(Movies o1, Movies o2) {
            return Integer.compare(o1.year, o2.year);
        }
    };

    public static final Comparator<Movies> BY_RATING = new Comparator<Movies>() {
        @Override
        public int compare(Movies o1, Movies o2) {
            return Double.compare(o1.rating, o2.rating);
        }
    };

    @Override
    public int compareTo(Movies o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }
}