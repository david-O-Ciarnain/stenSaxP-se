package se.studiegrupp7.menuer;

import se.studiegrupp7.listaHighscore.PlayerStat;
import se.studiegrupp7.listaHighscore.TournamentStats;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static se.studiegrupp7.listaHighscore.PlayerStat.*;

public class ScoreMenu implements Menu, Serializable {
    Scanner scanner = new Scanner(System.in);
    Menu menu = new StartMeny();

    @Override
    public void display() {
        System.out.println("press 1 to players stat");
        System.out.println("press 2 for total stat");
        System.out.println("press 3 to back to start menu");
    }

    @Override
    public void chooses(int input) throws IOException {
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

    public void playerStats() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Witch player do you want to se stats on?");
        String name = scanner.nextLine();


        var player = new PlayerStat("Sven");
        var date = new PlayerStat("Minute Man");
        var random = new PlayerStat("Random Randy");
        var vowels = new PlayerStat("Vowel Woman");

        FileInputStream fileInputStream = new FileInputStream("./scoreListFile.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        TournamentStats tournamentStats = null;
        try {
            tournamentStats = (TournamentStats) objectInputStream.readObject();


            String player1 = tournamentStats.getName();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        objectInputStream.close();
        fileInputStream.close();


        List<TournamentStats> sortedList = List.of(Objects.requireNonNull(tournamentStats));
        sortedList.forEach(System.out::println);


        player.countSecond();
        player.countThird();
        player.countFourth();
        player.countWin();
        player.countWin();


        date.countFourth();
        random.countFourth();
        vowels.countThird();

        if (Objects.equals(name, "Sven".toLowerCase())) {
            bestPlace(player);
            worstPlace(player);
            averagePlace(player);
        }

        if (Objects.equals(name, "Minute Man".toLowerCase())) {
            bestPlace(date);
            worstPlace(date);
            averagePlace(date);
        }
        if (Objects.equals(name, "Vowel Woman".toLowerCase())) {
            bestPlace(random);
            worstPlace(random);
            averagePlace(random);
        }
        if (Objects.equals(name, "Random Randy".toLowerCase())) {
            bestPlace(vowels);
            worstPlace(vowels);
            averagePlace(vowels);
        }

    }

}
