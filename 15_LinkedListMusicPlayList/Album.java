import java.util.ArrayList;

public class Album {
    private String name;
    private ArrayList<Song> songs;

    public Album(String name) {
        this.name = name;
        songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongList(){
        return songs;
    }

    public void addSong(String name, int duration){
        songs.add(new Song(name,duration));
    }

    public void showSongs(){
        for(int i=0;i<songs.size();i++){
            System.out.println(songs.get(i).getName() + " | " + songs.get(i).getDuration());
        }
    }
}

