import java.util.ArrayList;

//class will be used by the Referee object to create matches between teams
public class MatchStoring {

    static ArrayList<Match> matchArrayList = new ArrayList<>();
    static int totalMatches;

    //just receives the total number of teams to get total matches, totalmatches is used in createMatches
    public static void totalMatches(int totalTeams){
        totalMatches = totalTeams/2;
    }

    //receives random number from referee to create team match ups
    //random number will be between 0 and total number of teams - 0, because indexes on 0
    public static void createMatches(int randomTeam1, int randomTeam2){
        int counter = 0;

        while(totalMatches > counter){
            matchArrayList.add(new Match(TeamsCreation.teamsList.get(randomTeam1), TeamsCreation.teamsList.get(randomTeam2), counter));
            counter++;
        }

    }

}
