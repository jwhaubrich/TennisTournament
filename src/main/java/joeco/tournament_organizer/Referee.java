package joeco.tournament_organizer;

import joeco.tournament_configurations.TournamentBuilder;
import joeco.tournament_configurations.MatchBuildUpdate;
import joeco.tournament_objects.SingleMatch;
import joeco.tournament_objects.SingleTeam;
import joeco.tournament_configurations.TeamsBuilder;

import java.util.ArrayList;
import java.util.Random;

public class Referee {
    public static ArrayList<SingleTeam> randomTeamList = new ArrayList<>();
    public static ArrayList<SingleMatch> matchList = new ArrayList<>();
    public static ArrayList<SingleTeam> winningTeams = new ArrayList<>();
    public static SingleTeam sittingOutTeam;
    public static int teamSittingOutCheck = 0;
    public static int numberOfRounds = 1;
    public static int totalTeams = TournamentBuilder.getNumberOfTeams();
    public static int totalMatches = totalTeams/2;
    public static int globalLoopCounter;


    public static void randomizeTeamsList(){ //function checked and verified 5/18
        Random randomNumberCreator = new Random();
        ArrayList <Integer> randomNumberList = new ArrayList<>();
        int randomTeamNumber;

        for(int i = 0; totalTeams > i; i++) {
            randomTeamNumber = randomNumberCreator.nextInt(totalTeams);

            while (randomNumberList.contains(randomTeamNumber)) { //find a new random team to put into the list
                randomTeamNumber = randomNumberCreator.nextInt(totalTeams);
            }
            randomTeamList.add(TeamsBuilder.getTeamList().get(randomTeamNumber));
            randomNumberList.add(randomTeamNumber);
        }
        randomNumberList.clear();
    }

    public static void createInitialMatches(){ //function checked and verified 5/18

        for(int i = 0; totalTeams > i; i = i + 2){
            matchList.add(new SingleMatch(randomTeamList.get(i), randomTeamList.get(i+1)));
        }

        for(int i = 0; totalMatches > i; i++){
            matchList.get(i).setMatchNumber(i+1);
        }

        //maybe put here to clear out the randomTeamList?
    }

    public static void updateMatchWithTeamScores(){
        MatchBuildUpdate.assignScoresToTeams();
    }

}
