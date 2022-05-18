package touranment_testing;

import tournament_configurations.TournamentBuilder;
import tournament_objects.TeamStoring;
import tournament_organizer.Referee;

import java.util.Scanner;
//make it so the team that's sitting out HAS to play the next round
//print to the user which team is sitting out when the matches and rounds are listed so they're not confused
//when entering which teams to enter scores for, implement some kind of error check
//when entering scores for each team, show which teams played in the match

public class TournamentTesting{

    public static void main(String[] args) {
        int keepPlayingCheck = 1;
        Scanner userInput = new Scanner(System.in);

        //initialize the game!
        while(keepPlayingCheck==1){
            //initial team setup for tournament
            TournamentBuilder.setNumberOfTeams();
            TournamentBuilder.setNumberOfPlayersOnTeam();
            //team list creation
            TeamStoring.createTeamList();
            //System.out.println("Manual team initialization or automatic?"); //go with automatic first
            TeamStoring.teamAutoInitialization();
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


            System.out.println("\nDo you want to play again? (1:yes,2:no)");
            keepPlayingCheck = Integer.parseInt(userInput.nextLine());

            if(keepPlayingCheck==1){
                System.out.println("\nRestarting simulation...");
                System.out.println("Previous game cleared!...\n");

                TeamStoring.teamList.clear();
            }
        }
    }
}
