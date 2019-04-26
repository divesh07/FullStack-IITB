package Examples;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RateMovies {
    // iterate the queue, and update the rating for the correct movie, for all movies you have ratings for.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Movie movie1 = new Movie("Dangal");
        Movie movie2 = new Movie("Gangs of Wasseypur");
        Movie movie3 = new Movie("Tubelight");
        Movie movie4 = new Movie("Padvamat");

        Queue<Movie> movieQueue = new LinkedList<Movie>();
        movieQueue.add(movie1);
        movieQueue.add(movie2);
        movieQueue.add(movie3);
        movieQueue.add(movie4);

        // Here are the movies and their ratings in the correct order, e.g. Gangs of Wasseypur has a rating 5 and so on.
        int[] movieRatings = { 5, 3, 4, 1 };
        String[] movieTitles = { "Gangs of Wasseypur", "Padvamat", "Dangal", "Tubelight" };
        Queue<Movie> tmp = new LinkedList<Movie>();
        for (int i = 0; i < 4; i++) {
            int rating = movieRatings[i];
            String title = movieTitles[i];

            // Iterate over Queue to find the movie with the correct title
            // and update its Rating
            // Write logic here
            movieQueue.stream().forEach(x -> {
                if (x.getTitle().equalsIgnoreCase(title)){
                    x.setRating(rating);
                }
            });
        }
    }
}

class Movie {
    public String title;
    public int rating;

    public Movie(String title) {
        this.title = title;
        this.rating = 0;
    }

    public String getTitle() {
        return this.title;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        System.out.println("Giving " + rating + " star(s) to the movie " + this.title);
        this.rating = rating;
    }
}