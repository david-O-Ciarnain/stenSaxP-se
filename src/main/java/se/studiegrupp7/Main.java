package se.studiegrupp7;

import java.awt.*;
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


    }



