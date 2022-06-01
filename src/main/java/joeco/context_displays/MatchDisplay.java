package joeco.context_displays;

import java.util.ArrayList;

import static joeco.utils.SharedVariables.gListOfMatches;

public class MatchDisplay {

    public static void displayMatchesWhenUpdating(int currentMatchSize, ArrayList<Integer> matchNumberList){
        //need to ensure that the match that the user entered is the one that is displayed back
        //to them when they set the score
        System.out.println("\nYou've updated the following matches: ");
        for (int i = 0; currentMatchSize > i; i++) {
            System.out.println("Match " + gListOfMatches.get(matchNumberList.get(i)).getMatchNumber() + ": Team "
                    + gListOfMatches.get(matchNumberList.get(i)).getTeamOne().getTeamNumber() + " vs Team "
                    + gListOfMatches.get(matchNumberList.get(i)).getTeamTwo().getTeamNumber());
        }
    }
}
