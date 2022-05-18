package joeco.tournament_organizer;

import joeco.tournament_configurations.TournamentBuilder;
import joeco.tournament_objects.SingleMatch;
import joeco.tournament_objects.SingleTeam;
import joeco.tournament_objects.TeamsBuilder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Referee {
    public static ArrayList<SingleTeam> randomTeamList = new ArrayList<>();
    public static ArrayList<SingleMatch> matchList = new ArrayList<>();
    public static ArrayList<SingleTeam> winningTeams = new ArrayList<>();
    public static SingleTeam sittingOutTeam;
    public static int teamSittingOutCheck = 0;
    public static int numberOfRounds = 1;
    public static int totalTeams = TournamentBuilder.getNumberOfTeams();
    public static int totalMatches = totalTeams/2;
    public static int loopCounter;


    public static void randomizeTeamsList(){ //function checked and verified 5/18
        Random randomNumberCreator = new Random();
        ArrayList <Integer> randomNumberList = new ArrayList<>();
        int randomTeamNumber;

        for(int i = 0; totalTeams > i; i++) {
            randomTeamNumber = randomNumberCreator.nextInt(totalTeams);

            while (randomNumberList.contains(randomTeamNumber)) { //find a new random team to put into the list
                randomTeamNumber = randomNumberCreator.nextInt(totalTeams);
            }
            randomTeamList.add(TeamsBuilder.teamList.get(randomTeamNumber));
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
    }

    public static void furtherMatchCreation(){
        matchList.clear();
        randomTeamList.clear();
        int newTotalTeams = winningTeams.size();

        if(newTotalTeams!=1){
            totalMatches = newTotalTeams/2;
        }
        else{
            totalMatches = 1;
        }

        for(int i = 0; newTotalTeams > i; i++){
            randomTeamList.add(winningTeams.get(i));
        }

        if(teamSittingOutCheck==1){
            randomTeamList.add(sittingOutTeam);
            teamSittingOutCheck = 0;
        }

        if((randomTeamList.size()%2)==1){
            sittingOutTeam = randomTeamList.get((randomTeamList.size()-1));
            randomTeamList.remove((randomTeamList.size()-1));
            newTotalTeams = newTotalTeams - 1;
            teamSittingOutCheck = 1;
        }

        for(int i = 0; newTotalTeams  > i; i = i + 2){ //algorithm to create the matches(team vs team). functioning/tested.
            matchList.add(new SingleMatch(randomTeamList.get(i), randomTeamList.get(i+1)));
        }

        for(int i = 0; totalMatches  > i; i++){ //algorithm that sets match numbers to each match.
            matchList.get(i).setMatchNumber(i+1);
        }

        winningTeams.clear(); //clears out everything in the winning teams array to be used with the next winners
    }


    public static void updateMatchesWithWinners(){
        //how can I make it so the user is only able to select the number of matches that are available?
        Scanner input = new Scanner(System.in);
        int matchToUpdate = 0;
        int scoreTeam1 = 0;
        int scoreTeam2 = 0;
        int updateCounter = 0;

        System.out.println("\nYou're about to assign scores for each team, depending on each match.");

        while(updateCounter < totalMatches) {
            System.out.println("\nType out the match number for which teams to update: ");
            matchToUpdate = Integer.parseInt(input.nextLine());
            matchToUpdate = matchToUpdate - 1; //indexed on 0

            if (0 <= matchToUpdate && matchToUpdate < totalMatches) {
                //which team won?
                //display the team match up before they enter in the details of who won
                //how can I set who wins the match?
                System.out.println("What is the score for Team " + matchList.get(matchToUpdate).getTeamOne().getTeamNumber() + "?: ");
                scoreTeam1 = Integer.parseInt((input.nextLine()));
                System.out.println("What is the score for Team " + matchList.get(matchToUpdate).getTeamTwo().getTeamNumber() + "?: ");
                scoreTeam2 = Integer.parseInt((input.nextLine()));
                System.out.println("Setting scores for teams...");
                matchList.get(matchToUpdate).getTeamOne().setFinalScore(scoreTeam1);
                matchList.get(matchToUpdate).getTeamOne().setFinalScore(scoreTeam2);

                if(scoreTeam1 > scoreTeam2){
                    matchList.get(matchToUpdate).setWinningTeam(matchList.get(matchToUpdate).getTeamOne().getTeamNumber());
                    matchList.get(matchToUpdate).setWinningScore(scoreTeam1);
                    winningTeams.add(matchList.get(matchToUpdate).getTeamOne());
                }

                if(scoreTeam2 > scoreTeam1){
                    matchList.get(matchToUpdate).setWinningTeam(matchList.get(matchToUpdate).getTeamTwo().getTeamNumber());
                    matchList.get(matchToUpdate).setWinningScore(scoreTeam2);
                    winningTeams.add(matchList.get(matchToUpdate).getTeamTwo());
                }
                updateCounter++;
            }
        }
        loopCounter++;
    }


}
