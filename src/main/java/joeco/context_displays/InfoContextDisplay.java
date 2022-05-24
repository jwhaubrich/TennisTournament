package joeco.context_displays;

import joeco.tournament_organizer.Referee;

import static joeco.utils.SharedVariables.gListOfMatches;
import static joeco.utils.SharedVariables.teamSittingOutCheck;

public class InfoContextDisplay {
    private static int numberOfRounds = 1;

    public static void displayPreMatchInformation() { //algorithm to print off team matches. functioning/tested.
        System.out.println("Inside InfoContextDisplay class");
        InfoContextDisplay.normalOrFinalRoundChecker();
        PreMatchContextDisplay.displayTeamVsTeamMatch();
        PreMatchContextDisplay.sittingOutTeamChecker();
        numberOfRounds++;
    }

    public static void normalOrFinalRoundChecker(){
        System.out.println("Inside InfoContextDisplay class");
        if ((gListOfMatches.size()==1) && (teamSittingOutCheck==false)){
            System.out.println("__________FINAL Round:__________");
        } else {
            System.out.println("_______________________________________________________________________");
            System.out.println("\n__________Round " + numberOfRounds + ":__________");
        }
    }

    public static void displayTeamWinnerInformation() {
        PostMatchContextDisplay.displayTeamWinnerInformation();
        PostMatchContextDisplay.sittingOutTeamChecker();
    }

}
