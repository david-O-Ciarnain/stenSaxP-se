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
    private Place place;
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

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
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
       /* int count = this.winCount;
        count+=4;
        this.winCount = count;*/
        placeList.add(winCount);


    }

    void countSecond() {
     /*   int count = this.second;
        count +=3;
        this.second = count;*/
        placeList.add(second);

    }

    void countThird() {
       /* int count = this.third;
        count +=2;
        this.third = count;*/
        placeList.add(third);
    }

    void countFourth() {
       /* int count = this.fourth;
        count +=1;
        this.fourth = count;*/
        placeList.add(fourth);
    }


}
enum Place{
    FIRST(4),
    SECOND(3),
    THIRD(2),
    FOURTH(1);

    int number;

    Place(int number) {
        this.number = number;
    }



}





