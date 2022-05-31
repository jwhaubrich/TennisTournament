package joeco.tournament_configurations;

import joeco.tournament_objects.SingleMatch;
import joeco.tournament_organizer.Referee;

import static joeco.tournament_organizer.Referee.getRandomizedTeamList;
import static joeco.tournamentsimulation_run.TournamentInitializer.gMatchCountDown;
import static joeco.utils.SharedVariables.*;
import static joeco.utils.SharedVariables.gListOfMatches;

public class MatchBuilder {
    public static void createNextTeamMatches(){
        //I could see about combining this method with the randomize teams method in Referee.randomizeTeamsList
        gListOfMatches.clear();
        Referee.getRandomizedTeamList().clear();
        int newTotalTeams = MatchUpdater.gListWinningTeams.size();


        for(int i = 0; newTotalTeams > i; i++){
            Referee.getRandomizedTeamList().add(MatchUpdater.gListWinningTeams.get(i));
        }

        if(teamSittingOutCheck==true){
            Referee.getRandomizedTeamList().add(sittingOutTeam);
            teamSittingOutCheck = false;
        }

        if((getRandomizedTeamList().size()%2)==1){
            sittingOutTeam = getRandomizedTeamList().get((getRandomizedTeamList().size()-1));
            getRandomizedTeamList().remove((getRandomizedTeamList().size()-1));
            newTotalTeams = newTotalTeams - 1;
            teamSittingOutCheck = true;
        }

        for(int i = 0; newTotalTeams  > i; i = i + 2){ //algorithm to create the matches(team vs team). functioning/tested.
            gListOfMatches.add(new SingleMatch(getRandomizedTeamList().get(i), getRandomizedTeamList().get(i+1)));
        }

        for(int i = 0; gMatchCountDown  > i; i++){ //algorithm that sets match numbers to each match.
            gListOfMatches.get(i).setMatchNumber(i+1);
        }

        MatchUpdater.gListWinningTeams.clear(); //clears out everything in the winning teams array to be used with the next winners
    }


}
