import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Team {
    private int menCount; //how many men are on the team
    private int womenCount; //how many women are on the team
    private int playerCount; //the total number of players
    private int teamNumber; //the team's specific number

    public Team(){
        this(0, 0, 0, 0);
    }

    public Team(int playerCount, int menCount, int womenCount, int teamNumber){
        this.playerCount = playerCount;
        this.menCount = menCount;
        this.womenCount = womenCount;
        this.teamNumber = teamNumber;
    }

}
