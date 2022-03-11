import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class IndividualTeam {
    private int teamNumber;
    private int numberOfIndividuals;
    private int numberOfMales;
    private int numberOfFemales;

    public IndividualTeam(int newTeamNumber){
        this.teamNumber = newTeamNumber;
    }

}
