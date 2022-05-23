package joeco.context_displays;

import joeco.tournament_organizer.Referee;

public class InfoContextDisplay {

    public static void displayPreMatchInformation() { //algorithm to print off team matches. functioning/tested.
        System.out.println("Inside InfoContextDisplay class");
        InfoContextDisplay.normalOrFinalRoundChecker();
        PreMatchContextDisplay.displayTeamVsTeamMatch();
        PreMatchContextDisplay.sittingOutTeamChecker();
        Referee.numberOfRounds++;
    }

    public static void normalOrFinalRoundChecker(){
        System.out.println("Inside InfoContextDisplay class");
        if ((Referee.matchList.size()==1) && (Referee.teamSittingOutCheck==0)){
            System.out.println("__________FINAL Round:__________");
        } else {
            System.out.println("_______________________________________________________________________");
            System.out.println("\n__________Round " + Referee.numberOfRounds + ":__________");
        }
    }

    public static void displayTeamWinnerInformation() {
        PostMatchContextDisplay.displayTeamWinnerInformation();
        PostMatchContextDisplay.sittingOutTeamChecker();
    }

}
