package joeco.user_interaction;

import joeco.tournament_organizer.Referee;

//user this for displaying things to the user
public class UserDisplay {

    public static void displayMatchInformation() { //algorithm to print off team matches. functioning/tested.
        if ((Referee.matchList.size()==1) && (Referee.teamSittingOutCheck==0)){
            System.out.println("__________FINAL Round:__________");
        } else {
            System.out.println("_______________________________________________________________________");
            System.out.println("\n__________Round " + Referee.numberOfRounds + ":__________");
        }

        for (int i = 0; Referee.totalMatches > i; i++) {
            System.out.println("Match " + (i + 1) + ": Team " + Referee.matchList.get(i).getTeamOne().getTeamNumber() + " vs Team "
                    + Referee.matchList.get(i).getTeamTwo().getTeamNumber());
        }

        if(Referee.teamSittingOutCheck==1){
            System.out.println("\n***Team "+Referee.sittingOutTeam.getTeamNumber()+" is sitting out this round***");
        }
        Referee.numberOfRounds++;
    }

    public static void displayTotalMatchInfo() {

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

            if (Referee.teamSittingOutCheck == 1) {
                System.out.println("The team that sat out this round was: Team " + Referee.sittingOutTeam.getTeamNumber() + "\n");
            }
        }
    }

}
