package se.studiegrupp7.menuer;


import se.studiegrupp7.listaHighscore.PlayerStat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ScoreMenu implements Menu {
    Scanner scanner = new Scanner(System.in);
    Menu menu = new StartMeny();


    @Override
    public void display() {
        System.out.println("press 1 for player stats");
        System.out.println("press 2 for previous tournaments");
        System.out.println("press 3 to go back to start menu");
    }

    @Override
    public void chooses(int input, List<List<String>> tournamentStats) {
        Menu menuScore = new ScoreMenu();
        switch (input) {
            case 1 -> {
                System.out.println("Player stats");
                playerStats(tournamentStats);
                System.out.println();
                menuScore.display();
                input = scanner.nextInt();
                menuScore.chooses(input, tournamentStats);
            }
            case 2 -> {
                System.out.println("Previous tournaments [First to Last]");
                for (List<String> list:tournamentStats) {
                    for (String s:list) {
                        System.out.print(s + ", ");
                    }
                    System.out.println();
                }
                System.out.println();
                menuScore.display();
                input = scanner.nextInt();
                menuScore.chooses(input, tournamentStats);
            }
            case 3 -> {
                menu.display();
                input = scanner.nextInt();
                menu.chooses(input, tournamentStats);
            }
        }
    }

    public void playerStats(List<List<String>> test) {


        String playerName = test.get(0).get(1);

       /* System.out.println("Witch player do you want to se stats on?");
        String name = scanner.nextLine();*/
        PlayerStat player = new PlayerStat("Player");
        PlayerStat minuteMan = new PlayerStat("Minute Man");
        PlayerStat randomRandy = new PlayerStat("Random Randy");
        PlayerStat vowelWoman = new PlayerStat("Vowel Woman");

        for (List<String> s : test) {

                if (Objects.equals(s.get(1), player.getPlayerName())) {
                    player.countWin();
                }
                if (Objects.equals(s.get(2), player.getPlayerName())) {
                    player.countSecond();
                }
                if (Objects.equals(s.get(3), player.getPlayerName())) {
                    player.countThird();
                }
                if (Objects.equals(s.get(4), player.getPlayerName())) {
                    player.countFourth();
                }

                //time Lord
                if (Objects.equals(s.get(1), minuteMan.getPlayerName())) {
                    minuteMan.countWin();

                }
                if (Objects.equals(s.get(2), minuteMan.getPlayerName())) {
                    minuteMan.countSecond();
                }
                if (Objects.equals(s.get(3), minuteMan.getPlayerName())) {
                    minuteMan.countThird();
                }
                if (Objects.equals(s.get(4), minuteMan.getPlayerName())) {
                    minuteMan.countFourth();
                }
                // mr random
                if (Objects.equals(s.get(1), randomRandy.getPlayerName())) {
                    randomRandy.countWin();
                }
                if (Objects.equals(s.get(2), randomRandy.getPlayerName())) {
                    randomRandy.countSecond();
                }
                if (Objects.equals(s.get(3), randomRandy.getPlayerName())) {
                    randomRandy.countThird();
                }
                if (Objects.equals(s.get(4), randomRandy.getPlayerName())) {
                    randomRandy.countFourth();
                }

                if (Objects.equals(s.get(1), vowelWoman.getPlayerName())) {
                    vowelWoman.countWin();


                }
                if (Objects.equals(s.get(2), vowelWoman.getPlayerName())) {
                    vowelWoman.countSecond();

                }
                if (Objects.equals(s.get(3), vowelWoman.getPlayerName())) {
                    vowelWoman.countThird();

                }
                if (Objects.equals(s.get(4), vowelWoman.getPlayerName())) {
                    vowelWoman.countFourth();

                }
            }

        bestPlace(player);
        worstPlace(player);
        averagePlace(player);
        System.out.println();
        bestPlace(minuteMan);
        worstPlace(minuteMan);
        averagePlace(minuteMan);
        System.out.println();
        bestPlace(randomRandy);
        worstPlace(randomRandy);
        averagePlace(randomRandy);
        System.out.println();
        bestPlace(vowelWoman);
        worstPlace(vowelWoman);
        averagePlace(vowelWoman);
        }

    public static void bestPlace(PlayerStat stat) {

        stat.getPlaceList().stream().min(Integer::compareTo).ifPresent(x -> System.out.print(stat.getPlayerName() + " best place is: " + x + ", "));
    }

    public static void worstPlace(PlayerStat stat) {

        stat.getPlaceList().stream().max(Integer::compareTo).ifPresent(x -> System.out.print(stat.getPlayerName() + " worst place is: " + x + ", "));
    }

    public static void averagePlace(PlayerStat stat) {

        stat.getPlaceList().stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .ifPresent((i) -> {
                    if (i > 0 && i < 1.5)
                        System.out.print(stat.getPlayerName() + "'s average placing: " + "First");
                    else if (i > 1.51 && i < 2.5)
                        System.out.print(stat.getPlayerName() + "'s average placing: " + "Second");
                    else if (i > 2.51 && i < 3.5)
                        System.out.print(stat.getPlayerName() + "'s average placing: " + "Third");
                    else System.out.print(stat.getPlayerName() + "'s average placing: " + "Fourth");
                });
    }
}
