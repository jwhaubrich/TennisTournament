/*
Tennis tournament (4 hours) Develop a simple implementation of a tennis tournament that admits
different types of matches (between women, between men and mixed between 2 and 4 participants).
The system should allow referees to create matches and enter scores for each matchup, and allow
fans to view the entered results.  The basic concepts seen will be evaluated, it is not necessary
to build databases or APIS or user interface (data entered by console is allowed).

Work Log:
1. Teams Object is created with constructors for which each team should have
2. TeamsCreation Class is created to create list of all possible teams entered in by the user
    - functionality to create the teams, store them, and recall information located within them
3. Match object is created with constructors with which each match should have
4. MatchStoring Object is created to create matches between teams by taking random number from referee
    - functionality includes matching two teams together and storing it within a match object along with the match number
 */

import java.util.Scanner;


public class Main {




    public static void main(String[] args) {
        int numberOfTeams = 0;
        //System.out.println("Welcome to the Tennis Tournament Implementation \n");
        //System.out.println("How many teams are playing? *Must be even to play*: ");
        //can check for evenness above
        /*
        Scanner input = new Scanner(System.in);

        try {
            numberOfTeams = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println("Not an integer\n");
        }*/


        TeamsCreation.createTeams(6);
        Referee.createMatches(6);
        //System.out.println("Printing out the first team from the matchArrayList");
        //System.out.println(MatchStoring.matchArrayList.get(0).getMatchNumber()); //remember that the FIRST match is 0, index on 0
        //System.out.println("Getting back to main?");
        //Referee.assignScoresAndWinners();

    }
}
