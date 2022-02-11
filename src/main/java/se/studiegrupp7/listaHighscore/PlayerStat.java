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

    public void countWin() {

        placeList.add(winCount);
    }

    public void countSecond() {

        placeList.add(second);

    }

    public void countThird() {

        placeList.add(third);
    }

    public void countFourth() {
        placeList.add(fourth);
    }


    public static void bestPlace(PlayerStat stat) {

        stat.getPlaceList().stream().min(Integer::compareTo).ifPresent(x -> System.out.println(stat.getPlayerName() + " best place is: " + x));
    }

    public static void worstPlace(PlayerStat stat) {

        stat.getPlaceList().stream().max(Integer::compareTo).ifPresent(x -> System.out.println(stat.getPlayerName() + " worst place is: " + x));
    }

    public static void averagePlace(PlayerStat stat) {

        stat.getPlaceList().stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .ifPresent((i) -> {
                    if (i > 1 && i < 1.5)
                        System.out.println(stat.getPlayerName() + " Average Placering: " + "Etta");
                    else if (i > 1.51 && i < 2.5)
                        System.out.println(stat.getPlayerName() + " Average Placering: " + "Tvåa");
                    else if (i > 2.51 && i < 3.5)
                        System.out.println(stat.getPlayerName() + " Average Placering: " + "Trea");
                    else System.out.println(stat.getPlayerName() + " Average Placering: " + "Fyra");
                });
    }


}










