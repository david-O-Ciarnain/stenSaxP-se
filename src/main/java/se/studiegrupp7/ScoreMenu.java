package se.studiegrupp7;

import java.util.Scanner;

public class ScoreMenu implements Menu {
    Scanner scanner = new Scanner(System.in);
    Menu menu = new StartMeny();

    @Override
    public void display() {

        System.out.println("press 1 to player stat");
        System.out.println("press 2 for total stat");
        System.out.println("press 3 to back to start menu");


    }

    @Override
    public void chooses(int input) {
        Menu menu1 = new ScoreMenu();

        switch (input) {
            case 1 -> {
                System.out.println("player stat");
                menu1.display();
                input = scanner.nextInt();
                menu1.chooses(input);
            }
            case 2 -> {
                System.out.println("total stat");
                menu1.display();
                input = scanner.nextInt();
                menu1.chooses(input);
            }
            case 3 -> {
                menu.display();
                input = scanner.nextInt();
                menu.chooses(input);
            }



      /*  boolean menuRunning = true;
        while (menuRunning) {

            if (input == 1) {
                menuRunning = false;
            }
            if (input == 2) {
                menuRunning = false;

            }
            if (input == 3) {
                menu = new StartMeny();
                menu.display();
                input = scanner.nextInt();

                menu.chooses(input);
            }
        }*/
        }
    }
}
