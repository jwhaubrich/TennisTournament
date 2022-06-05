package joeco.utils;

import joeco.tournament_objects.SingleMatch;
import joeco.tournament_objects.SingleTeam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedVariables {
    public static SingleTeam sittingOutTeam;
    public static boolean teamSittingOutCheck = false;
    public static ArrayList<SingleMatch> gListOfMatches = new ArrayList<>();
    public static final List<String> GENDER_LIST = Arrays.asList("1", "2", "MIXED GENDER");

    private SharedVariables() {
    }
}
