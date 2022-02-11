package se.studiegrupp7.menuer;

import se.studiegrupp7.MatchMaker;
import java.util.List;
import java.util.Scanner;

public class StartMeny implements Menu {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        System.out.println("press 1 to play game");
        System.out.println("press 2 for highScore");
        System.out.println("press 3 to Exit");
    }

    @Override
    public void chooses(int input, List<List<String>> tournamentStats) {
            switch (input) {
                case 1 -> {
                    tournamentStats.add(MatchMaker.startTournament());
                    Menu menu = new StartMeny();
                    menu.display();
                    input = scanner.nextInt();
                    menu.chooses(input, tournamentStats);
                }
                case 2 -> {
                    Menu score = new ScoreMenu();
                    score.display();
                    input = scanner.nextInt();
                    score.chooses(input, tournamentStats);
                }
                case 3 -> {
                    System.out.println("you have exit the game ");
                    System.exit(0);
                }
            }
        }
    }
