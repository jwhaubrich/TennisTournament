import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Match {
    /*
    - should I store the actual team objects inside of the match ArrayList?
     */

    private int finalScore;
    private int teamWinner;
    private int matchNumber = 1;

    public Match (int finalScore, int teamWinner, int matchNumber){
        this.finalScore = finalScore;
        this.teamWinner = teamWinner;
        this.matchNumber = matchNumber;
    }

}
