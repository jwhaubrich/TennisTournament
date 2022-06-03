package joeco.tournament_exe;

import joeco.context_displays.InfoContextDisplay;
import joeco.tournament_configurations.MatchBuilder;
import joeco.tournament_configurations.TeamBuilder;
import joeco.tournament_configurations.TeamUpdater;
import joeco.tournament_organizer.Referee;

import static joeco.utils.SharedVariables.teamSittingOutCheck;

public class TournamentInitializer {
    public static int gMatchCountDown;
    public static int gMatchesPlayed = 0;
    
    public static void main(String[] args) {
        initializeTennisTournament();
    }
    
    public static void initializeTennisTournament(){

            TeamBuilder.setNumberOfTeams();
            gMatchCountDown = TeamBuilder.getNumberOfTeams()/2;
            TeamBuilder.setTotalPlayersOnTeam();
            TeamBuilder.createInitialTeamList();
            TeamUpdater.addInfoToTeams();
            Referee.randomizeTeamsList(TeamBuilder.getTeamList());
            Referee.createInitialMatches();
            TournamentInitializer.playTournament();
    }

    private static void playTournament(){

            while (gMatchesPlayed < TeamBuilder.getTotalMatchesToPlay() - 1) {

                if(((gMatchCountDown== 0)||(gMatchCountDown==1)) && (!teamSittingOutCheck)){
                    InfoContextDisplay.displayPreMatchInformation();
                    Referee.updateMatchWithTeamScores();
                    InfoContextDisplay.displayTeamWinnerInformation();
                    ReplayTrnChecker.checkIfToRestartTournament();
                }
                InfoContextDisplay.displayPreMatchInformation();
                Referee.updateMatchWithTeamScores();
                InfoContextDisplay.displayTeamWinnerInformation();
                MatchBuilder.createNextTeamMatch();
            }
        InfoContextDisplay.displayPreMatchInformation();
        Referee.updateMatchWithTeamScores();
        InfoContextDisplay.displayTeamWinnerInformation();
        ReplayTrnChecker.checkIfToRestartTournament();

    }
}
