package com.example.oopproject;

import java.util.ArrayList;

public class MovieDatabase {
    public static ArrayList<Movie> AllMovies(){
        ArrayList<Movie> All = new ArrayList<>();

        All.add(new Movie("Red" , "Horror" , 168));
        All.add(new Movie("Guns Akimbo" , "Action" , 170));
        All.add(new Movie("San andreas" , "Action , Adventure" , 194));
        All.add(new Movie("Rampage" , "Action" , 161));
        All.add(new Movie("Harry potter Sorcur Stone" , "Adventure" , 121));
        All.add(new Movie("Harry potter The Goblet of Fire" , "Adventure" , 152));
        All.add(new Movie("Harry potter Prisoner of Azkaban" , "Adventure" , 135));
        All.add(new Movie("Harry potter and The DEATHLY HALLOWS( Part-1 )" , "Adventure" , 181));
        All.add(new Movie("Harry potter and The DEATHLY HALLOWS( Part-2 )" , "Adventure" , 111));
        All.add(new Movie("Harry potter Prisoner of Azkaban" , "Adventure" , 121));
        All.add(new Movie("Harry potter Prisoner of Azkaban" , "Adventure" , 121));
        All.add(new Movie("Guardian of Galaxy" , "Action , Adventure" , 166));
        All.add(new Movie("The Dark Knight", "Action", 152));
        All.add(new Movie("Back to the Future", "Comedy", 141));
        All.add(new Movie("Twilight Saga" , "Romantic" , 127));
        All.add(new Movie("Avengers 2010" , "Action" , 163));
        All.add(new Movie("Cobra Kai" , "Dramatic , Adventure , Action" , 211));
        All.add(new Movie("City of God", "Action , Crime", 148));
        All.add(new Movie("Iron Man 2012" , "Action" , 154));
        All.add(new Movie("Toy Story" , "Adventure" , 165));
        All.add(new Movie("It" , "Horror" , 176));
        All.add(new Movie("Rush Hour 3" , "Comedy" , 176));
        All.add(new Movie("The Incredible Hulk" , "Action" , 199));
        All.add(new Movie("Captain America" , "Action" , 112));
        All.add(new Movie("Captain America Winter Soldier" , "Action" , 169));
        All.add(new Movie("Fast And Furious 2023" , "Action" , 231));
        All.add(new Movie("Boss Baby" , "Animation , Family , Dramatic" , 133));
        All.add(new Movie("Cars" , "Animation , Family , Dramatic" , 139));
        All.add(new Movie("Home Alone" , "Adventure" , 198));
        All.add(new Movie("The Matrix", "Drama", 129));

        return All;
    }
}
