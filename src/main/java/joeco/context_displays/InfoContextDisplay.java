package joeco.context_displays;

import static joeco.tournamentsimulation_run.TournamentInitializer.gMatchCountDown;
import static joeco.utils.SharedVariables.teamSittingOutCheck;

public class InfoContextDisplay {
    private static int numberOfRound = 1;

    public static void displayPreMatchInformation() {
        InfoContextDisplay.normalOrFinalRoundChecker();
        PreMatchContextDisplay.displayTeamVsTeamMatch();
        PreMatchContextDisplay.sittingOutTeamChecker();
        numberOfRound++;
    }

    public static void normalOrFinalRoundChecker(){
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

    public static void resetNumberOfRound(){
        numberOfRound = 1;
    }

}
