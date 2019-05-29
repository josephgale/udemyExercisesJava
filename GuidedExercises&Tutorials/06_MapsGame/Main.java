package com.udemy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    //the locations HashMap has an integer key and Location object for value
    //the location object in turn has more information.
    private static Map<Integer,Location> locations =
            new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0,"You are sitting in front of a computer doing Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        //add exits based on the map Tim provided:
        //each statment adds an exit to the exits array for Location object
        //locations.get(1):
        //Reminder: locations.get(i) returns the value,not the key
        locations.get(1).addExit("W",2);
        locations.get(1).addExit("E",3);
        locations.get(1).addExit("N",5);
        locations.get(1).addExit("S",4);
        //commenting out these q options and just adding a default in Location to save on code
        //locations.get(1).addExit("Q",0);

        locations.get(2).addExit("N",5);
        //locations.get(2).addExit("Q",0);

        locations.get(3).addExit("W",1);
        //locations.get(3).addExit("Q",0);

        locations.get(4).addExit("N",1);
        locations.get(4).addExit("W",2);
        //locations.get(4).addExit("Q",0);

        locations.get(5).addExit("S",1);
        locations.get(5).addExit("W",2);
        //locations.get(5).addExit("Q",0);


        //input a number, print description from map
        //loc will be populated with corresponding integers to "N","S","E","W", and "Q"
        int loc = 1;
        while(true){
            //get print out of first location when loop starts
            System.out.println(locations.get(loc).getDescription());
            if(loc==0){
                break;
            }

            //create a HashMap of exits from current location
            Map<String,Integer> exits = locations.get(loc).getExits();

            //print out "exits" of location.
            //REMEMBER: must use HashMap.keySet() when iterating through HashMap
            System.out.print("Available exits are ");
            for(String exit : exits.keySet()){
                //REMEMBER: printing exit will print Key, which is a direction
                System.out.print(exit + ", ");
            }
            System.out.println();

            //set up character:
            String direction = scanner.nextLine().toUpperCase();
            //validate direction entered:
            if(exits.containsKey(direction)){
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }

//            loc = scanner.nextInt();
//            if(!locations.containsKey(loc)){
//                System.out.println("You cannot go in that direction");
//            }
        }


    }
}
