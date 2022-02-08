import java.util.ArrayList;
import java.util.Scanner;

public class TeamsCreation {

    static ArrayList<Team> teamsList = new ArrayList<>();

    public static void createTeams(int numberOfTeams){
        /*create list of all possible teams
        with ArrayList we don't need to give it a specific size
        */

        Scanner input = new Scanner(System.in);
        int numberOfMen = 0;
        int numberOfWomen = 0;
        int playerCount = 0;
        int teamNumber;

        //adding my own teams so that I can test the functionality


        /*
        for (teamNumber = 1; numberOfTeams >= teamNumber; teamNumber++) {
            System.out.println("For Team " + teamNumber + " what's the total number of players (2-4): ");
            //check to make sure that men and women add up to the number provided
            try {
                playerCount = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Not a number");
            }
            System.out.println("Total number of men?: ");
            try {
                numberOfMen = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Not a number");
            }
            System.out.println("Total number of women?: ");
            try {
                numberOfWomen = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Not a number");
            }

            teamsList.add(new Team(playerCount, numberOfMen, numberOfWomen, teamNumber));*/

        }
    }
