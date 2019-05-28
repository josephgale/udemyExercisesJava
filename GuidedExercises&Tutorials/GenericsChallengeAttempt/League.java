

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class League<T extends Team> implements Comparable<League<T>> {
    public String name;
    List<T> teams;

    public League(String name) {
        this.name = name;
        teams = new ArrayList<>();
    }

    public void addTeam(T team) {
        teams.add(team);
        System.out.println(team.getName() + " added to " + this.name);
    }

    public void showTeams() {
        for (T team : teams) {
            System.out.println(team.getName());
        }
    }

    public void gameResult(T team1, int score1, T team2, int score2) {
        if (score1 > score2) {
            team1.won++;
            team2.lost++;
            System.out.println(team1.getName() + " won! ");
        }
        if (score1 < score2) {
            team2.won++;
            team1.lost++;
            System.out.println(team2.getName() + " won! ");
        }
        if (score1 == score2) {
            System.out.println("Invalid entry. Try again.");
        }
    }

    @Override
    public int compareTo(League<T> team) {
        return 0;
    }

    public void getRankings() {
        LinkedList<T> rankingList = new LinkedList<>();
        System.out.println("Team Rankings: ");
        boolean quit = false;

        while(!quit){
            for (int i = 0; i < teams.size()-1; i++) {
                if(teams.get(i).getRank()<teams.get(i+1).getRank()){
                    teams.set(i,teams.get(i+1));
                } else {
                    quit = true;
                }
            }
        }

        for(T team : teams){
            System.out.println(team.getName());
        }

    }
}






