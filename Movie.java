package com.example.oopproject;
class Movie extends Media {
    private int duration;

    public Movie(String movietitle, String genre, int duration) {
        super(movietitle, genre);
        this.duration = duration;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    @Override
    public void play() {
        System.out.println("Playing movie is: " + getMovietitle());
        System.out.println("Genre: " + getGenre());
        System.out.println("Duration: " + duration + " minutes");
    }

}