package joeco.tournamentsimulation_run;

import joeco.tournament_configurations.*;
import joeco.tournament_organizer.Referee;
import joeco.context_displays.InfoContextDisplay;

import java.util.Scanner;

import static joeco.utils.SharedVariables.teamSittingOutCheck;

public class TournamentInitializer {
    private static final Scanner userInput = new Scanner(System.in);
    public static int gMatchCountDown;
    public static int gMatchesPlayed = 0;
    
    public static void main(String[] args) {
        initializeTennisTournament();
    }
    
    private static void initializeTennisTournament(){

            TeamBuilder.setNumberOfTeams();
            gMatchCountDown = TeamBuilder.getNumberOfTeams()/2;
            TeamBuilder.setTotalPlayersOnTeam();
            TeamBuilder.createInitialTeamList();
            TeamUpdater.addInfoToTeams();
            Referee.randomizeTeamsList(TeamBuilder.getTeamList());
            Referee.createInitialMatches();
            TournamentInitializer.playTournament();
    }

    private static void playTournament(){

            while (gMatchesPlayed < TeamBuilder.getTotalMatchesToPlay() - 1) {

                if(((gMatchCountDown== 0)||(gMatchCountDown==1)) && (!teamSittingOutCheck)){
                    InfoContextDisplay.displayPreMatchInformation();
                    Referee.updateMatchWithTeamScores();
                    InfoContextDisplay.displayTeamWinnerInformation();
                    TournamentInitializer.checkIfToRestartTournament();
                }
                InfoContextDisplay.displayPreMatchInformation();
                Referee.updateMatchWithTeamScores();
                InfoContextDisplay.displayTeamWinnerInformation();
                MatchBuilder.createNextTeamMatches();
            }
        InfoContextDisplay.displayPreMatchInformation();
        Referee.updateMatchWithTeamScores();
        InfoContextDisplay.displayTeamWinnerInformation();
        TournamentInitializer.checkIfToRestartTournament();

    }

    private static void checkIfToRestartTournament(){
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

    private static void closeProgram(){
        System.out.println("You have exited the Tennis Tournament Simulation.");
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
    
}
