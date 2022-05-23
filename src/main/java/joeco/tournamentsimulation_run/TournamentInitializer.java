/*
create methods to restart the program and close the program - DONE
do while loop inside of the initializeTennisTournament - DONE
don't have the reinitalizeTournamentCheck equal to anything at the top
working on putting in a do while loop inside of the initializeTennisTournament - from this I began...
going through the methods within the Referee class to see why the program keeps breaking
    I think that the do/while should work but I'm not 100%
    Referee.displayCurrentMatches();
    Referee.updateMatchesWithWinners();
    Referee.displayTotalMatchInfo();
    Referee.furtherMatchCreation();
also creating new classes for user input and display
    - UserDisplay - is working
need to put something above the do loop to ensure that the furthermatch creation section does not run
 */

package joeco.tournamentsimulation_run;

import joeco.tournament_configurations.TournamentBuilder;
import joeco.tournament_objects.TeamsBuilder;
import joeco.tournament_organizer.Referee;
import joeco.context_displays.InfoContextDisplay;

import java.util.Scanner;

public class TournamentInitializer {
    private static int reinitializeTournamentCheck;
    private static final Scanner userInput = new Scanner(System.in);
    private static int totalNumberOfTeams;
    
    public static void main(String[] args) {
        initializeTennisTournament();
    }
    
    private static void initializeTennisTournament(){

            //initialize the game!
            //initial team setup for tournament
            TournamentBuilder.setNumberOfTeams();
            TournamentBuilder.setTotalPlayersOnTeam();
            totalNumberOfTeams = TournamentBuilder.getNumberOfTeams();
            //team list creation
            TeamsBuilder.createInitialTeamList();
            //System.out.println("Manual team initialization or automatic?"); //go with automatic first
            TeamsBuilder.initializationOfSingleTeams();
            //System.out.println("Manual match creation or automatic?"); //go with automatic first
            Referee.randomizeTeamsList();
            Referee.createInitialMatches();
            TournamentInitializer.playThroughTeamsLoop();

    }

    private static void playThroughTeamsLoop(){
        InfoContextDisplay.displayPreMatchInformation();// 1 rounds
        Referee.updateMatchesWithWinners();
        InfoContextDisplay.displayTeamWinnerInformation();
        Referee.furtherMatchCreation();
        InfoContextDisplay.displayPreMatchInformation();// 2 rounds
        Referee.updateMatchesWithWinners();
        InfoContextDisplay.displayTeamWinnerInformation();
        Referee.furtherMatchCreation();
        InfoContextDisplay.displayPreMatchInformation();// final round, 6 teams playing
        Referee.updateMatchesWithWinners();
        InfoContextDisplay.displayTeamWinnerInformation();
    }
    
    private static int restartTournamentCheck(){
        int userPlayAgainLooper = 0;
        reinitializeTournamentCheck = 0;
        
        while(userPlayAgainLooper!=1) {
            System.out.println("\nDo you want to play again? [1:yes,2:no]");

            try {
                reinitializeTournamentCheck = Integer.parseInt(userInput.nextLine());
            } catch (Exception e) {
                System.out.println("***WARNING***: Please choose [1:yes,2:no].");
            }

            if (reinitializeTournamentCheck == 1) {
                userPlayAgainLooper = 1;
                resetProgram();
            }
            if(reinitializeTournamentCheck == 2){
                userPlayAgainLooper = 1;
                closeProgram();
            }
        }
        return reinitializeTournamentCheck;
    }

    private static void closeProgram(){
        System.out.println("You have exited the Tennis Tournament Simulation.");
    }

    private static void resetProgram(){
        System.out.println("\nTennis Tournament Simulation has been restarted...\n");
        TeamsBuilder.teamList.clear();
    }
    
}
