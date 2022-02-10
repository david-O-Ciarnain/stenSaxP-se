package se.studiegrupp7.listaHighscore;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class listaTesting {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        // String name = scanner.nextLine();


        List<PlayerStat> playerStatList = new ArrayList<>();

        PlayerStat player = new PlayerStat("Sven");
        PlayerStat date = new PlayerStat("Date");
        PlayerStat random = new PlayerStat("Random");
        PlayerStat vowels = new PlayerStat("vowels");

        player.countSecond();
        player.countThird();
        player.countFourth();
        player.countWin();
        player.countWin();


        date.countFourth();
        random.countFourth();
        vowels.countThird();

      List<Integer> bestPlace = player.getPlaceList().stream().sorted(Comparator.comparing(Integer::intValue)).distinct().min(Integer::compareTo).stream().collect(Collectors.toList());
      List<Integer>worstPlace = player.getPlaceList().stream().sorted(Comparator.comparing(Integer::intValue)).distinct().max(Integer::compareTo).stream().collect(Collectors.toList());


        playerStatList.add(player);
        playerStatList.add(date);
        playerStatList.add(random);
        playerStatList.add(vowels);





      /*  playerStatList.stream().min(Comparator.comparingInt(PlayerStat::getWinCount)
                        .thenComparingInt(PlayerStat::getSecond)
                        .thenComparingInt(PlayerStat::getThird)
                        .thenComparingInt(PlayerStat::getFourth))
                .ifPresent(System.out::println);*/

        System.out.println("Witch player do you want to se stats on?");
        String statInput = scanner.nextLine();


        if (playerStatList.stream().anyMatch(playerStat -> playerStat.getPlayerName().equals(statInput))) {

            List<PlayerStat> test = playerStatList.stream().filter(playerStat -> playerStat.getPlayerName().equals(statInput))
                    .collect(Collectors.toList());

        }


    }

}
