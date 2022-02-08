import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Team {
    private int menCount; //number of men on the team
    private int womenCount; //number of women on the team
    private int playerCount; //total number of players on the team
    private int teamNumber; //unique team number

    //the below constructor is used to implement default values
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
