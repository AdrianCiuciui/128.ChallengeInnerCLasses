package com.company;

public class Song {

    private String Title;
    private double Duration;

    public Song(String title, double duration) {
        Title = title;
        Duration = duration;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public double getDuration() {
        return Duration;
    }

    public void setDuration(double duration) {
        Duration = duration;
    }

    @Override
    public String toString() {
        return "\nSong {" +
                "Title='" + Title + '\'' +
                ", Duration=" + Duration +
                "} ";
    }
}
