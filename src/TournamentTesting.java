/*
Tennis tournament (4 hours) Develop a simple implementation of a tennis tournament that admits
different types of matches (between women, between men and mixed between 2 and 4 participants).
The system should allow referees to create matches and enter scores for each matchup, and allow
fans to view the entered results.  The basic concepts seen will be evaluated, it is not necessary
to build databases or APIS or user interface (data entered by console is allowed).

Work Log:
1. Created classes for storing the individual teams (TeamStoring.java), individual team object (IndividualTeam.java),
an object to store info obtained from user (TournamentConfigs.java)

 */

import java.util.Scanner;


public class TournamentTesting{

    public static void main(String[] args) {
        //System.out.println("Welcome to the Tennis Tournament Simulator\n");
        //TournamentConfigs.setNumberOfTeams();
        //TournamentConfigs.setNumberOfPlayersOnTeam();
        TeamStoring.createTeamList();
        //Up to here the teams list have been created. Individual teams are blank
        //System.out.println("Manual team initialization or automatic?"); //go with automatic first
        TeamStoring.teamAutoInitalization();
        //up to here the teams are initialized with a number of players. Each team has a team number.
        //System.out.println("Manual match creation or automatic?"); //go with automatic first

    }
}
