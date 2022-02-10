import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberCreator {
    //class will be used to identify two random numbers that will be the two teams to play each other
    //number of teams will be passed from Referee to this class to be used in create RandomNumber
    //those two numbers will be passed into referee to assign that number of team to play another team

    public static int createRandomTeamNumber(int numberOfTeams){
        int totalTeams = numberOfTeams; //cuz in randNum finder, top number not inclusive
        int lowestIndex = 0;
        int randomTeamSelect;

        Random randomNumber = new Random();

            randomTeamSelect = (ThreadLocalRandom.current().nextInt(lowestIndex,totalTeams)); //not inclusive with bound
            //System.out.println(randomTeamSelect);

            return randomTeamSelect;
    }
}
