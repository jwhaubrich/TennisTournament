import java.util.Scanner;

public class TournamentConfigs {
    private static int totalNumberOfTeams;
    private static int totalPlayersOnTeam = 0;
    static Scanner input = new Scanner(System.in);


    public static void setNumberOfTeams(){
        //int totalNumberOfTeams = 0;

        int totalTeamCheck = 0;

        while(totalTeamCheck != 1 || totalNumberOfTeams == 0) {
            System.out.println("How many teams are playing? (Enter even number): ");

            try {
                totalNumberOfTeams = Integer.parseInt((input.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("Not a number!\n");
            }

            if (totalNumberOfTeams % 2 == 0) {
                totalTeamCheck = 1;
            } else {
                System.out.println("***Warning***: Please enter an even number.\n");
                totalNumberOfTeams = 0;
            }
        }
    }

    public static void setNumberOfPlayersOnTeam(){
        System.out.println("Will this tournament be for 2 or 4 player teams?: ");

        if (input.hasNextInt()) {
                totalPlayersOnTeam = Integer.parseInt(input.nextLine());
            } else {
                System.out.println("Not a number.");
            }
        }

    public static int getTotalPlayersOnTeam(){
        return totalPlayersOnTeam;
    }

    public static int getNumberOfTeams(){
        return totalNumberOfTeams;
    }

}
