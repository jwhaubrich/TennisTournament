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

package joeco.touranment_testing;

import joeco.tournament_configurations.TournamentBuilder;
import joeco.tournament_objects.TeamsBuilder;
import joeco.tournament_organizer.Referee;
import joeco.user_interaction.UserDisplay;

import java.util.Scanner;

public class TournamentInitializer {
    private static int reinitializeTournamentCheck;
    private static final Scanner userInput = new Scanner(System.in);
    private static int totalNumberOfTeams = TournamentBuilder.getNumberOfTeams();
    
    public static void main(String[] args) {
        initializeTennisTournament();
    }
    
    private static void initializeTennisTournament(){
        int numberOfMatchesCountdown;

        do{
            //initialize the game!
            //initial team setup for tournament
            TournamentBuilder.setNumberOfTeams();
            TournamentBuilder.setTotalPlayersOnTeam();
            //team list creation
            TeamsBuilder.createInitialTeamList();
            //System.out.println("Manual team initialization or automatic?"); //go with automatic first
            TeamsBuilder.initializationOfSingleTeams();
            //System.out.println("Manual match creation or automatic?"); //go with automatic first
            Referee.randomizeTeamsList();
            Referee.createInitialMatches();

            numberOfMatchesCountdown = TournamentBuilder.getNumberOfTeams(); //looper to count down match runs

            //something has to go HERE to see if everything inside of the do loop is necessary
            //maybe if the number of teams is two...
            do {
                UserDisplay.displayMatchInformation();
                Referee.updateMatchesWithWinners();
                UserDisplay.displayTotalMatchInfo();
                Referee.furtherMatchCreation(); //stops here in the code
                numberOfMatchesCountdown = numberOfMatchesCountdown / 2;
            } while (numberOfMatchesCountdown > 2);
                UserDisplay.displayMatchInformation();
                Referee.updateMatchesWithWinners();
                UserDisplay.displayTotalMatchInfo();

            //code below are good for numbers 2 - 8, but not for 10 and above
            /*if(totalNumberOfTeams==2||totalNumberOfTeams==4||totalNumberOfTeams==6||totalNumberOfTeams==8) {
                while (numberOfMatchesCountdown > 2) {
                    Referee.displayCurrentMatches();
                    Referee.updateMatchesWithWinners();
                    Referee.displayTotalMatchInfo();
                    Referee.furtherMatchCreation();
                    numberOfMatchesCountdown = numberOfMatchesCountdown / 2;
                }
                Referee.displayCurrentMatches();
                Referee.updateMatchesWithWinners();
                Referee.displayTotalMatchInfo();
            }*/
            reinitializeTournamentCheck = restartTournamentCheck();
        } while(reinitializeTournamentCheck==1);
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
