package com.company;

import java.util.LinkedList;

public class Playlist  {

    LinkedList <Song> playlist;

    public Playlist(LinkedList<Song> playlist) {
        this.playlist = playlist;
    }


    public void addSongToPlaylist (Song songToBeAdded) {
        playlist.add(songToBeAdded);
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlist=" + playlist +
                "}";
    }

    public LinkedList<Song> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(LinkedList<Song> playlist) {
        this.playlist = playlist;
    }
}
