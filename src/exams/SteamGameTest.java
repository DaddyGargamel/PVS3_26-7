package exams;

import fileworks.DataImport;
import java.util.ArrayList;
import java.util.List;

public class        SteamGameTest {
    public static void main(String[] args) {

        DataImport di = new DataImport("data/steam_games.txt");

        ArrayList<Game> games = new ArrayList<>();
        ArrayList<Game> freeGames = new ArrayList<>();
        ArrayList<Game> paidGames = new ArrayList<>();

        int reviews = 0;
        double avgReviewPerGame;
        String line;
        String[] tokeny;

        Game mostExpansive = new Game(null, 0.0, 0, null);


        while (di.hasNext()) {
            line = di.readLine();
            tokeny = line.split("\t");

            if (tokeny.length == 3) {

                Game game = new Game(tokeny[0], Double.parseDouble(tokeny[1]), Integer.parseInt(tokeny[2]));
                games.add(game);

                if (Double.parseDouble(tokeny[1]) == 0.0) {

                    freeGames.add(game);
                }

                else {

                    paidGames.add(game);
                }

                if (game.price > mostExpansive.price) {

                    mostExpansive = game;
                }


            } else { 

                Game game = new Game(tokeny[0], Double.parseDouble(tokeny[1]), Integer.parseInt(tokeny[2]), tokeny[3]);
                games.add(game);

                if (Double.parseDouble(tokeny[1]) == 0.0) {
                    freeGames.add(game);
                } else {
                    paidGames.add(game);
                }
                if (game.price > mostExpansive.price) {
                    mostExpansive = game;
                }
            }
        }


        
        System.out.println("Number of games: " + games.size());
        System.out.println("Number of free games: " + freeGames.size());
        System.out.println("Number of paid games: " + paidGames.size());
        System.out.println("The most expensive game: " + mostExpansive);

        di.finishImport();
    }
}


class Game {
    String name;
    double price;
    int reviews;
    String description;

    public Game(String name, double price, int reviews, String description) {
        this.name = name;
        this.price = price;
        this.reviews = reviews;
        this.description = description;
    }
    public Game(String name, double price, int reviews) {
        this.name = name;
        this.price = price;
        this.reviews = reviews;

        if (price == 0.0) {
            description = "Not released yet";
        } else {
            description = "N/A";
        }
    }

    @Override
    public String toString() {
        return "Game{" +
                "name: '" + name + '\'' +
                ", price: " + price +
                ", reviewsCount: " + reviews +
                ", description: '" + description + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getReviews() {
        return reviews;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setReviewsCount(int reviews) {
        this.reviews = reviews;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}