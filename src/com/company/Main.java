package com.company;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Modify the playlist challenge so that the Album class uses an inner class.
        // Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
        // The inner SongList class will use an ArrayList and will provide a method to add a song.
        // It will also provide findSong() methods which will be used by the containing Album class
        // to add songs to the playlist.
        // Neither the Song class or the Main class should be changed.


        Song kaleo1 = new Song("Break my baby", 5.22);
        Song kaleo2 = new Song("Save yourself", 3.25);
        Song theScore1 = new Song("Fire", 4.01);
        Song theScore2 = new Song("Champion", 4.55);

        Album kaleo = new Album("KALEO", new LinkedList<Song>());
        kaleo.addSongToAlbum(kaleo1);
        kaleo.addSongToAlbum(kaleo2);
//    System.out.println(kaleo.getListOfSongs().toString());
//    System.out.println("\n" + kaleo.toString() + "\n");

        Album theScore = new Album("The Score", new LinkedList<Song>());
        theScore.addSongToAlbum(theScore1);
        theScore.addSongToAlbum(theScore2);
//    System.out.println(theScore.getListOfSongs().toString());

        Playlist playlist = new Playlist(new LinkedList<>() );
        addToPlaylist(kaleo, playlist.getPlaylist());
        addToPlaylist(theScore, playlist.getPlaylist());

        playASong(playlist.getPlaylist());




    }

    private static void addToPlaylist (Album albumToAdd, LinkedList<Song> playlist) {
        int positionOfLastSong;

        try {
            positionOfLastSong = playlist.indexOf(playlist.getLast());
        }
        catch (NoSuchElementException e) {
//            System.out.println("FYI: Adding first song to the playlist");
            positionOfLastSong = 0;
        }

        for (int i = 0; i < albumToAdd.getListOfSongs().size(); i++) {
            playlist.add(positionOfLastSong , albumToAdd.getListOfSongs().get(i) );
//            System.out.println("FYI: Added song " + albumToAdd.getListOfSongs().get(i).getTitle() + " to playlist");
        }
    }

    private static void printMenu () {
        System.out.println("      Menu: \n" +
                "0. Print Menu\n" +
                "1. Previous song  <<\n" +
                "2. Repeat current song\n" +
                "3. Next song  >>\n" +
                "4. Quit\n" +
                "5. List the songs in the playlist\n" +
                "6. Remove current song from the playlist");
    }

    private static void playASong (LinkedList playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;

        ListIterator<Song> listIterator = playlist.listIterator();

        if (playlist.isEmpty()) {
            System.out.println("There are no songs in the playlist. No song will be played.");
            return;
        }
        else {
            System.out.println("Now playing " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int menuSelection = 0;
            try {
                menuSelection = scanner.nextInt();
                scanner.nextLine();
            }
            catch (Exception e) {
                System.out.println("cannot handle that input. Try a different one. Menu displayed");
                printMenu();
            }

            switch (menuSelection) {
                case 0:
                    printMenu();
                    break;

                case 4:
                    quit = true;
                    System.out.println("App will exit");
                    break;

                case 1: // previous <<
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println(">> to " + playlist.get(listIterator.previousIndex()).toString());
                        listIterator.previous();
                    }
                    else {
                        System.out.println("Reached the start of the playlist");
                    }
                    break;

                case 2: // repeat song
                    if (goingForward) {
                        System.out.println("<?> to " + playlist.get(listIterator.previousIndex()).toString());
                    }
                    if (!goingForward) {
                        System.out.println("<?> to " + playlist.get(listIterator.nextIndex()).toString());
                    }
                    break;

                case 3: // next song >>
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println(">> to " + playlist.get(listIterator.nextIndex()).toString());
                        listIterator.next();
                    }
                    else {
                        System.out.println("reached the end of the playlist");
                    }
                    break;

                case 5: // list all songs
                    System.out.println("Printing the playlist");
                    System.out.println(playlist.toString());
                    break;

                case 6: // remove current song
                    if (playlist.size() > 0) {
                        listIterator.remove();
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next());
                    } else if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous());
                    }
                    break;

                default:
                    try {
                    }
                    catch (Exception e) {
                        System.out.println("cannot handle that input. Try a different one. Menu displayed");
                        printMenu();
                    }
            }
        }
    }
}
