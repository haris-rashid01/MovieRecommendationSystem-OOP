package com.example.oopproject;
import java.util.*;

import java.util.Scanner;

public class MovieRecommendationEngine {
    User u = new User();
    private static ArrayList<Movie> movieDatabase;
    private static ArrayList<User> userDatabase;
    private static ArrayList<RecommendationAlgorithm> rc = new ArrayList<RecommendationAlgorithm>();

    public static void main(String[] args) {

        FileHandling.saveMovieDatabase(Movie.AllMovies());

        movieDatabase = (ArrayList<Movie>) FileHandling.loadMovieDatabase();
        userDatabase = (ArrayList<User>) FileHandling.loadUserDatabase();

        Scanner sc = new Scanner(System.in);

        User u = new User();
        System.out.print("Enter your name: ");
        String name = sc.nextLine();



        User user = getUser(name);

        while (true) {
            System.out.println("\n\033Options:");
            System.out.println("1. Search for a movie");
            System.out.println("2. Play a movie");
            System.out.println("3. Add a comment about a movie");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter movie title to search: ");
                    String searchTitle = sc.nextLine();
                    boolean found = false;

                    for (Movie movie : movieDatabase) {
                        if (movie.getMovietitle().equalsIgnoreCase(searchTitle)) {
                            ArrayList<Movie> searchResults = searchMovies(movieDatabase, searchTitle);
                            System.out.println("Movie found!");

                            System.out.println("Title: " + movie.getMovietitle());
                            System.out.println("Genre: " + movie.getGenre());
                            System.out.println("Duration: " + movie.getDuration() + " minutes");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Movie not found!");
                    }
                    break;

                case 2:
                    System.out.print("Enter movie title to play: ");
                    String playTitle = sc.nextLine();
                    boolean foundMovie = false;

                    for (Movie movie : movieDatabase) {
                        if (movie.getMovietitle().equalsIgnoreCase(playTitle)) {
                            System.out.println("Playing movie...");
                            movie.play();
                            user.addToWatchedHistory(movie);
                            foundMovie = true;
                            break;
                        }
                    }

                    if (!foundMovie) {
                        System.out.println("Movie not found!!!!!!!!!!!!");
                    }
                    break;

                case 3:
                    System.out.print("Enter movie title to add a comment: ");
                    System.out.println("Enter Falana Dhamkana :) ");
                    String commentTitle = sc.nextLine();
                    boolean foundCommentMovie = false;

                    for (Movie movie : movieDatabase) {
                        if (movie.getMovietitle().equalsIgnoreCase(commentTitle)) {
                            System.out.print("Enter your comment: ");
                            String comment = sc.nextLine();
                            System.out.println("Comment added!");
                            foundCommentMovie = true;
                            User u1 = new User();
                            u1.setComments(comment);
                            userDatabase.add(u1);
                            break;
                        }
                    }

                    if (!foundCommentMovie) {
                        System.out.println("Movie not found!!!!");
                    }
                    break;

                case 4:

                    FileHandling.saveMovieDatabase(movieDatabase);
                    FileHandling.saveUserDatabase(userDatabase);
                       System.out.println("Exiting.....");
                       System.exit(0);
                       break;


                default:
                    System.out.println("Invalid choice!!!!! Try again ");
                    break;
                }
            }
        }

    private static User getUser(String name) {
        for (User user : userDatabase) {
            if (user.getUserName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        User newUser = new User(name);
        userDatabase.add(newUser);
        return newUser;
    }
    public static ArrayList<Movie> searchMovies(ArrayList<Movie> movieDatabase, String searchTerm) {
        ArrayList<Movie> searchResults = new ArrayList<Movie>();
        for (Movie movie : movieDatabase) {
            if (movie.getMovietitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResults.add(movie);
            }
        }
        return searchResults;
    }
}