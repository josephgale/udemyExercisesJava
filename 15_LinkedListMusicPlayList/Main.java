public class Main {

    public static void main(String[] args) {
     Album myAlbum = new Album("Beatles");
     myAlbum.addSong("Yellow Submarine",120);
     myAlbum.addSong("Twist and Shout",200);


     Playlist myPlayList = new Playlist("Friday Party");

     myPlayList.addAlbum(myAlbum);
     myPlayList.addSong("Beatles","Yellow Submarine");
     myPlayList.addSong("Beatles","Twist and Shout");
     myPlayList.run();
    }

}

