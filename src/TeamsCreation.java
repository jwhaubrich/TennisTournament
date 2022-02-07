import java.util.ArrayList;
import java.util.Scanner;


public class TeamsCreation {

    public static void createTeams(int numberOfTeams){
        ArrayList[] teamsList = new ArrayList<>(); //create list of all possible teams
        Scanner input = new Scanner(System.in);
        int numberOfMen;
        int numberOfWomen;

        for(int t = 1; numberOfTeams > t ; t++ ){
            System.out.println("For team " + t + " how many men and women?");
            System.out.println("Number of men?: ");
            try{
                numberOfMen = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                System.out.println("Exception");
            }
            System.out.println("Number of men?: ");
            try{
                numberOfWomen = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                System.out.println("Exception");
            }



        }
    }
}
