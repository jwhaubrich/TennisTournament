package joeco.tournamentsimulation_run;

import joeco.tournament_configurations.TournamentBuilder;
import joeco.tournament_configurations.TeamsBuilder;
import joeco.tournament_configurations.MatchBuildUpdate;
import joeco.tournament_organizer.Referee;
import joeco.context_displays.InfoContextDisplay;
import joeco.utils.SharedVariables;

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

            TournamentBuilder.setNumberOfTeams(); //global total matches is set here
            gMatchCountDown = TournamentBuilder.getNumberOfTeams()/2;
            TournamentBuilder.setTotalPlayersOnTeam();
            TeamsBuilder.createInitialTeamList();
            //System.out.println("Manual team initialization or automatic?"); //go with automatic first
            TeamsBuilder.addInfoToTeams();
            //System.out.println("Manual match creation or automatic?"); //go with automatic first
            Referee.randomizeTeamsList(TeamsBuilder.getTeamList());
            Referee.createInitialMatches();
            TournamentInitializer.playTournament();//program works up till here
    }

    private static void playTournament(){ // 2 rounds, 1 final round, 6 teams
        System.out.println("total matches to play variable: "+ TournamentBuilder.getTotalMatchesToPlay());
        System.out.println("total number of matches played so far variable: "+ gMatchesPlayed);


            while (gMatchesPlayed < TournamentBuilder.getTotalMatchesToPlay() - 1) {
                //System.out.println("1stTournamentInitializer - gMatchCountDown variable: "+gMatchCountDown);
                if(((gMatchCountDown== 0)||(gMatchCountDown==1)) && (teamSittingOutCheck==false)){
                    System.out.println("inside IF inside WHILE");
                    InfoContextDisplay.displayPreMatchInformation();
                    Referee.updateMatchWithTeamScores();
                    InfoContextDisplay.displayTeamWinnerInformation();
                    TournamentInitializer.checkIfToRestartTournament();
                }
                System.out.println("*****inside of while loop");
                System.out.println("total matches to play variable: " + TournamentBuilder.getTotalMatchesToPlay());
                System.out.println("total number of matches played so far variable: " + gMatchesPlayed);
                InfoContextDisplay.displayPreMatchInformation();
                Referee.updateMatchWithTeamScores();
                InfoContextDisplay.displayTeamWinnerInformation();
                MatchBuildUpdate.createNextTeamMatches();
                //System.out.println("2ndTournamentInitializer - gMatchCountDown variable: "+gMatchCountDown);
                System.out.println("total number of matches played so far " + gMatchesPlayed);
            }

        System.out.println("*****outside of while loop");
        InfoContextDisplay.displayPreMatchInformation();
        Referee.updateMatchWithTeamScores();
        InfoContextDisplay.displayTeamWinnerInformation();
        TournamentInitializer.checkIfToRestartTournament();

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
        TournamentBuilder.resetTeamInfo();
        TeamsBuilder.clearTeamList();
        Referee.clearRandomizedTeams();
        MatchBuildUpdate.clearMatchData();
        InfoContextDisplay.resetNumberOfRound();

        TournamentInitializer.initializeTennisTournament();
    }
    
}
