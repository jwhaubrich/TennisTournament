package joeco.tournament_objects;

public class SingleMatch {
    private SingleTeam teamOne;
    private SingleTeam teamTwo;
    private int winningTeam;
    private int winningScore;
    private int matchNumber;

    public SingleMatch(SingleTeam newTeamOne, SingleTeam newTeamTwo){
        this.teamOne = newTeamOne;
        this.teamTwo = newTeamTwo;
    }

    public SingleTeam getTeamOne() {
        return this.teamOne;
    }

    public SingleTeam getTeamTwo() {
        return this.teamTwo;
    }

    public int getWinningTeam() {
        return this.winningTeam;
    }

    public int getWinningScore() {
        return this.winningScore;
    }

    public int getMatchNumber() {
        return this.matchNumber;
    }

    public void setWinningTeam(int winningTeam) {
        this.winningTeam = winningTeam;
    }

    public void setWinningScore(int winningScore) {
        this.winningScore = winningScore;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }
}
