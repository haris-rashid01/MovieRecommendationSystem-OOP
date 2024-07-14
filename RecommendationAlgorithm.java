package com.example.oopproject;

import java.util.ArrayList;
import java.util.List;

class RecommendationAlgorithm {

    private List<Movie> movies;

    public RecommendationAlgorithm() {
        movies = new ArrayList<>();
    }
    public static ArrayList<Movie> recommendMovies(User user) {
        ArrayList<Movie> recommendedMovies = new ArrayList<>();
        ArrayList<Media> watchedHistory = user.getWatchedHistory();
        System.out.println(user.getUserName() + " Watched History is :");
        System.out.println(watchedHistory);

        recommendedMovies.add(new Movie("Harry Potter", "Adventure", 169));
        recommendedMovies.add(new Movie("City of God", "Action , Crime", 148));
        recommendedMovies.add(new Movie("The Dark Knight", "Action", 152));
        recommendedMovies.add(new Movie("Back to the Future", "Comedy", 141));
        recommendedMovies.add(new Movie("The Shawshank Redemption", "Drama", 141));
        recommendedMovies.add(new Movie("365 Days", "", 129));
        recommendedMovies.add(new Movie("Mr bean", "Comedy", 129));
        recommendedMovies.add(new Movie("Hannibal", "Horror", 138));
        recommendedMovies.add(new Movie("Rambo", "Action", 129));
        recommendedMovies.add(new Movie("Terminator", "Action", 110));

        return recommendedMovies;
    }

    public List<Movie> recommendMovies(List<Movie> userHistory, int numRecommendations) {
        List<Movie> recommendations = new ArrayList<>();
        for (Movie movie : movies) {
            if (!userHistory.contains(movie)) {
                recommendations.add(movie);
            }
            if (recommendations.size() >= numRecommendations) {
                break;
            }
        }
        return recommendations;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}
