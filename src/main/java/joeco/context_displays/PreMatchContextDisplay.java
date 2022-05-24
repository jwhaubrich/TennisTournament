package joeco.context_displays;

import joeco.tournament_organizer.Referee;

import static joeco.tournament_configurations.TournamentBuilder.gTotalMatches;
import static joeco.utils.SharedVariables.sittingOutTeam;
import static joeco.utils.SharedVariables.teamSittingOutCheck;
import static joeco.utils.SharedVariables.gListOfMatches;

public class PreMatchContextDisplay {
    public static void displayTeamVsTeamMatch(){
        for (int i = 0; gTotalMatches > i; i++) {
            System.out.println("Match " + (i + 1) + ": Team " + gListOfMatches.get(i).getTeamOne().getTeamNumber() + " vs Team "
                    + gListOfMatches.get(i).getTeamTwo().getTeamNumber());
        }
    }

    public static void sittingOutTeamChecker(){
        if(teamSittingOutCheck==true){
            System.out.println("\n***Team "+sittingOutTeam.getTeamNumber()+" is sitting out this round***");
        }
    }

}
