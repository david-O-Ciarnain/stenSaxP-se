package se.studiegrupp7.listaHighscore;

import java.io.Serializable;

public class PlayerStat implements Serializable {

    private final String playerName;
    private int winCount = 0;
    private int loseCount = 0;
    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    private Place place;

    public PlayerStat(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public int getFirst() {
        return first;
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

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "PlayerStat{" +
                "playerName='" + playerName + '\'' +
                ", winCount=" + winCount +
                ", loseCount=" + loseCount +
                ", first=" + first +
                ", second=" + second +
                ", third=" + third +
                ", fourth=" + fourth +
                '}';
    }

    void countWin() {
        int count = this.winCount;
        count++;
        this.winCount = count;
    }

    void countLose() {
        int count = this.loseCount;
        count++;
        this.loseCount = count;
    }

    void countFirst() {
        int count = this.first;
        count++;
        this.first = count;
    }

    void countSecond() {
        int count = this.second;
        count++;
        this.second = count;
    }

    void countThird() {
        int count = this.third;
        count++;
        this.third = count;
    }

    void countFourth() {
        int count = this.fourth;
        count++;
        this.fourth = count;
    }

}

enum Place {
    FIRST, SECOND, THIRD, FOURTH
}



