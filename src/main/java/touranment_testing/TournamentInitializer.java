/*
create methods to restart the program and close the program - DONE
do while loop inside of the initializeTennisTournament
don't have the reinitalizeTournamentCheck equal to anything at the top
 */

package touranment_testing;

import tournament_configurations.TournamentBuilder;
import tournament_objects.TeamsBuilder;
import tournament_organizer.Referee;

import java.util.Scanner;

public class TournamentInitializer {
    private static int reinitializeTournamentCheck = 1; //if this isn't set to anything, could have a do while in initalize tennistournament
    private static final Scanner userInput = new Scanner(System.in);
    
    public static void main(String[] args) {
        initializeTennisTournament();
    }
    
    private static void initializeTennisTournament(){

        //initialize the game!
        while(reinitializeTournamentCheck==1){
            //initial team setup for tournament
            TournamentBuilder.setNumberOfTeams();
            TournamentBuilder.setNumberOfPlayersOnTeam();
            //team list creation
            TeamsBuilder.createTeamList();
            //System.out.println("Manual team initialization or automatic?"); //go with automatic first
            TeamsBuilder.teamAutoInitialization();
            //System.out.println("Manual match creation or automatic?"); //go with automatic first
            Referee.randomizeTeams();
            Referee.createTeamMatches();

            int totalTeams = TournamentBuilder.getNumberOfTeams(); //looper to count down match runs
            System.out.println("round counter: "+totalTeams);

            //code below are good for numbers 2 - 8, but not for 10 and above
            if(totalTeams==2||totalTeams==4||totalTeams==6||totalTeams==8) {
                while (totalTeams > 2) {
                    Referee.displayCurrentMatches();
                    Referee.updateMatchesWithWinners();
                    Referee.displayTotalMatchInfo();
                    Referee.furtherMatchCreation();
                    totalTeams = totalTeams / 2;
                }
                Referee.displayCurrentMatches();
                Referee.updateMatchesWithWinners();
                Referee.displayTotalMatchInfo();
            }

            reinitializeTournamentCheck = restartTournamentCheck();

        }
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
            else if(reinitializeTournamentCheck == 2){
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
