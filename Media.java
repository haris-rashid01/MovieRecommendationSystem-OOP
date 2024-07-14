package com.example.oopproject;
abstract class Media extends MovieDatabase{
    private String movietitle;
    private String genre;
    private int releasedate;

    public Media(String movietitle, String genre) {
        this.movietitle = movietitle;
        this.genre = genre;
    }

    public int getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(int releasedate) {
        this.releasedate = releasedate;
    }

    public String getMovietitle() {
        return movietitle;
    }

    public void setMovietitle(String movietitle) {
        this.movietitle = movietitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public abstract void play();
}

