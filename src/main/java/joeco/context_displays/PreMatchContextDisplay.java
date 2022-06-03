package joeco.context_displays;

import static joeco.tournament_exe.TournamentInitializer.gMatchCountDown;
import static joeco.tournament_exe.TournamentInitializer.gMatchesPlayed;
import static joeco.utils.SharedVariables.sittingOutTeam;
import static joeco.utils.SharedVariables.teamSittingOutCheck;
import static joeco.utils.SharedVariables.gListOfMatches;

public class PreMatchContextDisplay {
    private PreMatchContextDisplay() {
    }

    public static void displayTeamVsTeamMatch(){
        if(gMatchCountDown!=0) {
            for (int i = 0; gMatchCountDown > i; i++) {
                System.out.println("Match " + (i + 1) + ": Team " + gListOfMatches.get(i).getTeamOne().getTeamNumber() + " vs Team "
                        + gListOfMatches.get(i).getTeamTwo().getTeamNumber());
                gMatchesPlayed++;
            }
        }
        else{
                System.out.println("Match " + (1) + ": Team " + gListOfMatches.get(0).getTeamOne().getTeamNumber() + " vs Team "
                        + gListOfMatches.get(0).getTeamTwo().getTeamNumber());
            gMatchesPlayed++;
            }
        }


    public static void sittingOutTeamChecker(){
        if(teamSittingOutCheck){
            System.out.println("\n***Team "+sittingOutTeam.getTeamNumber()+" is sitting out this round***");
        }
    }

}
