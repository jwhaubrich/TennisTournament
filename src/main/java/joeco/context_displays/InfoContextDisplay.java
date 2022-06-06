package joeco.context_displays;

import java.util.Scanner;

import static joeco.tournament_exe.TournamentInitializer.gMatchCountDown;
import static joeco.tournament_exe.TournamentInitializer.gMatchesPlayed;
import static joeco.utils.SharedVariables.gListOfMatches;
import static joeco.utils.SharedVariables.teamSittingOutCheck;

public class InfoContextDisplay {
    private static int numberOfRound = 1;

    private InfoContextDisplay() {
    }

    public static void displayPreMatchInformation() {
        InfoContextDisplay.normalOrFinalRoundChecker();
        PreMatchContextDisplay.displayTeamVsTeamMatch();
        PreMatchContextDisplay.sittingOutTeamChecker();
        numberOfRound++;
    }

    public static void normalOrFinalRoundChecker(){
        if (((gMatchCountDown == 0)||(gMatchCountDown==1)) && (!teamSittingOutCheck)){
            System.out.println("__________FINAL Round:__________");
        } else {
            System.out.println("_______________________________________________________________________");
            System.out.println("\n__________Round " + numberOfRound + ":__________");
        }
    }

    public static void displayTeamWinnerInformation() {
        PostMatchContextDisplay.displayTeamWinnerInformation();
        PostMatchContextDisplay.sittingOutTeamChecker();
    }

    public static void checkIfDisplayTeamIndividuals(){
        int teamToCheck = 0;
        boolean enteredOneOrTwo = false;
        Scanner input = new Scanner(System.in);

        System.out.println("\n*****These are the initial matches and teams*****\n" +
                "Do you want to see the number of individuals on each team? [1/yes,2/no]");

        InfoContextDisplay.displayMatchAndTeamInfo();

        while(!enteredOneOrTwo) {
            try {
                teamToCheck = Integer.parseInt((input.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("Type a number next time.");
            }
            if(teamToCheck == 1|| teamToCheck == 2){
                enteredOneOrTwo = true;
                if (teamToCheck == 1) {
                    InfoContextDisplay.displayTeamIndividuals();
                }
                if (teamToCheck == 2) {
                    break;
                }
            }
            else{
                System.out.println("Please only enter 1 or 2.");
                System.out.println("Do you want to see the number of individuals on each team? [1/yes,2/no]");
            }
        }
    }

    public static void displayTeamIndividuals(){
        int matchTeamToDisplay;
        int keepReviewingCheck = 0;
        boolean keepDisplayingMatchTeamIndividuals = false;
        Scanner input = new Scanner(System.in);

        while(!keepDisplayingMatchTeamIndividuals) {
            System.out.println("Which match do you want to see?");
            matchTeamToDisplay = Integer.parseInt(input.nextLine()) - 1;

            System.out.println("***Match " + gListOfMatches.get(matchTeamToDisplay).getMatchNumber() + " Information***");
            System.out.println("\tTeam " + gListOfMatches.get(matchTeamToDisplay).getTeamOne().getTeamNumber());
            System.out.println("\t\tNumber of males: " + gListOfMatches.get(matchTeamToDisplay).getTeamOne().getNumberOfMales());
            System.out.println("\t\tNumber of females: " + gListOfMatches.get(matchTeamToDisplay).getTeamOne().getNumberOfFemales());
            System.out.println("\tTeam " + gListOfMatches.get(matchTeamToDisplay).getTeamTwo().getTeamNumber());
            System.out.println("\t\tNumber of males: " + gListOfMatches.get(matchTeamToDisplay).getTeamTwo().getNumberOfMales());
            System.out.println("\t\tNumber of females: " + gListOfMatches.get(matchTeamToDisplay).getTeamTwo().getNumberOfFemales());
            System.out.println("\n Would you like to keep reviewing the individuals on each team? [1/yes,2/no]");
            try {
                keepReviewingCheck = Integer.parseInt((input.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("Type a number next time.");
            }
            if(keepReviewingCheck == 1|| keepReviewingCheck == 2){
                keepDisplayingMatchTeamIndividuals = true;
                if (keepReviewingCheck == 1) {
                    InfoContextDisplay.displayMatchAndTeamInfo();
                    InfoContextDisplay.displayTeamIndividuals();
                }
                if (keepReviewingCheck == 2) {
                    break;
                }
            }
        }
    }

    public static void displayMatchAndTeamInfo(){
        for (int i = 0; gMatchCountDown > i; i++) {
            System.out.println("Match " + (i + 1) + ": Team " + gListOfMatches.get(i).getTeamOne().getTeamNumber() + " vs Team "
                    + gListOfMatches.get(i).getTeamTwo().getTeamNumber());
            gMatchesPlayed++;
        }
    }

    public static void resetNumberOfRound(){
        numberOfRound = 1;
    }

}
