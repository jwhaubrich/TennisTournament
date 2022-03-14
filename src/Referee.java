import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Referee {
    public static ArrayList<IndividualMatch> matchList = new ArrayList<>();
    public static ArrayList<IndividualTeam> winningTeams = new ArrayList<>();
    public static ArrayList<IndividualTeam> randomTeamList = new ArrayList<>();
    public static IndividualTeam sittingOutTeam;
    public static int teamSittingOutCheck = 0;
    public static int numberOfRounds = 1;
    public static int totalTeams = TournamentConfigs.getNumberOfTeams();
    public static int totalMatches = totalTeams/2;
    public static int loopCounter;


    public static void randomizeTeams(){
        Random randomNumberCreator = new Random();
        ArrayList <Integer> randomNumberList = new ArrayList<>();
        int randomNumber = 0;

        for(int i = 0; totalTeams > i; i++) {
            randomNumber = randomNumberCreator.nextInt(totalTeams);

            while (randomNumberList.contains(randomNumber)) { //find a random team to put into the list
                randomNumber = randomNumberCreator.nextInt(totalTeams);
            }

            randomTeamList.add(TeamStoring.teamList.get(randomNumber));
            randomNumberList.add(randomNumber);
        }

    }

    public static void createTeamMatches(){ //creates the initial matches between teams

        for(int i = 0; totalTeams > i; i = i + 2){ //algorithm to create the matches(team vs team). functioning/tested.
            matchList.add(new IndividualMatch(randomTeamList.get(i), randomTeamList.get(i+1)));
        }

        for(int i = 0; totalMatches > i; i++){ //algorithm to create the matches(team vs team). functioning/tested.
            matchList.get(i).setMatchNumber(i+1);
        }

    }

    public static void furtherMatchCreation(){
        matchList.clear();
        randomTeamList.clear();
        int newTotalTeams = winningTeams.size();

        if(newTotalTeams!=1){
            totalMatches = newTotalTeams/2;
        }
        else{
            totalMatches = 1;
        }

        for(int i = 0; newTotalTeams > i; i++){
            randomTeamList.add(winningTeams.get(i));
        }

        if(teamSittingOutCheck==1){
            randomTeamList.add(sittingOutTeam);
            teamSittingOutCheck = 0;
        }

        if((randomTeamList.size()%2)==1){
            sittingOutTeam = randomTeamList.get((randomTeamList.size()-1));
            randomTeamList.remove((randomTeamList.size()-1));
            newTotalTeams = newTotalTeams - 1;
            teamSittingOutCheck = 1;
        }

        for(int i = 0; newTotalTeams  > i; i = i + 2){ //algorithm to create the matches(team vs team). functioning/tested.
            matchList.add(new IndividualMatch(randomTeamList.get(i), randomTeamList.get(i+1)));
        }

        for(int i = 0; totalMatches  > i; i++){ //algorithm that sets match numbers to each match.
            matchList.get(i).setMatchNumber(i+1);
        }

        winningTeams.clear(); //clears out everything in the winning teams array to be used with the next winners
    }

    public static void displayCurrentMatches(){ //algorithm to print off team matches. functioning/tested.
        if((matchList.size()==1)&&teamSittingOutCheck==0){
                System.out.println("__________FINAL Round:__________");
            }
            else {
            System.out.println("_______________________________________________________________________");
                System.out.println("\n__________Round " + numberOfRounds + ":__________");
            }

            for (int i = 0; totalMatches > i; i++) {

                System.out.println("Match " + (i + 1) + ": Team " + matchList.get(i).getTeamOne().getTeamNumber() + " vs Team "
                        + matchList.get(i).getTeamTwo().getTeamNumber());
            }

            if(teamSittingOutCheck==1){
                System.out.println("\n***Team "+sittingOutTeam.getTeamNumber()+" is sitting out this round***");
            }
            numberOfRounds++;

    }

    public static void updateMatchesWithWinners(){
        //how can I make it so the user is only able to select the number of matches that are available?
        Scanner input = new Scanner(System.in);
        int matchToUpdate = 0;
        int scoreTeam1 = 0;
        int scoreTeam2 = 0;
        int updateCounter = 0;

        System.out.println("\nYou're about to assign team winners for each of the matches.");

        while(updateCounter < totalMatches) {
            System.out.println("\nType out the match number for which teams to update: ");
            matchToUpdate = Integer.parseInt(input.nextLine());
            matchToUpdate = matchToUpdate - 1; //indexed on 0

            if (0 <= matchToUpdate && matchToUpdate < totalMatches) {
                //which team won?
                //display the team match up before they enter in the details of who won
                //how can I set who wins the match?
                System.out.println("What is the score for Team " + matchList.get(matchToUpdate).getTeamOne().getTeamNumber() + "?: ");
                scoreTeam1 = Integer.parseInt((input.nextLine()));
                System.out.println("What is the score for Team " + matchList.get(matchToUpdate).getTeamTwo().getTeamNumber() + "?: ");
                scoreTeam2 = Integer.parseInt((input.nextLine()));
                System.out.println("Setting scores for teams...");
                matchList.get(matchToUpdate).getTeamOne().setFinalScore(scoreTeam1);
                matchList.get(matchToUpdate).getTeamOne().setFinalScore(scoreTeam2);

                if(scoreTeam1 > scoreTeam2){
                    matchList.get(matchToUpdate).setWinningTeam(matchList.get(matchToUpdate).getTeamOne().getTeamNumber());
                    matchList.get(matchToUpdate).setWinningScore(scoreTeam1);
                    winningTeams.add(matchList.get(matchToUpdate).getTeamOne());
                }

                if(scoreTeam2 > scoreTeam1){
                    matchList.get(matchToUpdate).setWinningTeam(matchList.get(matchToUpdate).getTeamTwo().getTeamNumber());
                    matchList.get(matchToUpdate).setWinningScore(scoreTeam2);
                    winningTeams.add(matchList.get(matchToUpdate).getTeamTwo());
                }
                updateCounter++;
            }
        }
        //System.out.println("winning teams size"+winningTeams.size());
        loopCounter++;
    }

    public static void displayTotalMatchInfo() {
        System.out.println("\n***Match Information with Team Winners***");

        if((matchList.size()==1)&&teamSittingOutCheck==0){
            System.out.println("TEAM "+matchList.get(0).getWinningTeam()+" is the WINNER of the Tennis Tournament!");
        }
        else {
            for (int i = 0; totalMatches > i; i++) {
                System.out.println("Match " + matchList.get(i).getMatchNumber() + ": Team "
                        + matchList.get(i).getTeamOne().getTeamNumber() + " vs Team " + matchList.get(i).getTeamTwo().getTeamNumber() +
                        ".\n\t Winner is Team " + matchList.get(i).getWinningTeam() + ", with a score of: " + matchList.get(i).getWinningScore() + "\n");
            }

            if (teamSittingOutCheck == 1) {
                System.out.println("The team that sat out this round was: Team " + sittingOutTeam.getTeamNumber() + "\n");
            }
        }
    }

}
