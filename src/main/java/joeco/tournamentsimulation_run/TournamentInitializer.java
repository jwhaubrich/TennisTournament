package joeco.tournamentsimulation_run;

import joeco.tournament_configurations.TournamentBuilder;
import joeco.tournament_configurations.TeamsBuilder;
import joeco.tournament_configurations.MatchBuildUpdate;
import joeco.tournament_organizer.Referee;
import joeco.context_displays.InfoContextDisplay;

import java.util.Scanner;

public class TournamentInitializer {
    private static final Scanner userInput = new Scanner(System.in);
    
    public static void main(String[] args) {
        initializeTennisTournament();
    }
    
    private static void initializeTennisTournament(){
        int totalNumberOfTeams; //depending on how I use this variable I might not need the variable
        //in the first place, just the TournamentBuilder.getNumberOfTeams

            //initialize the game!
            //initial team setup for tournament
            TournamentBuilder.setNumberOfTeams();
            TournamentBuilder.setTotalPlayersOnTeam();
            totalNumberOfTeams = TournamentBuilder.getNumberOfTeams();
            //team list creation
            TeamsBuilder.createInitialTeamList();
            //System.out.println("Manual team initialization or automatic?"); //go with automatic first
            TeamsBuilder.addInfoToTeams();
            //System.out.println("Manual match creation or automatic?"); //go with automatic first
            Referee.randomizeTeamsList();
            Referee.createInitialMatches();
            TournamentInitializer.playThroughTeamsLoop();

    }

    private static void playThroughTeamsLoop(){
        InfoContextDisplay.displayPreMatchInformation();// 1 rounds
        Referee.updateMatchWithTeamScores();
        InfoContextDisplay.displayTeamWinnerInformation();
        MatchBuildUpdate.createNextTeamMatches();
        InfoContextDisplay.displayPreMatchInformation();// 2 rounds
        Referee.updateMatchWithTeamScores();
        InfoContextDisplay.displayTeamWinnerInformation();
        MatchBuildUpdate.createNextTeamMatches();
        InfoContextDisplay.displayPreMatchInformation();// final round, 6 teams playing
        Referee.updateMatchWithTeamScores();
        InfoContextDisplay.displayTeamWinnerInformation();
    }

    //not using this method yet
    private static int checkIfToRestartTournament(){
        int userPlayAgainLooper = 0;
        int reinitializeTournamentCheck = 0;
        
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
        TeamsBuilder.clearTeamList();
    }
    
}
