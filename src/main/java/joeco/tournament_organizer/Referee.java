package joeco.tournament_organizer;

import static joeco.utils.SharedVariables.gListOfMatches;
import joeco.tournament_configurations.TournamentBuilder;
import joeco.tournament_configurations.MatchBuildUpdate;
import joeco.tournament_objects.SingleMatch;
import joeco.tournament_objects.SingleTeam;
import joeco.tournament_configurations.TeamsBuilder;
import java.util.ArrayList;
import java.util.Random;

public class Referee {
    private static ArrayList<SingleTeam> randomizedTeamList = new ArrayList<>(); //reviewed&updated5/24
    private static int totalTeams = TournamentBuilder.getNumberOfTeams(); //reviewed&updated5/24

    public static void randomizeTeamsList(ArrayList<SingleTeam> initialTeamList){
        Random randomNumberCreator = new Random();
        ArrayList <Integer> randomNumberList = new ArrayList<>();
        int randomTeamNumber;
        totalTeams = TournamentBuilder.getNumberOfTeams();
        //System.out.println("totalTeams: "+totalTeams);

            for (int i = 0; totalTeams > i; i++) {
                randomTeamNumber = randomNumberCreator.nextInt(totalTeams);

                while (randomNumberList.contains(randomTeamNumber)) { //find a new random team to put into the list
                    randomTeamNumber = randomNumberCreator.nextInt(totalTeams);
                }
                //System.out.println("randomTeamNumber:"+randomTeamNumber);
                randomizedTeamList.add(initialTeamList.get(randomTeamNumber));
                randomNumberList.add(randomTeamNumber);
            }
            randomNumberList.clear();

    }

    public static void createInitialMatches(){

        for(int i = 0; totalTeams > i; i = i + 2){
            gListOfMatches.add(new SingleMatch(randomizedTeamList.get(i), randomizedTeamList.get(i+1)));
        };

        for(int i = 0; gListOfMatches.size() > i; i++){
            gListOfMatches.get(i).setMatchNumber(i+1);
        }

        randomizedTeamList.clear();
    }

    public static void updateMatchWithTeamScores(){
        MatchBuildUpdate.assignWinOrLossToTeams();
    }

    public static ArrayList<SingleTeam> getRandomizedTeamList() {
        return randomizedTeamList;
    }

    public static void clearRandomizedTeams(){
        Referee.randomizedTeamList.clear();
    }

}
