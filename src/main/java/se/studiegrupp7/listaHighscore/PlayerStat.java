package se.studiegrupp7.listaHighscore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PlayerStat implements Serializable {

    private final String playerName;
    private int winCount = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    List<Integer> placeList = new ArrayList<>();

    public PlayerStat(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getWinCount() {
        return winCount;
    }


    public List<Integer> getPlaceList() {
        return placeList;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getFourth() {
        return fourth;
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
        int count = this.winCount;
        count++;
        this.winCount = count;
        placeList.add(count);
    }

    void countSecond() {
        int count = this.second;
        count ++;
        this.second = count;
        placeList.add(count);
    }

    void countThird() {
        int count = this.third;
        count ++;
        this.third = count;
        placeList.add(count);
    }

    void countFourth() {
        int count = this.fourth;
        count ++;
        this.fourth = count;
        placeList.add(count);
    }


}





