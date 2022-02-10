package se.studiegrupp7.listaHighscore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PlayerStat implements Serializable {

    private final String playerName;
    private final int winCount = 1;
    private final int second = 2;
    private final int third = 3;
    private final int fourth = 4;
    List<Integer> placeList = new ArrayList<>();


    public PlayerStat(String playerName) {

        this.playerName = playerName;
    }

    public String getPlayerName() {

        return playerName;
    }

    public List<Integer> getPlaceList() {
        return placeList;
    }

    @Override
    public String toString() {
        return "PlayerStat{" +
                "playerName=' " + playerName + '\'' +
                ", winCount= " + winCount +
                ", second= " + second +
                ", third= " + third +
                ", fourth= " + fourth +
                '}';
    }

    void countWin() {

        placeList.add(winCount);
    }

    void countSecond() {

        placeList.add(second);

    }

    void countThird() {

        placeList.add(third);
    }

    void countFourth() {
        placeList.add(fourth);
    }


}










