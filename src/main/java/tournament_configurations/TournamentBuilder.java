package tournament_configurations;

import java.util.Scanner;

public class TournamentBuilder {
    private static int totalNumberOfTeams;
    private static int totalPlayersOnTeam;
    private static boolean numberOfTeamsSetCheck = false;
    static Scanner input = new Scanner(System.in);
    
    public static void setNumberOfTeams(){

        while(!numberOfTeamsSetCheck){
            System.out.println("How many teams are playing? (Enter even number): ");

            try {
                totalNumberOfTeams = Integer.parseInt((input.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("Not a number!\n");
            }

            if (totalNumberOfTeams % 2 == 0) {
                numberOfTeamsSetCheck = true;
            } else {
                System.out.println("***Warning***: Please enter an even number.\n");
                totalNumberOfTeams = 0;
            }
        }
    }

    public static void setNumberOfPlayersOnTeam(){
        int playersPerTeamCheck = 0;

        while(playersPerTeamCheck != 1 || totalNumberOfTeams==0) {
            System.out.println("Will this tournament be for 2 or 4 player teams?: ");

            try {
                totalPlayersOnTeam = Integer.parseInt((input.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("Not a number!\n");
            }

            if (totalPlayersOnTeam % 2 == 0) {
                playersPerTeamCheck = 1;
            } else {
                System.out.println("***Warning***: Please enter an even number.\n");
                playersPerTeamCheck = 0;
            }
        }
    }

    public static int getTotalPlayersOnTeam(){
        return totalPlayersOnTeam;
    }

    public static int getNumberOfTeams(){
        return totalNumberOfTeams;
    }

}
