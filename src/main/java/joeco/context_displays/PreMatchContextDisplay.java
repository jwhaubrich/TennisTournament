package joeco.context_displays;

import joeco.tournament_organizer.Referee;

public class PreMatchContextDisplay {
    public static void displayTeamVsTeamMatch(){
        for (int i = 0; Referee.totalMatches > i; i++) {
            System.out.println("Match " + (i + 1) + ": Team " + Referee.matchList.get(i).getTeamOne().getTeamNumber() + " vs Team "
                    + Referee.matchList.get(i).getTeamTwo().getTeamNumber());
        }
    }

    public static void sittingOutTeamChecker(){
        if(Referee.teamSittingOutCheck==1){
            System.out.println("\n***Team "+Referee.sittingOutTeam.getTeamNumber()+" is sitting out this round***");
        }
    }

}
