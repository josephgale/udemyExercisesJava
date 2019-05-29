package com.udemy;

import java.util.HashMap;
import java.util.Map;

public class Location {
    /*
        >>Why are these final?
        Each of the location objects that will be created need
        to have a location variable and description variable
        which need to be consistent throughout the game and not
        changed. Do not confuse "final" with "static". Final is
        for the variable, and you can have multiple instantiations,
        each with different variable values, but those values just
        don't change once they are initialized for that object.
     */
    private final int locationID;
    private final String description;


    //Each location instantiation will have a hashmap of exits
   private final Map<String, Integer> exits;

   //constructor

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<>();
        //adding escape for each Location object:
        this.exits.put("Q",0);
    }

    //add exit
    public void addExit(String direction, int location){
        exits.put(direction,location);
    }

    //getters:
    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        //normally we'd return exits, but we send a copy
        //so the original exits map won't get modified.
        return new HashMap<String, Integer>(exits);
    }
}
