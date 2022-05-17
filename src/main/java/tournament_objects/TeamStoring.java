package tournament_objects;

import tournament_configurations.TournamentConfigs;

import java.util.ArrayList;

public class TeamStoring {
    public static ArrayList<IndividualTeam> teamList = new ArrayList<>();

    public static void createTeamList(){
        int numberOfTeams = TournamentConfigs.getNumberOfTeams(); //actual code for user interaction

        //int numberOfTeams = 10; //code for testing the input of the number of teams

        for(int i = 1; numberOfTeams >= i; i++){ //puts the teams into the teamlist in order
            teamList.add(new IndividualTeam(i));
        }
    }

    public static void teamAutoInitialization(){
        //need to figure out how to set a random number of males/females
        //currently it's just setting the number of individuals for each individual team object

        int totalTeams = teamList.size();
        int numberOfTeamPlayers = TournamentConfigs.getTotalPlayersOnTeam(); //actual code in the finished program
        //int numberOfTeamPlayers = 4; //code for testing

        for(int i = 0; totalTeams > i; i++){
            teamList.get(i).setNumberOfIndividuals(numberOfTeamPlayers); //list of teams in order
        }
    }
}
