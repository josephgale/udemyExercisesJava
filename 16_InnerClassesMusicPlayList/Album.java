import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private SongList songList;
    //private ArrayList<Song> songs;

    public Album(String name) {
        this.name = name;
        songList = new SongList();

    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongList(){
        return songList.songs;
    }

    public void addSong(String name, int duration){
        songList.songs.add(new Song(name,duration));
    }

    public void showSongs(){
        for(int i=0;i<songList.songs.size();i++){
            System.out.println(songList.songs.get(i).getName() + " | " + songList.songs.get(i).getDuration());
        }
    }

    public class SongList{
        private ArrayList<Song> songs;

        public SongList() {
            songs = new ArrayList<>();
        }

        private ArrayList<Song> getSongs(){
            return songs;
        }

        private void testPrint(){
            System.out.println("this prints something");
        }


    }
}
