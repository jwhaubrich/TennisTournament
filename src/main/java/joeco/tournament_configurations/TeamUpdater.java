package joeco.tournament_configurations;

public class TeamUpdater {
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
}
