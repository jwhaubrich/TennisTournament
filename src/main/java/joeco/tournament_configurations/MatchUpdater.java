package joeco.tournament_configurations;

import joeco.tournament_objects.SingleTeam;
import java.util.ArrayList;
import java.util.Scanner;
import static joeco.tournament_exe.TournamentInitializer.gMatchCountDown;
import static joeco.utils.SharedVariables.gListOfMatches;


public class MatchUpdater {
    public static ArrayList<SingleTeam> gListWinningTeams = new ArrayList<>();
    public static int matchToUpdate;
    public static int scoreTeam1;
    public static int scoreTeam2;

    public static void assignWinOrLossToTeams(){
        //how can I make it so the user is only able to select the number of matches that are available?
        Scanner input = new Scanner(System.in);
        int updateCounter = 0;

        System.out.println("\nYou will now assign scores to each team, depending on each match.");

        while((updateCounter < gMatchCountDown)||(gMatchCountDown==0)) {
            System.out.println("\nType out the match number for which teams to update: ");

            matchToUpdate = Integer.parseInt(input.nextLine()) - 1;

            if(gMatchCountDown!=0) {
                if (0 <= matchToUpdate && matchToUpdate < gMatchCountDown) {
                    System.out.println("What is the score for Team "
                            + gListOfMatches.get(matchToUpdate).getTeamOne().getTeamNumber() + "?: ");
                    scoreTeam1 = Integer.parseInt((input.nextLine()));
                    System.out.println("What is the score for Team "
                            + gListOfMatches.get(matchToUpdate).getTeamTwo().getTeamNumber() + "?: ");
                    scoreTeam2 = Integer.parseInt((input.nextLine()));
                    System.out.println("Setting scores for teams...");

                    MatchUpdater.updateTeamScoresInMatch();
                    MatchUpdater.updateWinningTeamListWithTeamInfo();
                }
            }
            else {
                System.out.println("What is the score for Team "
                        + gListOfMatches.get(matchToUpdate).getTeamOne().getTeamNumber() + "?: ");
                scoreTeam1 = Integer.parseInt((input.nextLine()));
                System.out.println("What is the score for Team "
                        + gListOfMatches.get(matchToUpdate).getTeamTwo().getTeamNumber() + "?: ");
                scoreTeam2 = Integer.parseInt((input.nextLine()));
                System.out.println("Setting scores for teams...");

                MatchUpdater.updateTeamScoresInMatch();
                MatchUpdater.updateWinningTeamListWithTeamInfo();

                return;
            }
            updateCounter++;
        }
        gMatchCountDown = gListWinningTeams.size()/2;
    }

    public static void updateTeamScoresInMatch(){
        gListOfMatches.get(matchToUpdate).getTeamOne().setFinalScore(scoreTeam1);
        gListOfMatches.get(matchToUpdate).getTeamOne().setFinalScore(scoreTeam2);
    }

    public static void updateWinningTeamListWithTeamInfo(){
        if(scoreTeam1 > scoreTeam2){
            gListOfMatches.get(matchToUpdate).setWinningTeam(gListOfMatches.get
                    (matchToUpdate).getTeamOne().getTeamNumber());
            gListOfMatches.get(matchToUpdate).setWinningScore(scoreTeam1);
            MatchUpdater.gListWinningTeams.add(gListOfMatches.get(matchToUpdate).getTeamOne());
        }

        if(scoreTeam2 > scoreTeam1){
            gListOfMatches.get(matchToUpdate).setWinningTeam(gListOfMatches.get
                    (matchToUpdate).getTeamTwo().getTeamNumber());
            gListOfMatches.get(matchToUpdate).setWinningScore(scoreTeam2);
            MatchUpdater.gListWinningTeams.add(gListOfMatches.get(matchToUpdate).getTeamTwo());
        }
    }

    public static void clearMatchData(){
        gListOfMatches.clear();
        gListWinningTeams.clear();
    }

}
