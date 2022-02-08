/*
Tennis tournament (4 hours) Develop a simple implementation of a tennis tournament that admits
different types of matches (between women, between men and mixed between 2 and 4 participants).
The system should allow referees to create matches and enter scores for each matchup, and allow
fans to view the entered results.  The basic concepts seen will be evaluated, it is not necessary
to build databases or APIS or user interface (data entered by console is allowed).

Flow:
    1. Welcome to the Tennis Tournament Implementation
    2. How many teams are there? Must be even to play.
        - for each team, ask the user how many men and women up to 4 participants
    4. The referee has randomly created matches between teams and entered scores for each match
    5. Print out matches for the user to select to find the score.


Objects to create:
1. Tennis tournament itself
    - will be used to store the individual matches (1, 2, 3, 4, 5) between teams and the result of the match
    - fields:
    - methods:
2. Match:
    - consists of one team versus another team
    - fields:
    - methods:
3.Team:
    - consists of random number of men
    - consists of random number of women
3. Referee:
    - Referees create the matches between teams
    - fields:
    - methods:
4. Fan view:
    - fields
    - methods:

 */

import java.util.Scanner;
/*
Objects to create:
Bracket of teams
Individual match
individual teams
referee object to create matches between teams and assign winning scores
 */
public class Main {
    //static int numberOfTeamsGlob = 0; //making this static so that other classes can use this field
    // guess the above doesn't work

    public static void main(String[] args) {
        int numberOfTeams = 0;
        System.out.println("Welcome to the Tennis Tournament Implementation \n");
        System.out.println("How many teams are playing? *Must be even to play*: ");
        //can check for evenness
        /*
        Scanner input = new Scanner(System.in);

        try {
            numberOfTeams = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println("Not an integer\n");
        }*/
        TeamsCreation.createTeams(2);
        Referee.createMatches(2);
        TournamentBracket.tBracket.get(1);
    }
}
