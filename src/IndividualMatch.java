import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IndividualMatch {
    private IndividualTeam teamOne; //should these be private?
    private IndividualTeam teamTwo;
    private int winningTeam;
    private int winningScore;

    public IndividualMatch(IndividualTeam newTeamOne, IndividualTeam newTeamTwo){
        this.teamOne = newTeamOne;
        this.teamTwo = newTeamTwo;
    }

}
