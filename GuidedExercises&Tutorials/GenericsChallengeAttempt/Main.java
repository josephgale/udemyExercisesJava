package com.udemy;
// Create a generic class to implement a league table for a sport.
// The class should allow teams to be added to the list, and store
// a list of teams that belong to the league.
//
// Your class should have a method to print out the teams in order,
// with the team at the top of the league printed first.
//
// Only teams of the same type should be added to any particular
// instance of the league class - the program should fail to compile
// if an attempt is made to add an incompatible team.

public class Main {
    public static void main(String[] args) {

        League<FootballTeam> nfl = new League<>("NFL");
        League<BasketballTeam> nba = new League<>("NBA");

        FootballTeam broncos = new FootballTeam("Denver Broncos");
        FootballTeam cowboys = new FootballTeam("Dallas Cowboys");
        BasketballTeam mavericks = new BasketballTeam("Dallas Mavericks");

        broncos.teamResult(cowboys,14,7);
//        System.out.println(broncos.getRank());
//        System.out.println(cowboys.getRank());

        //nfl.getRankings();
        nfl.addTeam(broncos);
        nfl.addTeam(cowboys);
        nfl.addTeam(new FootballTeam("Jacksonville Jaguars"));
        nfl.getRankings();




    }
}
