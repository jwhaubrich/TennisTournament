package joeco.tournament_configurations;

import joeco.tournamentsimulation_run.TournamentInitializer;

import java.util.Scanner;

public class TournamentBuilder {
    private static int totalNumberOfTeams;
    private static int totalPlayersOnTeam;
    private static final Scanner input = new Scanner(System.in);
    public static int gTotalMatchesToPlay;
    private static boolean numberOfTeamsSetCheck = false;
    private static boolean playersPerTeamCheck = false;

    public static void setNumberOfTeams(){

        while(!numberOfTeamsSetCheck){
            System.out.println("How many teams are playing? (Enter an even number): ");

            try {
                totalNumberOfTeams = Integer.parseInt((input.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("***Warning***: Not a number.\n");
                totalNumberOfTeams = 1;
            }

            if (totalNumberOfTeams % 2 == 0) { //this statement ensures that the user enters even number
                numberOfTeamsSetCheck = true;
            } else {
                System.out.println("***Warning***: Please enter an even number.\n");
                totalNumberOfTeams = 0;
            }
            if(totalNumberOfTeams ==2){
                TournamentInitializer.gMatchCountDown = 1;
            }
        }
        gTotalMatchesToPlay = totalNumberOfTeams-1;
    }

    public static void resetTeamInfo(){
        numberOfTeamsSetCheck = false;
        playersPerTeamCheck = false;
    }

    public static void setTotalPlayersOnTeam(){

        while(!playersPerTeamCheck) {
            System.out.println("Will this tournament be for 2 or 4 player teams?: ");

            try {
                totalPlayersOnTeam = Integer.parseInt((input.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("***WARNING***: Not a number.");
                totalPlayersOnTeam = 1;
            }

            if(totalPlayersOnTeam == 2 || totalPlayersOnTeam == 4){
                if (totalPlayersOnTeam % 2 == 0) {
                    playersPerTeamCheck = true;
                }
            }
             else {
                System.out.println("***Warning***: Please select 2 or 4.\n");
            }
        }
    }

    public static int getTotalPlayersOnTeam(){
        return totalPlayersOnTeam;
    }

    public static int getNumberOfTeams(){
        return totalNumberOfTeams;
    }

    public static int getTotalMatchesToPlay(){
        return gTotalMatchesToPlay;
    }

}
