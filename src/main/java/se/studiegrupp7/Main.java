package se.studiegrupp7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Menu menu = new StartMeny();
        Menu menu1 = new ScoreMenu();
        menu.display();
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        menu.chooses(input);
        /*boolean menuRunning = true;
        while (true) {

            if (input == 1) {
                *//*menu.display();
                input = scanner.nextInt();
                scanner.nextLine();
                menu.chooses(input);*//*
            }
            if (input == 2) {
                *//*menu1.display();
                input = scanner.nextInt();
                scanner.nextLine();
                menu1.chooses(input);*//*
            }*/
        }
    }

