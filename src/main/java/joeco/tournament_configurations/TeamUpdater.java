package joeco.tournament_configurations;

import joeco.tournament_organizer.Referee;

import static joeco.tournament_organizer.Referee.getRandomizedTeamList;
import static joeco.utils.SharedVariables.sittingOutTeam;
import static joeco.utils.SharedVariables.teamSittingOutCheck;

public class TeamUpdater {

    public static int newTotalTeams;

    public static void addInfoToTeams(){
        int numberOfTeamPlayers = TeamBuilder.getTotalPlayersOnTeam();
        int teamNumber = 1;

        for(int i = 0; TeamBuilder.getNumberOfTeams() > i; i++){
            TeamBuilder.getTeamList().get(i).setNumberOfIndividuals(numberOfTeamPlayers);
            TeamBuilder.getTeamList().get(i).setTeamNumber(teamNumber);
            teamNumber++;
        }
    }

    public static void clearTeamData(){
        TeamBuilder.clearTeamList();
        TeamBuilder.resetTeamInfo();
    }

    public static void createNewWinningTeamsRandList(){
        newTotalTeams = MatchUpdater.gListWinningTeams.size();

        for(int i = 0; newTotalTeams > i; i++){
            Referee.getRandomizedTeamList().add(MatchUpdater.gListWinningTeams.get(i));
        }
    }

    public static void addSittingOutTeamToRandList(){
        if(teamSittingOutCheck){
            Referee.getRandomizedTeamList().add(sittingOutTeam);
            teamSittingOutCheck = false;
        }
    }

    public static void assignSittingOutTeam(){
        if((getRandomizedTeamList().size()%2)==1){
            sittingOutTeam = getRandomizedTeamList().get((getRandomizedTeamList().size()-1));
            getRandomizedTeamList().remove((getRandomizedTeamList().size()-1));
            newTotalTeams = newTotalTeams - 1;
            teamSittingOutCheck = true;
        }
    }

    public static int getNewTotalTeams() {
        return newTotalTeams;
    }

    public static void updateTeamsForNextRound(){
        TeamUpdater.createNewWinningTeamsRandList();
        TeamUpdater.addSittingOutTeamToRandList();
        TeamUpdater.assignSittingOutTeam();
    }

}
