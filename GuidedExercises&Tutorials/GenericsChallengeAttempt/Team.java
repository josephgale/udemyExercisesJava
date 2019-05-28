
public abstract class Team<L extends League<Team>>{
    public String name;
    public int won;
    public int lost;
    public int rank;

    public Team(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void teamResult(Team team, int teamScore, int opponentScore){
        if(teamScore>opponentScore){
            won++;
        }
        if(teamScore<opponentScore){
            lost++;
        }
        //if we do team.teamResult(null,opponentScore,teamScore), we will raise an exception; therefore we must
        //  use the if statement below
        if(team!=null){
            team.teamResult(null, opponentScore, teamScore);
        }

    }

    public int getWon() {
        return won;
    }

    public int getLost() {
        return lost;
    }

    public int getRank() {
        rank = 2*won - lost;
        return rank;
    }
}


