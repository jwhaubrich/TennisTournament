package joeco.tournament_configurations;

import joeco.tournament_objects.SingleMatch;
import joeco.tournament_objects.SingleTeam;
import joeco.tournament_organizer.Referee;

import java.util.ArrayList;
import java.util.Scanner;

import static joeco.tournament_configurations.TournamentBuilder.gTotalMatches;
import static joeco.tournament_organizer.Referee.*;
import static joeco.utils.SharedVariables.sittingOutTeam;
import static joeco.utils.SharedVariables.teamSittingOutCheck;
import static joeco.utils.SharedVariables.gListOfMatches;

public class MatchBuildUpdate {
    public static ArrayList<SingleTeam> gListWinningTeams = new ArrayList<>();
    public static int matchToUpdate;
    public static int scoreTeam1;
    public static int scoreTeam2;

    public static void assignWinOrLossToTeams(){
        System.out.println("inside MatchFunctionality class");
        //how can I make it so the user is only able to select the number of matches that are available?
        Scanner input = new Scanner(System.in);
        int updateCounter = 0;

        System.out.println("\nYou will now assign scores to each team, depending on each match.");

        while(updateCounter < gTotalMatches) {
            System.out.println("\nType out the match number for which teams to update: ");
            matchToUpdate = Integer.parseInt(input.nextLine()) - 1;//indexed on 0
            //matchToUpdate = matchToUpdate - 1; replaced this with above statement

            if (0 <= matchToUpdate && matchToUpdate < gTotalMatches) {
                System.out.println("What is the score for Team "
                        + gListOfMatches.get(matchToUpdate).getTeamOne().getTeamNumber() + "?: ");
                scoreTeam1 = Integer.parseInt((input.nextLine()));
                System.out.println("What is the score for Team "
                        +gListOfMatches.get(matchToUpdate).getTeamTwo().getTeamNumber() + "?: ");
                scoreTeam2 = Integer.parseInt((input.nextLine()));
                System.out.println("Setting scores for teams...");

                MatchBuildUpdate.updateTeamScoresInMatch();
                MatchBuildUpdate.updateWinningTeamListWithTeamInfo();

                updateCounter++;
            }
        }
    }

    public static void updateTeamScoresInMatch(){
        gListOfMatches.get(matchToUpdate).getTeamOne().setFinalScore(scoreTeam1);
        gListOfMatches.get(matchToUpdate).getTeamOne().setFinalScore(scoreTeam2);
    }

    public static void updateWinningTeamListWithTeamInfo(){
        if(scoreTeam1 > scoreTeam2){
            gListOfMatches.get(matchToUpdate).setWinningTeam(gListOfMatches.get
                    (matchToUpdate).getTeamOne().getTeamNumber());
            gListOfMatches.get(matchToUpdate).setWinningScore(scoreTeam1);
            MatchBuildUpdate.gListWinningTeams.add(gListOfMatches.get(matchToUpdate).getTeamOne());
        }

        if(scoreTeam2 > scoreTeam1){
            gListOfMatches.get(matchToUpdate).setWinningTeam(gListOfMatches.get
                    (matchToUpdate).getTeamTwo().getTeamNumber());
            gListOfMatches.get(matchToUpdate).setWinningScore(scoreTeam2);
            MatchBuildUpdate.gListWinningTeams.add(gListOfMatches.get(matchToUpdate).getTeamTwo());
        }
    }

    //must go through and refactor this method
    //after I updated the totalMatches variable that was in Referee and I put it in TournamentBuilder
    //I don't think this method will work anymore
    public static void createNextTeamMatches(){
        System.out.println("Inside Referee class");
        gListOfMatches.clear();
        Referee.getRandomizedTeamList().clear();
        int newTotalTeams = MatchBuildUpdate.gListWinningTeams.size();

        //checks for when there is only one team left in the gListWinningTeams list
        //do I need this? why do I need it?
        if(newTotalTeams!=1){
            gTotalMatches = newTotalTeams/2;
        }
        else{
            gTotalMatches = 1;
        }

        for(int i = 0; newTotalTeams > i; i++){
            Referee.getRandomizedTeamList().add(MatchBuildUpdate.gListWinningTeams.get(i));
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

        for(int i = 0; gTotalMatches  > i; i++){ //algorithm that sets match numbers to each match.
            gListOfMatches.get(i).setMatchNumber(i+1);
        }

        gListWinningTeams.clear(); //clears out everything in the winning teams array to be used with the next winners
    }
}
