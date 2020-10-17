package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private SongList songs;

    public Album(String name, LinkedList<Song> listOfSongs) {
        this.name = name;
        this.songs = new SongList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Song> getListOfSongs() {
        return songs.printSongsFromAlbum();
    }

    public boolean addSongToAlbum (Song songToBeAdded) {
        return this.songs.add(new Song(songToBeAdded.getTitle(), songToBeAdded.getDuration()));
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", listOfSongs=" + songs.printSongsFromAlbum() +
                '}';
    }

        private class SongList {
            private LinkedList <Song> songs;

            public SongList() {
                this.songs = new LinkedList<>();
            }

            public boolean add (Song song) {
                if (songs.contains(song)) {
                    return false;
                }
                this.songs.add(song);
                return true;
            }

            private Song findSong (String title) {
                for (Song checkedSong: this.songs) {
                    if (checkedSong.getTitle().equals(title)) {
                        return checkedSong;
                    }
                }
                return null;
            }

            public Song findSong (int trackNumber) {
                int index = trackNumber -1;
                if ((index > 0) && (index < songs.size())) {
                    return songs.get(index);
                }
                return null;
            }

            public LinkedList <Song> printSongsFromAlbum () {
                return this.songs;
            }
        }




}
