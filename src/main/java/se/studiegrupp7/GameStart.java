package se.studiegrupp7;

import java.util.Scanner;

public class GameStart implements Menu{
    Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        System.out.println("Select your move: 1 [Rock], 2 [Paper] or 3 [Scissors]");
    }


    @Override
    public void chooses(int input) {
        String move;
        int winCount = 0;
        switch (input) {
            case 1 -> {
                move = "Rock";
                System.out.println("You chose 'Rock'");
                System.out.println("It's a draw! Try again.");
                Menu game = new GameStart();
                game.display();
                input = scanner.nextInt();
                game.chooses(input);
            }
            case 2 -> {
                move = "Paper";
                System.out.println("You chose 'Paper'");
                System.out.println("You win!");
                winCount++;
                System.out.println("Your score: " + winCount);
                Menu game = new StartMeny();
                game.display();
                input = scanner.nextInt();
                game.chooses(input);
            }
            case 3 -> {
                move = "Scissors";
                System.out.println("You chose 'Scissors'");
                System.out.println("You lose!");
                winCount--;
                System.out.println("Your score: " + winCount);
                Menu game = new StartMeny();
                game.display();
                input = scanner.nextInt();
                game.chooses(input);
            }
        }
    }
}
