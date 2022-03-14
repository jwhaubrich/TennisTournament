/*
Tennis tournament (4 hours) Develop a simple implementation of a tennis tournament that admits
different types of matches (between women, between men and mixed between 2 and 4 participants).
The system should allow referees to create matches and enter scores for each matchup, and allow
fans to view the entered results.  The basic concepts seen will be evaluated, it is not necessary
to build databases or APIS or user interface (data entered by console is allowed).

Work Log:
1. Created classes for storing the individual teams (TeamStoring.java), individual team object (IndividualTeam.java),
an object to store info obtained from user (TournamentConfigs.java)

 */

import java.util.Scanner;
//make it so the team that's sitting out HAS to play the next round
//print to the user which team is sitting out when the matches and rounds are listed so they're not confused
//when entering which teams to enter scores for, implement some kind of error check
//when entering scores for each team, show which teams played in the match

public class TournamentTesting{

    public static void main(String[] args) {
        /*
        int loopCounter = 0;

        if((TournamentConfigs.getNumberOfTeams()%2)==1){
            loopCounter = (TournamentConfigs.getNumberOfTeams()/2) + 1;
        }
        else{
            loopCounter = (TournamentConfigs.getNumberOfTeams()/2)
        }
        System.out.println("loopCounter test "+loopCounter);*/
        //System.out.println("Welcome to the Tennis Tournament Simulator\n");

        //initial tournament setup
        TournamentConfigs.setNumberOfTeams();
        TournamentConfigs.setNumberOfPlayersOnTeam();
        TeamStoring.createTeamList();
        //System.out.println("Manual team initialization or automatic?"); //go with automatic first
        TeamStoring.teamAutoInitialization();
        //System.out.println("Manual match creation or automatic?"); //go with automatic first
        Referee.randomizeTeams();
        Referee.createTeamMatches();



        Referee.displayCurrentMatches();
        Referee.updateMatchesWithWinners();
        Referee.displayTotalMatchInfo();
        Referee.furtherMatchCreation();

        Referee.displayCurrentMatches();
        Referee.updateMatchesWithWinners();
        Referee.displayTotalMatchInfo(); //displays matches & winners of matches with scores
        Referee.furtherMatchCreation(); //creates matches, prints nothing to screen
        Referee.displayCurrentMatches(); //displays th current team match ups
        Referee.updateMatchesWithWinners(); //error could be here
        Referee.displayTotalMatchInfo();
        Referee.furtherMatchCreation(); //creates matches, prints nothing to screen OR HERE
        Referee.displayCurrentMatches();
        Referee.updateMatchesWithWinners();
        Referee.displayTotalMatchInfo();
        //up to here, the user is able to update the scores of the second round of matches.
        //these scores are displayed back to the user
        //find a way to assign the winner
        System.out.println("total loop counter: "+Referee.loopCounter);


    }
}