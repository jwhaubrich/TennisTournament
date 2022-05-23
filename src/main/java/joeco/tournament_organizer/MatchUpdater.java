package joeco.tournament_organizer;

import joeco.tournament_objects.SingleMatch;

import java.util.Scanner;

import static joeco.tournament_organizer.Referee.*;

public class MatchUpdater {
    public static int matchToUpdate;
    public static int scoreTeam1;
    public static int scoreTeam2;

    public static void assignScoresToTeams(){
        System.out.println("inside MatchFunctionality class");
        //how can I make it so the user is only able to select the number of matches that are available?
        Scanner input = new Scanner(System.in);
        int updateCounter = 0;

        System.out.println("\nYou will now assign scores to each team, depending on each match.");

        while(updateCounter < Referee.totalMatches) {
            System.out.println("\nType out the match number for which teams to update: ");
            matchToUpdate = Integer.parseInt(input.nextLine()) - 1;//indexed on 0
            //matchToUpdate = matchToUpdate - 1; replaced this with above statement

            if (0 <= matchToUpdate && matchToUpdate < Referee.totalMatches) {
                System.out.println("What is the score for Team " + matchList.get(matchToUpdate).getTeamOne().getTeamNumber() + "?: ");
                scoreTeam1 = Integer.parseInt((input.nextLine()));
                System.out.println("What is the score for Team " + matchList.get(matchToUpdate).getTeamTwo().getTeamNumber() + "?: ");
                scoreTeam2 = Integer.parseInt((input.nextLine()));
                System.out.println("Setting scores for teams...");

                MatchUpdater.updateTeamScoresInMatch();
                MatchUpdater.updateWinningTeamListWithTeamInfo();

                updateCounter++;
            }
        }
        Referee.loopCounter++;
    }

    public static void updateTeamScoresInMatch(){
        matchList.get(matchToUpdate).getTeamOne().setFinalScore(scoreTeam1);
        matchList.get(matchToUpdate).getTeamOne().setFinalScore(scoreTeam2);
    }

    public static void updateWinningTeamListWithTeamInfo(){
        if(scoreTeam1 > scoreTeam2){
            matchList.get(matchToUpdate).setWinningTeam(matchList.get(matchToUpdate).getTeamOne().getTeamNumber());
            matchList.get(matchToUpdate).setWinningScore(scoreTeam1);
            Referee.winningTeams.add(matchList.get(matchToUpdate).getTeamOne());
        }

        if(scoreTeam2 > scoreTeam1){
            matchList.get(matchToUpdate).setWinningTeam(matchList.get(matchToUpdate).getTeamTwo().getTeamNumber());
            matchList.get(matchToUpdate).setWinningScore(scoreTeam2);
            Referee.winningTeams.add(matchList.get(matchToUpdate).getTeamTwo());
        }
    }

    public static void createNextTeamMatches(){
        System.out.println("Inside Referee class");
        matchList.clear();
        Referee.randomTeamList.clear();
        int newTotalTeams = Referee.winningTeams.size();

        if(newTotalTeams!=1){
            Referee.totalMatches = newTotalTeams/2;
        }
        else{
            Referee.totalMatches = 1;
        }

        for(int i = 0; newTotalTeams > i; i++){
            Referee.randomTeamList.add(Referee.winningTeams.get(i));
        }

        if(teamSittingOutCheck==1){
            Referee.randomTeamList.add(sittingOutTeam);
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
}
