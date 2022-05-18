package touranment_testing;

import tournament_configurations.TournamentBuilder;
import tournament_objects.TeamsBuilder;
import tournament_organizer.Referee;

import java.util.Scanner;
//make it so the team that's sitting out HAS to play the next round
//print to the user which team is sitting out when the matches and rounds are listed so they're not confused
//when entering which teams to enter scores for, implement some kind of error check
//when entering scores for each team, show which teams played in the match

public class TournamentInitializer {
    private static int reinitializeTournamentCheck = 1;
    private static final Scanner userInput = new Scanner(System.in);
    
    public static void main(String[] args) {
        initializeTennisTournament();
    }
    
    public static void initializeTennisTournament(){

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
    
    public static int restartTournamentCheck(){
        int restartTournamentCheckLooper = 0;

        while(restartTournamentCheckLooper!=1) {
            System.out.println("\nDo you want to play again? [1:yes,2:no]");

            try {
                reinitializeTournamentCheck = Integer.parseInt(userInput.nextLine());
            } catch (Exception e) {
                System.out.println("Not a valid selection.");
            }

            if (reinitializeTournamentCheck == 1) {
                System.out.println("\nRestarting simulation...");
                System.out.println("Previous game cleared!...\n");
                TeamsBuilder.teamList.clear();
                restartTournamentCheckLooper = 1;
            }
            else if(reinitializeTournamentCheck == 2){
                System.out.println("You have exited the program.");
                restartTournamentCheckLooper = 1;
            }
            else{
                System.out.println("***WARNING***: Please enter [1:yes, 2:no]");
            }
        }

        return reinitializeTournamentCheck;
    }
    
}
