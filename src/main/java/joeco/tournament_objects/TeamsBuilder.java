package joeco.tournament_objects;

import joeco.tournament_configurations.TournamentBuilder;

import java.util.ArrayList;

public class TeamsBuilder {
    
    public static ArrayList<SingleTeam> teamList = new ArrayList<>();
    private static int totalNumberOfTeams = TournamentBuilder.getNumberOfTeams();
    
    public static void createInitialTeamList(){
        for(int i = 1; totalNumberOfTeams >= i; i++){
            teamList.add(new SingleTeam(i));
        }
    }

    public static void initializationOfSingleTeams(){
        int numberOfTeamPlayers = TournamentBuilder.getTotalPlayersOnTeam();
        int teamNumber = 1;

        for(int i = 0; totalNumberOfTeams > i; i++){
            teamList.get(i).setNumberOfIndividuals(numberOfTeamPlayers);
            teamList.get(i).setTeamNumber(teamNumber);
            teamNumber++;
        }
    }
}
