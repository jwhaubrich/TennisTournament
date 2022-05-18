package tournament_objects;

public class IndividualMatch {
    private IndividualTeam teamOne; //should these be private?
    private IndividualTeam teamTwo;
    private int winningTeam;
    private int winningScore;
    private int matchNumber;

    public IndividualMatch(IndividualTeam newTeamOne, IndividualTeam newTeamTwo){
        this.teamOne = newTeamOne;
        this.teamTwo = newTeamTwo;
    }

    public IndividualTeam getTeamOne() {
        return this.teamOne;
    }

    public IndividualTeam getTeamTwo() {
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

    public void setTeamOne(IndividualTeam teamOne) {
        this.teamOne = teamOne;
    }

    public void setTeamTwo(IndividualTeam teamTwo) {
        this.teamTwo = teamTwo;
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
