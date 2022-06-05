package joeco.tournament_configurations;

import joeco.tournament_objects.SingleTeam;
import joeco.tournament_exe.TournamentInitializer;
import joeco.utils.SharedVariables;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TeamBuilder {

    private static ArrayList<SingleTeam> teamList = new ArrayList<>();
    private static boolean numberOfTeamsSetCheck = false;
    private static int totalNumberOfTeams;
    private static final Scanner input = new Scanner(System.in);
    public static int gTotalMatchesToPlay;
    private static boolean playersPerTeamCheck = false;
    private static int totalPlayersOnTeam;


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

            if (totalNumberOfTeams % 2 == 0) {
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
            System.out.println("Enter 1 for males, 2 for females, or mixed gender.");
            tournamentGender = input.nextLine().toUpperCase(Locale.ROOT);

            if (SharedVariables.GENDER_LIST.contains(tournamentGender)) {
                if (tournamentGender.contains("1")) {
                    TeamBuilder.setMales();
                }
                if (tournamentGender.contains("2")) {
                    TeamBuilder.setFemales();
                }
                if (tournamentGender.contains("MIXED GENDER")) {
                    TeamBuilder.setMixedGender();
                }
                genderSetCheck = true;
            }
            else{
                System.out.println("Please enter 1 for males, 2 for females, or mixed gender");
                genderSetCheck = false;
            }
        }
    }


    public static void setMales(){
        if (totalPlayersOnTeam == 2) {
            for(int i = 0; teamList.size() > i; i++){
                teamList.get(i).setNumberOfMales(2);
            }
        }
        if (totalPlayersOnTeam == 4) {
            for(int i = 0; teamList.size() > i; i++){
                teamList.get(i).setNumberOfMales(4);
            }
        }
    }

    public static void setFemales(){
        if (totalPlayersOnTeam == 2) {
            for(int i = 0; teamList.size() > i; i++){
                teamList.get(i).setNumberOfFemales(2);
            }
        }

        if (totalPlayersOnTeam == 4) {
            for(int i = 0; teamList.size() > i; i++){
                teamList.get(i).setNumberOfFemales(4);
            }
        }
    }

    public static void setMixedGender(){
        Random randomMOrFSelector = new Random();
        Random randNum2PlayersSelector = new Random();
        Random randNum4PlayersSelector = new Random();
        int malesOrFemales;
        int randomNumOf2Players;
        int randomNumOf4Players;
        int totalMalesAndFemales;

        if (totalPlayersOnTeam == 2) {
            for(int i = 0; teamList.size() > i; i++){
                totalMalesAndFemales = 0;
                while(totalMalesAndFemales != 2){
                    malesOrFemales = randomMOrFSelector.nextInt(2);
                    randomNumOf2Players = randNum2PlayersSelector.nextInt(2)+1;
                    switch(malesOrFemales){
                        case 0:
                            teamList.get(i).setNumberOfMales(randomNumOf2Players);
                            teamList.get(i).setNumberOfFemales(2-randomNumOf2Players);
                            break;
                        case 1:
                            teamList.get(i).setNumberOfFemales(randomNumOf2Players);
                            teamList.get(i).setNumberOfMales(2-randomNumOf2Players);
                            break;
                    }
                    totalMalesAndFemales = teamList.get(i).getNumberOfMales() + teamList.get(i).getNumberOfFemales();
                }
            }
        }

        if (totalPlayersOnTeam == 4) {
            for(int i = 0; teamList.size() > i; i++){
                totalMalesAndFemales = 0;
                while(totalMalesAndFemales != 4){
                    malesOrFemales = randomMOrFSelector.nextInt(4);
                    randomNumOf4Players = randNum4PlayersSelector.nextInt(4)+1;
                    switch(malesOrFemales){
                        case 0:
                            teamList.get(i).setNumberOfMales(randomNumOf4Players);
                            teamList.get(i).setNumberOfFemales(4-randomNumOf4Players);
                            break;
                        case 1:
                            teamList.get(i).setNumberOfFemales(randomNumOf4Players);
                            teamList.get(i).setNumberOfMales(4-randomNumOf4Players);
                            break;
                    }
                    totalMalesAndFemales = teamList.get(i).getNumberOfMales() + teamList.get(i).getNumberOfFemales();
                }
            }
        }
    }

    public static void createInitialTeamList(){
        for(int i = 1; TeamBuilder.getNumberOfTeams() >= i; i++){
            teamList.add(new SingleTeam(i));
            teamList.get(i-1).setNumberOfIndividuals(totalPlayersOnTeam);
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
