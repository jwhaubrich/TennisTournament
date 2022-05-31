package joeco.tournament_configurations;

import joeco.tournament_objects.SingleMatch;
import joeco.tournament_organizer.Referee;

import static joeco.tournament_organizer.Referee.getRandomizedTeamList;
import static joeco.tournament_exe.TournamentInitializer.gMatchCountDown;
import static joeco.utils.SharedVariables.gListOfMatches;

public class MatchBuilder {
    public static void createNextTeamMatch(){
        gListOfMatches.clear();
        Referee.getRandomizedTeamList().clear();
        TeamUpdater.updateTeamsForNextRound();
        MatchBuilder.createNewMatches();
    }

    public static void createNewRandMatches(){
        for(int i = 0; TeamUpdater.getNewTotalTeams()  > i; i = i + 2){
            gListOfMatches.add(new SingleMatch(getRandomizedTeamList().get(i), getRandomizedTeamList().get(i+1)));
        }
    }

    public static void setMatchNumbers(){
        for(int i = 0; gMatchCountDown  > i; i++){
            gListOfMatches.get(i).setMatchNumber(i+1);
        }
    }

    public static void createNewMatches(){
        MatchBuilder.createNewRandMatches();
        MatchBuilder.setMatchNumbers();
        MatchUpdater.gListWinningTeams.clear();
    }

}
