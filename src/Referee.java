import java.util.ArrayList;

public class Referee {

    /*
    Notes:
    Program is breaking because the index gets off track

    Questions:
    - I'm using a list of numbers and removing those numbers from the list. Will those numbers always relate
    back to the team numbers or is it possible for this to get offtrack somehow?
        - the arrayList scales dynamically...

     */

    public static void createMatches(int numberOfTeams) {
        System.out.println("**********Inside Referee**********");

        int teamCounter = numberOfTeams;
        int matchNumber = 1;
        int lowestNumber = 0;
        //signifies that there's at least one team, the arrayList indexes at 0
        int highestNumber = numberOfTeams - 1;
        //signifies that this many teams are left
        //has to be -1 because the arrays index at 0
        int randomTeamSelect, randomNum1, randomNum2, repeatRandSelect;

        ArrayList<Integer> teamsLeft = new ArrayList<>();

        /*for loop to create a list of numbers to select from when getting team objects to
        put into the match objects */
        for (int count = 0; highestNumber >= count; count++) {
            teamsLeft.add(count, count);
        }
        System.out.println("Size of teams list is after it's been created: ");
        System.out.println(teamsLeft); //see how big the list is

        //counts down teamCounter until there are no more teams left to make a match
        while (teamCounter != 0) {

            repeatRandSelect = 1; //identifier for if the two random number needs to be chosen again (they're the same)
            randomTeamSelect = (int) ((Math.random() * (teamsLeft.size() - lowestNumber)) + lowestNumber);
            randomNum1 = randomTeamSelect;

            randomTeamSelect = (int) ((Math.random() * (teamsLeft.size() - lowestNumber)) + lowestNumber);

            while(repeatRandSelect == 1) { //this loop will run if the second random number needs to be selected again

                if (randomTeamSelect != randomNum1) {
                    randomNum2 = randomTeamSelect;

                    System.out.println("random number 1; ");
                    System.out.println(randomNum1);
                    System.out.println("random number 2");
                    System.out.println(randomNum2);

                    //adding teams to a bracket, adding teams to match object
                    TournamentBracket.tBracket.add(new Match(TeamsCreation.teamsList.get(randomNum1), TeamsCreation.teamsList.get(randomNum2), matchNumber));
                    matchNumber++;

                    System.out.println("Teams list before we remove the numbers: ");
                    System.out.println(teamsLeft);

                    //the below if and else if are for removing the biggest number first to avoid out of bounce exceptions
                    if(randomNum1 > randomNum2){
                        teamsLeft.remove(randomNum1);
                        teamsLeft.remove(randomNum2);
                    }
                    else if(randomNum2 > randomNum1){
                        teamsLeft.remove(randomNum2);
                        teamsLeft.remove(randomNum1);
                    }

                    System.out.println("Teams list after we remove the two numbers: ");
                    System.out.println(teamsLeft);

                    //once this if has run successfully, sets the repeat identifier to 0 to break out of while loop
                    repeatRandSelect= 0;
                    teamCounter = teamCounter - 2;
                } else {
                    //the randomTeamSelect number is found again, because it was the same as the first random number
                    randomTeamSelect = (int) ((Math.random() * (teamsLeft.size() - lowestNumber)) + lowestNumber);
                }
            }
        }

    }
}

