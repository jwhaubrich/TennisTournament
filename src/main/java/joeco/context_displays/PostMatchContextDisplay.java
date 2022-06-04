package joeco.context_displays;

import static joeco.tournament_exe.TournamentInitializer.gMatchCountDown;
import static joeco.utils.SharedVariables.sittingOutTeam;
import static joeco.utils.SharedVariables.teamSittingOutCheck;
import static joeco.utils.SharedVariables.gListOfMatches;

public class PostMatchContextDisplay {

    private PostMatchContextDisplay() {
    }

    public static void displayTeamWinnerInformation() {
        System.out.println("\n\n\n*****Match Information with Team Winners*****");

        if ((gMatchCountDown == 0) && !teamSittingOutCheck) {
            System.out.println("TEAM " + gListOfMatches.get(0).getWinningTeam() + " is the WINNER of the Tennis Tournament!\n\n\n");
        } else {
            for (int i = 0; gListOfMatches.size() > i; i++) {
                System.out.println("Match " + gListOfMatches.get(i).getMatchNumber() + ": Team "
                        + gListOfMatches.get(i).getTeamOne().getTeamNumber() + " vs Team " + gListOfMatches.get(i).getTeamTwo().getTeamNumber() +
                        ".\n\t Winner is Team " + gListOfMatches.get(i).getWinningTeam() + ", with a score of: " + gListOfMatches.get(i).getWinningScore() + "\n");
            }
        }
    }

    public static void sittingOutTeamChecker(){
        if (teamSittingOutCheck) {
            System.out.println("The team that sat out this round was: Team " + sittingOutTeam.getTeamNumber() + "\n");
        }
    }
}
