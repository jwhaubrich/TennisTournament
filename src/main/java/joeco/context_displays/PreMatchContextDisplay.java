package joeco.context_displays;

import static joeco.tournamentsimulation_run.TournamentInitializer.gMatchCountDown;
import static joeco.utils.SharedVariables.sittingOutTeam;
import static joeco.utils.SharedVariables.teamSittingOutCheck;
import static joeco.utils.SharedVariables.gListOfMatches;

public class PreMatchContextDisplay {
    public static void displayTeamVsTeamMatch(){
        System.out.println("PreMatchContext - gMatchCountDown variable:"+gMatchCountDown);
        System.out.println("Check that gListOfMatches is not empty: "+gListOfMatches.size());
        if(gMatchCountDown!=0) {
            for (int i = 0; gMatchCountDown > i; i++) {
                System.out.println("Match " + (i + 1) + ": Team " + gListOfMatches.get(i).getTeamOne().getTeamNumber() + " vs Team "
                        + gListOfMatches.get(i).getTeamTwo().getTeamNumber());
            }
        }
        else{
                System.out.println("Match " + (1) + ": Team " + gListOfMatches.get(0).getTeamOne().getTeamNumber() + " vs Team "
                        + gListOfMatches.get(0).getTeamTwo().getTeamNumber());
            }
        }


    public static void sittingOutTeamChecker(){
        if(teamSittingOutCheck==true){
            System.out.println("\n***Team "+sittingOutTeam.getTeamNumber()+" is sitting out this round***");
        }
    }

}
