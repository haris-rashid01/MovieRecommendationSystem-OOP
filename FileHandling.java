package com.example.oopproject;
import java.io.*;
import java.util.*;

class FileHandling implements Serializable{

    private static String MFile = "movie_database.txt";
    private static String UFile = "user_database.txt";

    public static void saveMovieDatabase(ArrayList<Movie> movieDatabase) {

        try (
                PrintWriter writer = new PrintWriter(new FileWriter(MFile , true))) {

                for (Movie movie : movieDatabase) {

                    writer.println(movie.getMovietitle());
                    writer.println(movie.getGenre());
                    writer.println(movie.getDuration());
                }
            //writer.close();

        } catch (IOException e) {
            System.out.println("Failed to save movie database.");
            e.printStackTrace();
        }
    }

    public static List<Movie> loadMovieDatabase() {
        List<Movie> movieDatabase = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(MFile))) {
            while (scanner.hasNextLine()) {
                String title = scanner.nextLine();
                String genre = scanner.nextLine();
                int duration = Integer.parseInt(scanner.nextLine());
                movieDatabase.add(new Movie(title, genre, duration));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Movie database file not found. Creating a new database.");
        }

        return movieDatabase;
    }

    public static void saveUserDatabase(List<User> userDatabase) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(UFile , true))) {
            outputStream.writeObject(userDatabase);
        } catch (IOException e) {
            System.out.println("Failed to save user database.");
            e.printStackTrace();
        }
    }

    public static List<User> loadUserDatabase() {
        List<User> userdatabase = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(UFile))) {
            userdatabase = (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("User database file not found. Creating a new database.");
        }

        return userdatabase;
    }
}
