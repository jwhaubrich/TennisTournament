package joeco.context_displays;

import java.util.ArrayList;

import static joeco.tournament_organizer.Referee.matchesLeftToUpdate;
import static joeco.utils.SharedVariables.gListOfMatches;

public class MatchDisplay {

    private MatchDisplay() {
    }

    public static void displayMatchesWhenUpdating(int currentMatchSize, ArrayList<Integer> matchNumberList){
        System.out.println("\n*****Entering Scores Information*****");
        System.out.println("You've updated the following matches: ");
        for (int i = 0; currentMatchSize > i; i++) {
            System.out.println("Match " + gListOfMatches.get(matchNumberList.get(i)).getMatchNumber() + ": Team "
                    + gListOfMatches.get(matchNumberList.get(i)).getTeamOne().getTeamNumber() + " vs Team "
                    + gListOfMatches.get(matchNumberList.get(i)).getTeamTwo().getTeamNumber());
        }
    }

    public static void continueUpdatingMatches(int matchToUpdate){
        int matchToRemove = matchToUpdate+1;

        for(int i = 0; matchesLeftToUpdate.size()>i; i++){
            if(matchesLeftToUpdate.get(i).getMatchNumber() == matchToRemove){
                matchesLeftToUpdate.remove(i);
            }
        }
        MatchDisplay.printMatchesLeftToUpdate();
    }

    public static void printMatchesLeftToUpdate(){
        System.out.println("\nPlease continue updating the team scores for the following matches:");

        for (int i = 0; matchesLeftToUpdate.size() > i; i++) {
            System.out.println("Match " + matchesLeftToUpdate.get(i).getMatchNumber() + ": Team "
                    + matchesLeftToUpdate.get(i).getTeamOne().getTeamNumber() + " vs Team " + matchesLeftToUpdate.get(i).getTeamTwo().getTeamNumber());
        }

        if(matchesLeftToUpdate.isEmpty()){
            System.out.println("No pending matches left to update!");
        }
    }

}
