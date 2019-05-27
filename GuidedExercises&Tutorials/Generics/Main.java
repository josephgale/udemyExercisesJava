import java.util.ArrayList;

//The type parameter forces a consistency between the team and its member variables and methods
//Until we assign values to T, all "T" locations will be instantiating and accepting raw types
//When we have a type parameter, we can now instantiate like this: Team<FootballPlayer> or whatever we want

//By adding "T extends Player", we only allow Player objects
//comparable is a built in interface. 
public class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;
    //create an arraylist to hold members of the team
    //originally it was ArrayList<Player>, but it was changed to <T>
    private ArrayList<T> members = new ArrayList<>();

    //create a constructor
    public Team(String name) {
        this.name = name;
    }

    //create a getter:
    public String getName() {
        return name;
    }

    //create method for adding team member...use Boolean
    //only add an object whose class matches the class of the parameter type
    //associated with Team Class
    public boolean addPlayer(T player){
        //use "contains" which built in method for ArrayLists
        if(members.contains(player)){
            //we can use ((Player) player).getName() because we
            //cast T as Player. Now that T extends player, we go back to T player:
            System.out.println(player.getName() + " has already been added");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " added to " + this.name);
            return true;
        }
    }

    //create method for viewing number of players on team
    public int numPlayers(){
        return members.size();
    }
    //create method for results:
    //by adding Team<T> for opponet, we ensure that only similar types of teams
    //are matched up
    public void matchResult(Team<T> opponent, int ourScore, int theirScore){
       if(ourScore>theirScore){
           won++;
       } else if (ourScore<theirScore){
           lost++;
       } else {
           tied++;
        }
       played++;
       //same method within method to add to score of opponent
       if(opponent!=null){
           //since method is within method, provide way to stop an infinite loop
           opponent.matchResult(null,theirScore,ourScore);
       }
    }
    //create a ranking score, higher the better:
    public int ranking(){
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if(this.ranking() > team.ranking()){
            return -1;
        } else if(this.ranking()<team.ranking()){
            return 1;
        } else {
            return 0;
        }
    }
}
