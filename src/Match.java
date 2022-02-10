import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//match constructor
public class Match {

    private int finalScore;
    private int teamWinner;
    private int matchNumber;
    private Team myTeam1;
    private Team myTeam2;

    public Match (int finalScore, int teamWinner){
        this.finalScore = finalScore;
        this.teamWinner = teamWinner;
    }

    public Match (Team myTeam1, Team myTeam2, int matchNumber){
        this.myTeam1 = myTeam1;
        this.myTeam2 = myTeam2;
        this.matchNumber = matchNumber;
    }

}
