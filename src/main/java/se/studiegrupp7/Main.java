package se.studiegrupp7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Menu menu = new StartMeny();
        menu.display();
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        menu.chooses(input);
        boolean menuRunning = true;
        while (menuRunning) {

            if (input == 1) {

            }
            if (input == 2) {
                menu = new ScoreMenu();
                menu.display();
                input = scanner.nextInt();
                scanner.nextLine();
                menu.chooses(input);

            }
            if (input == 3) {
                menuRunning = false;
            }
        }
    }
}
