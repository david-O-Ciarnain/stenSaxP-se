package se.studiegrupp7.menuer;

import se.studiegrupp7.listaHighscore.PlayerStat;

import java.util.Objects;
import java.util.Scanner;

import static se.studiegrupp7.listaHighscore.PlayerStat.*;

public class ScoreMenu implements Menu {
    Scanner scanner = new Scanner(System.in);
    Menu menu = new StartMeny();

    @Override
    public void display() {
        System.out.println("press 1 to players stat");
        System.out.println("press 2 for total stat");
        System.out.println("press 3 to back to start menu");
    }

    @Override
    public void chooses(int input) {
        Menu menuScore = new ScoreMenu();
        switch (input) {
            case 1 -> {
                System.out.println("player stat");
                playerStats();
                System.out.println();
                menuScore.display();
                input = scanner.nextInt();
                menuScore.chooses(input);
            }
            case 2 -> {
                System.out.println("total stat");
                menuScore.display();
                input = scanner.nextInt();
                menuScore.chooses(input);
            }
            case 3 -> {
                menu.display();
                input = scanner.nextInt();
                menu.chooses(input);
            }
        }
    }
    public void playerStats(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String userName = scanner.nextLine();
        System.out.println("Witch player do you want to se stats on?");
        String name = scanner.nextLine();


        var player = new PlayerStat(userName);
        var date = new PlayerStat("Date");
        var random = new PlayerStat("Random");
        var vowels = new PlayerStat("vowels");

        player.countSecond();
        player.countThird();
        player.countFourth();
        player.countWin();
        player.countWin();



        date.countFourth();
        random.countFourth();
        vowels.countThird();

        if(Objects.equals(name,userName.toLowerCase())){
            bestPlace(player);
            worstPlace(player);
            averagePlace(player);
        }

        if(Objects.equals(name, "Date".toLowerCase())){
            bestPlace(date);
            worstPlace(date);
            averagePlace(date);
        }
        if(Objects.equals(name,"Random".toLowerCase())){
            bestPlace(random);
            worstPlace(random);
            averagePlace(random);
        }
        if(Objects.equals(name,"vowels".toLowerCase())){
            bestPlace(vowels);
            worstPlace(vowels);
            averagePlace(vowels);
        }

    }

}
