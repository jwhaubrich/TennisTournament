package tournament_objects;

import tournament_configurations.TournamentBuilder;

import java.util.ArrayList;

public class TeamsBuilder {
    public static ArrayList<SingleTeam> teamList = new ArrayList<>();

    public static void createTeamList(){
        int numberOfTeams = TournamentBuilder.getNumberOfTeams(); //actual code for user interaction

        //int numberOfTeams = 10; //code for testing the input of the number of teams

        for(int i = 1; numberOfTeams >= i; i++){ //puts the teams into the teamlist in order
            teamList.add(new SingleTeam(i));
        }
    }

    public static void teamAutoInitialization(){
        //need to figure out how to set a random number of males/females
        //currently it's just setting the number of individuals for each individual team object

        int totalTeams = teamList.size();
        int numberOfTeamPlayers = TournamentBuilder.getTotalPlayersOnTeam(); //actual code in the finished program
        //int numberOfTeamPlayers = 4; //code for testing

        for(int i = 0; totalTeams > i; i++){
            teamList.get(i).setNumberOfIndividuals(numberOfTeamPlayers); //list of teams in order
        }
    }
}
