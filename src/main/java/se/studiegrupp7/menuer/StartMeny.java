package se.studiegrupp7.menuer;

import se.studiegrupp7.MatchMaker;
import se.studiegrupp7.TestBot;
import se.studiegrupp7.gameplay.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

                    List<CreateBot> participants = new ArrayList<>();
                    participants.add(new CreateBot(new Player(), "Player", 0));
                    participants.add(new CreateBot(new Datum(), "Minute Man", 0));
                    participants.add(new CreateBot(new Vokaler(), "Vowel Woman", 0));
                    participants.add(new CreateBot(new RandomBot(), "Random Randy", 0));
                    //participants.add(new TestBot("Frida", randomMove(), 0));

                    MatchMaker.startTournament(participants);
                    participants.forEach(System.out::println);

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

        private String randomMove() {
            Random random = new Random();
            int generated = random.nextInt(3);
            String randomMove = "";
            if (generated == 0) {
                randomMove = "rock";
            } else if (generated == 1) {
                randomMove = "scissor";
            } else {
                randomMove = "paper";
            }
            return randomMove;
        }
    }
