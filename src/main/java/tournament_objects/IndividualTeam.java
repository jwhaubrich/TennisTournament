package tournament_objects;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class IndividualTeam {
    private int teamNumber;
    private int numberOfIndividuals;
    private int numberOfMales;
    private int numberOfFemales;
    private int finalScore;

    public IndividualTeam(int newTeamNumber){
        this.teamNumber = newTeamNumber;
    }

}