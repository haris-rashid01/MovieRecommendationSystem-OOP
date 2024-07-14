package com.example.oopproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;

public class MovieGUI extends Application {

    private ArrayList<Movie> movieDatabase;
    private ArrayList<User> userDatabase;
    private User currentUser;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Movie Recommendation Engine");

        movieDatabase = Movie.AllMovies();
        userDatabase = (ArrayList<User>) FileHandling.loadUserDatabase();

        VBox loginWindow = new VBox(20);
        Group group = new Group();
        loginWindow.setPadding(new Insets(70));
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        TextField usernameField = new TextField();
        Button loginButton = new Button("Login");
        loginButton.setLayoutX(20);
        loginButton.setLayoutY(30);

        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            currentUser = getUser(username);
            if(usernameField==null&&passwordField==null){
                start(primaryStage);
            }
            if (currentUser == null) {
                currentUser = new User(username);
                userDatabase.add(currentUser);
            }
            showMainScene(primaryStage);
        });

        loginWindow.getChildren().addAll(usernameLabel, usernameField,passwordLabel, passwordField, loginButton);
        Scene loginScene = new Scene(loginWindow, 600, 600);

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private void showMainScene(Stage primaryStage) {
        VBox mainWindow = new VBox(40);
        mainWindow.setPadding(new Insets(80));
        Label welcomeLabel = new Label("Welcome, " + currentUser.getUserName() + "!");
        Button searchButton = new Button("Search Movie");
        Button recommendButton = new Button("Recommend Movies");
        Button playButton = new Button("Play Movie");
        Button commentButton = new Button("Add a Comment");
        Button exitButton = new Button("Exit");
        Button backButton = new Button("Back");


        searchButton.setOnAction(event -> showSearchScene(primaryStage));
        playButton.setOnAction(event -> showPlayScene(primaryStage));
        commentButton.setOnAction(event -> showCommentScene(primaryStage));
        backButton.setOnAction(event -> start(primaryStage));
        recommendButton.setOnAction(event -> showRecommendScene(primaryStage));
        exitButton.setOnAction(event -> {
           // FileHandling.saveUserDatabase(userDatabase);
            primaryStage.close();
        });

        mainWindow.getChildren().addAll(welcomeLabel, searchButton, recommendButton, playButton, commentButton, exitButton, backButton);
        Scene mainScene = new Scene(mainWindow, 600, 600);

        primaryStage.setScene(mainScene);
    }
    private void showRecommendScene(Stage primaryStage){
        VBox rWindow = new VBox(20);
        rWindow.setPadding(new Insets(20));
        Label rmovies = new Label("Recommended Movies are: ");
        TextArea result = new TextArea();
        Button backButton = new Button("Back");

        backButton.setOnAction(event -> showMainScene(primaryStage));
        result.setText("Red, Genre: Horror, Duration:168 \nHarry Potter Prisoner of Azkaban Genre: Adventure, Duration: 121\nRush Hour 3 Genre: Comedy, Duration: 176\nFast And Furious 2023,  Genre: Action, Duration: 231\nHome Alone , Genre: Adventure, Duration: 198");
        rWindow.getChildren().addAll(rmovies, result,  backButton);
        Scene rScene = new Scene(rWindow, 500, 300);
        primaryStage.setScene(rScene);

    }
    private void showSearchScene(Stage primaryStage) {
        VBox searchWindow = new VBox(10);
        searchWindow.setPadding(new Insets(10));
        Label titleLabel = new Label("Enter movie title to search:");
        TextField titleField = new TextField();
        Button searchButton = new Button("Search");
        TextArea result = new TextArea();
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showMainScene(primaryStage));

        searchButton.setOnAction(event -> {
            String searchTerm = titleField.getText();
            ArrayList<Movie> searchResults = searchMovies(movieDatabase, searchTerm);
            result.clear();
            if (searchResults.isEmpty()) {
                result.setText("No movies found!");
            } else {
                for (Movie movie : searchResults) {
                    result.appendText("Title: " + movie.getMovietitle() + "\n");
                    result.appendText("Genre: " + movie.getGenre() + "\n");
                    result.appendText("Duration: " + movie.getDuration() + " minutes\n");
                }
            }
        });

        searchWindow.getChildren().addAll(titleLabel, titleField, searchButton, result, backButton);
        Scene searchScene = new Scene(searchWindow, 400, 300);
        primaryStage.setScene(searchScene);
    }

    private void showPlayScene(Stage primaryStage) {
        VBox playWindow= new VBox(10);
        playWindow.setPadding(new Insets(10));
        Label titleLabel = new Label("Enter movie title to play:");
        TextField titleField = new TextField();
        Button playButton = new Button("Play");
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showMainScene(primaryStage));

        playButton.setOnAction(event -> {
            String title = titleField.getText();
            Movie selectedMovie = getMovie(movieDatabase, title);
            if (selectedMovie == null) {
                Label nullMovie = new Label("No Movie Found");
                playWindow.getChildren().add(nullMovie);
            } else {
                Label playingMovie = new Label("Playing Movie: " + title);
                playWindow.getChildren().add(playingMovie);
            }

        });

        playWindow.getChildren().addAll(titleLabel, titleField, playButton, backButton);
        Scene playScene = new Scene(playWindow, 400, 300);

        primaryStage.setScene(playScene);
    }

    private void showCommentScene(Stage primaryStage) {
        VBox commentWindow = new VBox(10);
        commentWindow.setPadding(new Insets(10));
        Label titleLabel = new Label("Enter movie title:");
        TextField titleField = new TextField();
        Label commentLabel = new Label("Enter your comment:");
        TextField commentField = new TextField();
        Button commentButton = new Button("Add Comment");
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showMainScene(primaryStage));

        commentButton.setOnAction(event -> {
            String title = titleField.getText();
            Movie selectedMovie = getMovie(movieDatabase, title);
            if (selectedMovie == null) {
                System.out.println("Movie not found!");
            } else {
                String comment = commentField.getText();
                System.out.println("Comment added successfully!");
            }
        });

        commentWindow.getChildren().addAll(titleLabel, titleField, commentLabel, commentField, commentButton, backButton);
        Scene commentScene = new Scene(commentWindow, 500, 300);

        primaryStage.setScene(commentScene);
    }

    private ArrayList<Movie> searchMovies(ArrayList<Movie> database, String searchTerm) {
        ArrayList<Movie> searchResults = new ArrayList<>();
        for (Movie movie : database) {
            if (movie.getMovietitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResults.add(movie);
            }
        }
        return searchResults;
    }

    private Movie getMovie(ArrayList<Movie> database, String title) {
        for (Movie movie : database) {
            if (movie.getMovietitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }

    private User getUser(String username) {
        for (User user : userDatabase) {
            if (user.getUserName().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }

}
