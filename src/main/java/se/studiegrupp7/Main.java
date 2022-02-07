package se.studiegrupp7;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {



   StartMenu startMenu = new StartMenu();
        Scanner scanner = new Scanner(System.in);
        startMenu.display();
        int input = scanner.nextInt();
        startMenu.startMenu(input);




            HighScore highScore = new HighScore();
            Scanner scanner2 = new Scanner(System.in);
            highScore.DisplayScoreMenu();
            int input2 = scanner.nextInt();
           highScore.ScoreMenu(input2);


        }


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



