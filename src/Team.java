public class Team {
    private int menCount;
    private int womenCount;
    private int teamCount;
    private int teamNumber; //how can I have this integrated?

    public Team(){
        this(0, 0, 0);
    }

    public Team(int teamCount, int menCount, int womenCount){
        this.teamCount = teamCount;
        this.menCount = menCount;
        this.womenCount = womenCount;
    }
}
