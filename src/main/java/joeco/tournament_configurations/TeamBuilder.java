package joeco.tournament_configurations;

import joeco.tournament_objects.SingleTeam;
import joeco.tournament_exe.TournamentInitializer;
import joeco.utils.SharedVariables;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class TeamBuilder {

    private static ArrayList<SingleTeam> teamList = new ArrayList<>();
    private static boolean numberOfTeamsSetCheck = false;
    private static int totalNumberOfTeams;
    private static final Scanner input = new Scanner(System.in);
    public static int gTotalMatchesToPlay;
    private static boolean playersPerTeamCheck = false;
    private static int totalPlayersOnTeam;
    private static boolean males = false;
    private static boolean females = false;
    private static boolean mixedGender = false;


    private TeamBuilder() {
    }

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

    public static void malesOrFemalesCheck() {
        boolean genderSetCheck = false;
        String tournamentGender;

        while(!genderSetCheck) {
            System.out.println("Is the tournament for males, females, or mixed gender?");
            tournamentGender = input.nextLine().toUpperCase(Locale.ROOT);

            if (SharedVariables.GENDER_LIST.contains(tournamentGender)) {
                if (tournamentGender.contains("MALES")) {
                    TeamBuilder.setMalesAndFemales("MALES");
                }
                if (tournamentGender.contains("FEMALES")) {
                    TeamBuilder.setMalesAndFemales("FEMALES");
                }
                if (tournamentGender.contains("MIXED GENDER")) {
                    TeamBuilder.setMalesAndFemales("MIXED GENDER");
                }
                genderSetCheck = true;
            }
            else{
                System.out.println("Please enter in males, females, or mixed gender");
                genderSetCheck = false;
            }
        }
    }

    public static void setMalesAndFemales(String tournamentGender){

    }

    public static void createInitialTeamList(){
        for(int i = 1; TeamBuilder.getNumberOfTeams() >= i; i++){
            teamList.add(new SingleTeam(i));
        }
    }

    public static void resetTeamInfo(){
        numberOfTeamsSetCheck = false;
        playersPerTeamCheck = false;
    }

    public static void clearTeamList() {
        TeamBuilder.teamList.clear();
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

    public static ArrayList<SingleTeam> getTeamList() {
        return teamList;
    }


}
