package se.studiegrupp7;

import se.studiegrupp7.gameplay.Behaviors;
import se.studiegrupp7.gameplay.Vokaler;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Behaviors chooseBehavior = new Vokaler();
        chooseBehavior.chooseBehavior();






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
              Menu menu1 = new ScoreMenu();
                menu1.display();
                input = scanner.nextInt();
                scanner.nextLine();
                menu1.chooses(input);

            }
            if (input == 3) {
                menuRunning = false;
            }
        }


    }
}
