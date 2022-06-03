package joeco.tournament_organizer;

import static joeco.utils.SharedVariables.gListOfMatches;

import joeco.tournament_configurations.TeamBuilder;
import joeco.tournament_configurations.MatchUpdater;
import joeco.tournament_objects.SingleMatch;
import joeco.tournament_objects.SingleTeam;

import java.util.ArrayList;
import java.util.Random;

public class Referee {
    private static ArrayList<SingleTeam> randomizedTeamList = new ArrayList<>();
    private static int totalTeams = TeamBuilder.getNumberOfTeams();
    public static ArrayList<SingleMatch> matchesLeftToUpdate;

    private Referee() {
    }

    public static void randomizeTeamsList(ArrayList<SingleTeam> initialTeamList){
        Random randomNumberCreator = new Random();
        ArrayList <Integer> randomNumberList = new ArrayList<>();
        int randomTeamNumber;
        totalTeams = TeamBuilder.getNumberOfTeams();

            for (int i = 0; totalTeams > i; i++) {
                randomTeamNumber = randomNumberCreator.nextInt(totalTeams);

                while (randomNumberList.contains(randomTeamNumber)) {
                    randomTeamNumber = randomNumberCreator.nextInt(totalTeams);
                }
                randomizedTeamList.add(initialTeamList.get(randomTeamNumber));
                randomNumberList.add(randomTeamNumber);
            }
            randomNumberList.clear();

    }

    public static void createInitialMatches(){

        for(int i = 0; totalTeams > i; i = i + 2){
            gListOfMatches.add(new SingleMatch(randomizedTeamList.get(i), randomizedTeamList.get(i+1)));
            matchesLeftToUpdate = new ArrayList<>(gListOfMatches);
        }

        for(int i = 0; gListOfMatches.size() > i; i++){
            gListOfMatches.get(i).setMatchNumber(i+1);
        }

        randomizedTeamList.clear();
    }

    public static void updateMatchWithTeamScores(){
        MatchUpdater.assignWinOrLossToTeams();
    }

    public static ArrayList<SingleTeam> getRandomizedTeamList() {
        return randomizedTeamList;
    }

    public static void clearRandomizedTeams(){
        Referee.randomizedTeamList.clear();
    }

}
