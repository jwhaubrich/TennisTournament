import java.util.ArrayList;

public class Referee {


    public static void createMatches(int totalNumberOfTeams) {
        /*
        Create Arraylist of how many teams are available to play
            - list will be used to randomly select teams to play against each other
        Find random number between 0 and ArrayList.size - 1, because index on 0
        Pass those random numbers to MatchStoring to create a match object between two different teams
        Remove those two random numbers from the ArrayList, because we don't want to select the same team twice
         */

        ArrayList<Integer> teamsLeft = new ArrayList<>();
        int teamCounter = totalNumberOfTeams; //sets teamCounter to totalNumber of teams
        int teamCounterIndex = totalNumberOfTeams - 1;
        int randomTeamSelect, randomNum1, randomNum2, repeatRandSelect;

        /*for loop to create a list of numbers to select from when getting team objects to
        put into the match objects */
        for (int count = 0; totalNumberOfTeams > count; count++) {
            teamsLeft.add(count, count);
        }
        System.out.println("teams left array after creation: ");
        System.out.println(teamsLeft.size());

        //counts down teamCounter until there are no more teams left to make a match
        //there's a BUG in this code that is setting teams to play more than once
        while (teamCounter != 0) {
            repeatRandSelect = 1; //identifier for if the two random number needs to be chosen again (they're the same)
            //randomTeamSelect = (int) ((Math.random() * ((teamsLeft.size()) - lowestNumber)) + lowestNumber);

            randomTeamSelect = RandomNumberCreator.createRandomTeamNumber(totalNumberOfTeams);
            System.out.println("random team select");
            System.out.println(randomTeamSelect);
            randomNum1 = randomTeamSelect;
            System.out.println("random 1");
            System.out.println(randomNum1);

            randomTeamSelect = RandomNumberCreator.createRandomTeamNumber(totalNumberOfTeams);
            System.out.println("random team select");
            System.out.println(randomTeamSelect);


            while(repeatRandSelect == 1) { //this loop will run regardless because the repeatRandSelect is checked 1 above

                if (randomTeamSelect != randomNum1) { //if will run only if the first random num and second are not equal
                    MatchStoring.totalMatches(teamCounterIndex);
                    randomNum2 = randomTeamSelect;

                    System.out.println("Random num2: ");
                    System.out.println(randomNum2);

                    //Create individual matches between teams
                    MatchStoring.createMatches(randomNum1, randomNum2);
                    System.out.println("Created match\n");
                    //the below if and else if are for removing the biggest number first to avoid out of bounce exceptions

                    //SOMETHING KEEPS HAPPENING WITH THIS IF AND ELSE IF LOOP.
                    //IT CAN'T FIND THE TEAM WITHIN TEAMSLEFT WITH THE .GET FUNCTION
                    //THE LAST REMOVAL SHOULD REMOVE 0 AND 1
                    if(randomNum1 > randomNum2){
                        System.out.println("printing out teamsLeft information");
                        System.out.println(teamsLeft.size());
                        System.out.println(teamsLeft.get(randomNum1));
                        System.out.println(teamsLeft.get(randomNum2));
                        //remove the index of where that particular number is located
                        teamsLeft.remove(teamsLeft.remove(teamsLeft));
                        teamsLeft.remove(randomNum2);
                    }
                    else if(randomNum2 > randomNum1){
                        System.out.println("printing out teamsLeft information");
                        System.out.println(teamsLeft.size());
                        System.out.println(teamsLeft.get(randomNum1));
                        System.out.println(teamsLeft.get(randomNum2));
                        teamsLeft.remove(randomNum2);
                        teamsLeft.remove(randomNum1);
                    }

                    System.out.println("after teams are removed");
                    System.out.println(teamsLeft.size());

                    System.out.println("***starting the process over again***\n\n");

                    //once this if has run successfully, sets the repeat identifier to 0 to break out of while loop
                    repeatRandSelect= 0;


                } else {
                    //the randomTeamSelect number is found again, because it was the same as the first random number
                    randomTeamSelect = RandomNumberCreator.createRandomTeamNumber(totalNumberOfTeams);;
                }
            }
        }
        teamCounter = teamCounter - 2; //subtract 2 from teamCounter, because 2 teams are needed for each match
    }
}