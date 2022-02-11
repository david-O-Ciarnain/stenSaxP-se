package se.studiegrupp7.menuer;

import se.studiegrupp7.listaHighscore.PlayerStat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreMenu implements Menu {
    Scanner scanner = new Scanner(System.in);
    Menu menu = new StartMeny();
    List<List<String>> tournamentStats = new ArrayList<>();

    @Override
    public void display() {
        System.out.println("press 1 to players stat");
        System.out.println("press 2 for total stat");
        System.out.println("press 3 to back to start menu");
    }

    @Override
    public void chooses(int input, List<List<String>> tournamentStats) {
        Menu menuScore = new ScoreMenu();
        switch (input) {
            case 1 -> {
                System.out.println("player stat");
                for (List<String> list:tournamentStats) {
                    for (String s:list) {
                        System.out.println(s);
                    }
                }
                playerStats();
                System.out.println();
                menuScore.display();
                input = scanner.nextInt();
                menuScore.chooses(input, tournamentStats);
            }
            case 2 -> {
                System.out.println("total stat");
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
    public void playerStats() {
        /*Scanner scanner = new Scanner(System.in);

        System.out.println("Witch player do you want to se stats on?");
        String name = scanner.nextLine();*/


        var player = new PlayerStat("Sven");
        var date = new PlayerStat("Minute Man");
        var random = new PlayerStat("Random Randy");
        var vowels = new PlayerStat("Vowel Woman");




        /*player.countSecond();
        player.countThird();
        player.countFourth();
        player.countWin();
        player.countWin();



        date.countFourth();
        random.countFourth();
        vowels.countThird();*/

        /*if(Objects.equals(name,"Sven".toLowerCase())){
            bestPlace(player);
            worstPlace(player);
            averagePlace(player);
        }

        if(Objects.equals(name, "Minute Man".toLowerCase())){
            bestPlace(date);
            worstPlace(date);
            averagePlace(date);
        }
        if(Objects.equals(name,"Vowel Woman".toLowerCase())){
            bestPlace(random);
            worstPlace(random);
            averagePlace(random);
        }
        if(Objects.equals(name,"Random Randy".toLowerCase())){
            bestPlace(vowels);
            worstPlace(vowels);
            averagePlace(vowels);
        }*/
    }
}
