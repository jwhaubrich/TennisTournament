package joeco.tournament_configurations;

import joeco.tournament_objects.SingleMatch;
import joeco.tournament_objects.SingleTeam;
import joeco.tournament_organizer.Referee;

import java.util.ArrayList;
import java.util.Scanner;

import static joeco.tournament_organizer.Referee.*;
import static joeco.tournamentsimulation_run.TournamentInitializer.gMatchCountDown;
import static joeco.utils.SharedVariables.sittingOutTeam;
import static joeco.utils.SharedVariables.teamSittingOutCheck;
import static joeco.utils.SharedVariables.gListOfMatches;

/*System.out.println("***MatchBuildUpdate - gMatchCountDown variable: ***"+gMatchCountDown);
System.out.println("MatchBuildUpdate - gMatchCountDown variable:" +gMatchCountDown);
System.out.println("MatchBuildUpdate - updateCounter variable:" +updateCounter);
*/
public class MatchBuildUpdate {
    public static ArrayList<SingleTeam> gListWinningTeams = new ArrayList<>();
    //;
    public static int matchToUpdate;
    public static int scoreTeam1;
    public static int scoreTeam2;

    public static void assignWinOrLossToTeams(){
        //how can I make it so the user is only able to select the number of matches that are available?
        Scanner input = new Scanner(System.in);
        int updateCounter = 0;

        System.out.println("\nYou will now assign scores to each team, depending on each match.");

        while((updateCounter < gMatchCountDown)||(gMatchCountDown==0)) { //go through all the matches, updateCounter increase per match
            System.out.println("\nType out the match number for which teams to update: ");
            //ensures that the user only chooses a match from the ones that are available
            matchToUpdate = Integer.parseInt(input.nextLine()) - 1;

            if(gMatchCountDown!=0) {
                if (0 <= matchToUpdate && matchToUpdate < gMatchCountDown) { //comeback: not sure if logic is right
                    System.out.println("What is the score for Team "
                            + gListOfMatches.get(matchToUpdate).getTeamOne().getTeamNumber() + "?: ");
                    scoreTeam1 = Integer.parseInt((input.nextLine()));
                    System.out.println("What is the score for Team "
                            + gListOfMatches.get(matchToUpdate).getTeamTwo().getTeamNumber() + "?: ");
                    scoreTeam2 = Integer.parseInt((input.nextLine()));
                    System.out.println("Setting scores for teams...");

                    MatchBuildUpdate.updateTeamScoresInMatch();
                    MatchBuildUpdate.updateWinningTeamListWithTeamInfo();
                    //maybe refactor method above to just do this once and not each time the
                    //scores are set for the team
                }
            }
            else { //last match
                System.out.println("What is the score for Team "
                        + gListOfMatches.get(matchToUpdate).getTeamOne().getTeamNumber() + "?: ");
                scoreTeam1 = Integer.parseInt((input.nextLine()));
                System.out.println("What is the score for Team "
                        + gListOfMatches.get(matchToUpdate).getTeamTwo().getTeamNumber() + "?: ");
                scoreTeam2 = Integer.parseInt((input.nextLine()));
                System.out.println("Setting scores for teams...");

                MatchBuildUpdate.updateTeamScoresInMatch();
                MatchBuildUpdate.updateWinningTeamListWithTeamInfo();

                return;
            }
            updateCounter++;
        }
        gMatchCountDown = gListWinningTeams.size()/2;
        //System.out.println("MatchBuildUpdate - gMatchCountDown variable:" +gMatchCountDown);
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
            MatchBuildUpdate.gListWinningTeams.add(gListOfMatches.get(matchToUpdate).getTeamOne());
        }

        if(scoreTeam2 > scoreTeam1){
            gListOfMatches.get(matchToUpdate).setWinningTeam(gListOfMatches.get
                    (matchToUpdate).getTeamTwo().getTeamNumber());
            gListOfMatches.get(matchToUpdate).setWinningScore(scoreTeam2);
            MatchBuildUpdate.gListWinningTeams.add(gListOfMatches.get(matchToUpdate).getTeamTwo());
        }
    }

    //must go through and refactor this method
    //after I updated the totalMatches variable that was in Referee and I put it in TournamentBuilder
    //I don't think this method will work anymore

    public static void createNextTeamMatches(){
        //I could see about combining this method with the randomize teams method in Referee.randomizeTeamsList
        gListOfMatches.clear();
        Referee.getRandomizedTeamList().clear();
        int newTotalTeams = gListWinningTeams.size();


        for(int i = 0; newTotalTeams > i; i++){
            Referee.getRandomizedTeamList().add(gListWinningTeams.get(i));
        }

        if(teamSittingOutCheck==true){
            Referee.getRandomizedTeamList().add(sittingOutTeam);
            teamSittingOutCheck = false;
        }

        if((getRandomizedTeamList().size()%2)==1){
            sittingOutTeam = getRandomizedTeamList().get((getRandomizedTeamList().size()-1));
            getRandomizedTeamList().remove((getRandomizedTeamList().size()-1));
            newTotalTeams = newTotalTeams - 1;
            teamSittingOutCheck = true;
        }

        for(int i = 0; newTotalTeams  > i; i = i + 2){ //algorithm to create the matches(team vs team). functioning/tested.
            gListOfMatches.add(new SingleMatch(getRandomizedTeamList().get(i), getRandomizedTeamList().get(i+1)));
        }

        for(int i = 0; gMatchCountDown  > i; i++){ //algorithm that sets match numbers to each match.
            gListOfMatches.get(i).setMatchNumber(i+1);
        }

        gListWinningTeams.clear(); //clears out everything in the winning teams array to be used with the next winners
    }

    public static void clearGlobalMatchList(){
        gListOfMatches.clear();
    }

    public static void resetGMatchCountDown(){
        gMatchCountDown = 100;
    }
}
