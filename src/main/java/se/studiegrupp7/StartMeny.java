package se.studiegrupp7;

import java.util.ArrayList;
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
    public void chooses(int input) {
            switch (input) {
                case 1 -> {
                    List<String> participants = new ArrayList<>();
                    participants.add("Player1");
                    participants.add("Bot1");
                    participants.add("Bot2");
                    participants.add("Bot3");

                    MatchMaker.startTournament(participants);
                    Menu menu = new StartMeny();
                    menu.display();
                    input = scanner.nextInt();
                    menu.chooses(input);
                }
                case 2 -> {
                    Menu score = new ScoreMenu();
                    score.display();
                    input = scanner.nextInt();
                    score.chooses(input);
                }
                case 3 -> {
                    System.out.println("you have exit the game ");
                    System.exit(0);
                }
            }
        }
    }
