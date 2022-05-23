package joeco.context_displays;

import joeco.tournament_organizer.Referee;

public class PostMatchContextDisplay {

    public static void displayTeamWinnerInformation() {
        System.out.println("Inside PostMatchContextDisplay class");
        System.out.println("\n***Match Information with Team Winners***");

        if ((Referee.matchList.size() == 1) && Referee.teamSittingOutCheck == 0) {
            System.out.println("TEAM " + Referee.matchList.get(0).getWinningTeam() + " is the WINNER of the Tennis Tournament!");
            return;
        } else {
            for (int i = 0; Referee.totalMatches > i; i++) {
                System.out.println("Match " + Referee.matchList.get(i).getMatchNumber() + ": Team "
                        + Referee.matchList.get(i).getTeamOne().getTeamNumber() + " vs Team " + Referee.matchList.get(i).getTeamTwo().getTeamNumber() +
                        ".\n\t Winner is Team " + Referee.matchList.get(i).getWinningTeam() + ", with a score of: " + Referee.matchList.get(i).getWinningScore() + "\n");
            }
        }
    }

    public static void sittingOutTeamChecker(){
        if (Referee.teamSittingOutCheck == 1) {
            System.out.println("The team that sat out this round was: Team " + Referee.sittingOutTeam.getTeamNumber() + "\n");
        }
    }
}
