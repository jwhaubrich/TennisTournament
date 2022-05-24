package joeco.tournament_configurations;

import joeco.tournament_configurations.TournamentBuilder;
import joeco.tournament_objects.SingleTeam;

import java.util.ArrayList;

public class TeamsBuilder {

    private static ArrayList<SingleTeam> teamList = new ArrayList<>();
    
    public static void createInitialTeamList(){
        for(int i = 1; TournamentBuilder.getNumberOfTeams() >= i; i++){
            teamList.add(new SingleTeam(i));
        }
    }

    public static void addInfoToTeams(){
        int numberOfTeamPlayers = TournamentBuilder.getTotalPlayersOnTeam();
        int teamNumber = 1;

        for(int i = 0; TournamentBuilder.getNumberOfTeams() > i; i++){
            teamList.get(i).setNumberOfIndividuals(numberOfTeamPlayers);
            teamList.get(i).setTeamNumber(teamNumber);
            teamNumber++;
        }
    }

    public static ArrayList<SingleTeam> getTeamList() {
        return teamList;
    }

    public static void clearTeamList() {
        TeamsBuilder.teamList.clear();
    }
}
