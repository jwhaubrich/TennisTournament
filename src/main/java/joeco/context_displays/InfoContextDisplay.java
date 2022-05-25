package joeco.context_displays;

import joeco.tournament_configurations.MatchBuildUpdate;
import joeco.tournament_organizer.Referee;

import static joeco.tournament_configurations.MatchBuildUpdate.gMatchCountDown;
import static joeco.utils.SharedVariables.teamSittingOutCheck;

public class InfoContextDisplay {
    private static int numberOfRound = 1;

    public static void displayPreMatchInformation() { //algorithm to print off team matches. functioning/tested.
        InfoContextDisplay.normalOrFinalRoundChecker();
        PreMatchContextDisplay.displayTeamVsTeamMatch();
        PreMatchContextDisplay.sittingOutTeamChecker(); //put this into the above function to run
        numberOfRound++;
    }

    public static void normalOrFinalRoundChecker(){
        System.out.println("InfoContextD - gMatchCountDown variable:"+gMatchCountDown);
        if (((gMatchCountDown == 0)||(gMatchCountDown==1)) && (teamSittingOutCheck==false)){
            System.out.println("__________FINAL Round:__________");
        } else {
            System.out.println("_______________________________________________________________________");
            System.out.println("\n__________Round " + numberOfRound + ":__________");
        }
    }

    public static void displayTeamWinnerInformation() {
        PostMatchContextDisplay.displayTeamWinnerInformation();
        PostMatchContextDisplay.sittingOutTeamChecker();
    }

}
