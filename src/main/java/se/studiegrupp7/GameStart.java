package se.studiegrupp7;

import java.util.Locale;
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
            }
            case 3 -> {
                move = "Scissors";
                System.out.println("You chose 'Scissors'");
                System.out.println("You lose!");
                winCount--;
                System.out.println("Your score: " + winCount);
            }
        }
    }

    public static void playGame(String opponent1, String opponent2){
        Scanner scanner = new Scanner(System.in);
        boolean noWinner = true;
        while(true){
            System.out.println("Select your move: 1 [Rock], 2 [Paper] or 3 [Scissors]");
            String input = scanner.nextLine();
            input.toLowerCase();
            System.out.println("You chose " + input);
            if (opponent1.getMove() == opponent2.getMove()){
                noWinner = true;
            }
            switch (opponent1.getMove()){
                case "rock":
                    if (opponent2.getMove() == "scissors"){
                        System.out.println("You win!");
                        opponent1.score();
                        noWinner = false;
                    }
                    else{
                        System.out.println("You lose!");
                        opponent2.score();
                        noWinner = false;
                    }
                    break;
                case "paper":
                    if (opponent2.getMove() == "rock"){
                        System.out.println("You win!");
                        opponent1.score();
                        noWinner = false;
                    }
                    else{
                        System.out.println("You lose!");
                        opponent2.score();
                        noWinner = false;
                    }
                    break;
                case "scissors":
                    if (opponent2.getMove() == "paper"){
                        System.out.println("You win!");
                        opponent1.score();
                        noWinner = false;
                    }
                    else{
                        System.out.println("You lose!");
                        opponent2.score();
                        noWinner = false;
                    }
                    break;
            }

        }
    }
}
