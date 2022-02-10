package se.studiegrupp7.listaHighscore;


import se.studiegrupp7.Menu;

import java.util.*;



public class listaTesting  {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.nextLine();


        PlayerStat player = new PlayerStat(name);
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


        System.out.println("""
                Witch player do you wanna check stat on?\s
                press 1 for player stat\s
                press 2 for Date bot stat\s
                press 3 for Random bot stat\s
                press 4 for vowels bot stat\s
                press 5 for go back to start menu""");

        int input = scanner.nextInt();
        switch (input) {
            case 1 -> {
                bestPlace(player);
                worstPlace(player);
                averagePlace(player);
            }
            case 2 -> {
                bestPlace(date);
                worstPlace(date);
                averagePlace(date);
            }
            case 3 -> {
                bestPlace(random);
                worstPlace(random);
                averagePlace(random);
            }
            case 4 -> {
                bestPlace(vowels);
                worstPlace(vowels);
                averagePlace(vowels);
            }
            case 5 -> {

            }
        }


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
