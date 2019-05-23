import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {
    private String name;
    private ArrayList<Album> albums;
    private LinkedList<Song> playlist;


    public Playlist(String name) {
        this.name = name;
        playlist = new LinkedList<>();
        albums = new ArrayList<>();

    }

    public void addAlbum(Album name) {
        albums.add(name);
    }

    public void addSong(String album, String song) {
        boolean foundAlbum = false;
        boolean foundSong = false;
        for (int i = 0; i < albums.size(); i++) {
            if (albums.get(i).getName().equals(album)) {
                foundAlbum = true;
                for (int s = 0; s < albums.get(i).getSongList().size(); s++) {
                    if (albums.get(i).getSongList().get(s).getName().equals(song)) {
                        foundSong = true;
                        playlist.add(albums.get(i).getSongList().get(s));
                    }
                }
            }
        }
        if (!foundAlbum) {
            System.out.println("No such album exists");
        }
        if (foundAlbum && !foundSong) {
            System.out.println("No such song exists");
        }
    }

    public void removeSong(String name) {
        for(int i=0;i<playlist.size();i++){

        }
    }

    private void showMenu() {
        System.out.println("Press 0 to quit \nPress 1 to skip forward\nPress 2 to play previous song\n" +
                "Press 3 to repeat song\nPress 4 to see playlist\nPress 5 to see menu\nPress 6 to remove " +
                "current song");
    }

    public void run() {
        boolean quit = false;
        boolean movingForward = true;
        ListIterator<Song> playListIterator = playlist.listIterator();
        while (!quit) {
            System.out.println("Press 5 to see menu");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    //quit
                    quit = true;
                    break;
                case 1:
                    //skip ahead
                    if (!movingForward) {
                        if (playListIterator.hasNext()) {
                            playListIterator.next();
                            movingForward = true;
                        } else {
                            System.out.println("You are at the end of the playlist");
                        }
                    }
                    if (playListIterator.hasNext()) {
                        System.out.println("Playing " + playListIterator.next().getName());
                    } else {
                        System.out.println("You are at the end of the playlist");
                    }
                    break;

                case 2:
                    //skip back one
                    if (movingForward) {
                        if (playListIterator.hasPrevious()) {
                            playListIterator.previous();
                            movingForward = false;
                        }
                    }
                    if (playListIterator.hasPrevious()) {
                        System.out.println("Playing " + playListIterator.previous().getName());
                    }else{
                        System.out.println("You are at the beginning of the playlist");
                    }
                    break;

                case 3:
                    //repeat
                    if(movingForward){
                        System.out.println("Repeating " + playListIterator.previous().getName());
                        movingForward = false;
                    } else {
                        System.out.println("Repeating " + playListIterator.next().getName());
                        movingForward = true;
                    }
                    break;

                case 4:
                    //see playlist
                    System.out.println("====== Playlist =======");
                    for(int i=0;i<playlist.size();i++){

                        System.out.println("Song: " + playlist.get(i).getName());
                        if(playlist.get(i).getDuration()%60<10){
                            System.out.println("Time: " + playlist.get(i).getDuration()/60 + ":0" +
                                    playlist.get(i).getDuration()%60);
                        } else {
                            System.out.println("Time: " + playlist.get(i).getDuration()/60 + ":" +
                                    playlist.get(i).getDuration()%60);
                        }

                    }
                    System.out.println("========================");
                    break;
                case 5:
                    //see menu
                    showMenu();
                    break;
                case 6:
                    //remove song
                    if(movingForward){
                        System.out.println(playListIterator.previous().getName() + " has been removed");
                        playListIterator.remove();
                    } else {
                        System.out.println(playListIterator.next().getName() + " has been removed");
                        playListIterator.remove();
                    }

            }
        }
    }
}
