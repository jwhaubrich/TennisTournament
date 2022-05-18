package tournament_objects;

public class IndividualTeam {
    private int teamNumber;
    private int numberOfIndividuals;
    private int numberOfMales;
    private int numberOfFemales;
    private int finalScore;

    public IndividualTeam(int newTeamNumber){
        this.teamNumber = newTeamNumber;
    }

    public int getTeamNumber() {
        return this.teamNumber;
    }

    public int getNumberOfIndividuals() {
        return this.numberOfIndividuals;
    }

    public int getNumberOfMales() {
        return this.numberOfMales;
    }

    public int getNumberOfFemales() {
        return this.numberOfFemales;
    }

    public int getFinalScore() {
        return this.finalScore;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public void setNumberOfIndividuals(int numberOfIndividuals) {
        this.numberOfIndividuals = numberOfIndividuals;
    }

    public void setNumberOfMales(int numberOfMales) {
        this.numberOfMales = numberOfMales;
    }

    public void setNumberOfFemales(int numberOfFemales) {
        this.numberOfFemales = numberOfFemales;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }
}
