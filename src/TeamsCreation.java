import java.util.ArrayList;
import java.util.Scanner;

//manual teams creation, created by the user
//stores the teams created in an ArrayList

public class TeamsCreation {

    static ArrayList<Team> teamsList = new ArrayList<>();

    public static void createTeams(int numberOfTeams){
        /*create list of all possible teams with an ArrayList
        */

        Scanner input = new Scanner(System.in);
        int numberOfMen = 0;
        int numberOfWomen = 0;
        int playerCount = 0;
        int teamNumber;

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

        //adding my own teams so that I can test the functionality
        //functionality below works

        teamsList.add(new Team(8, 69, 77, 1));
        teamsList.add(new Team(2, 9, 66, 2));
        teamsList.add(new Team(4, 2, 2, 3));
        teamsList.add(new Team(6, 3, 9, 4));
        teamsList.add(new Team(4, 2, 2, 5));
        teamsList.add(new Team(6, 3, 9, 6));

        /*System.out.println("Inside TeamsCreation. Testing functionality: ");
        System.out.println(teamsList.get(0).getWomenCount());
        System.out.println(teamsList.get(1).getWomenCount());
        System.out.println(teamsList.get(2).getTeamNumber());
        System.out.println(teamsList.get(3).getTeamNumber());
        System.out.println(teamsList.get(4).getTeamNumber());
        System.out.println(teamsList.get(5).getTeamNumber());
*/
        }
    }
