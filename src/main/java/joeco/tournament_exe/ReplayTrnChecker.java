package joeco.tournamentsimulation_run;

import joeco.context_displays.InfoContextDisplay;
import joeco.tournament_configurations.MatchUpdater;
import joeco.tournament_configurations.TeamUpdater;
import joeco.tournament_organizer.Referee;

import java.util.Scanner;

public class ReplayTrnChecker {

    private static final Scanner userInput = new Scanner(System.in);

    public static void checkIfToRestartTournament(){
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
    }

    private static void resetProgram(){
        System.out.println("\nTennis Tournament Simulation has been restarted...\n");
        TeamUpdater.clearTeamData();
        Referee.clearRandomizedTeams();
        MatchUpdater.clearMatchData();
        InfoContextDisplay.resetNumberOfRound();
        TournamentInitializer.gMatchesPlayed = 0;

        TournamentInitializer.initializeTennisTournament();
    }

    private static void closeProgram(){
        System.out.println("You have exited the Tennis Tournament Simulation.");
    }
}
