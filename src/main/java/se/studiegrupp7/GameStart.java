package se.studiegrupp7;

import java.util.Scanner;

public class GameStart implements Runnable {

    TestBot oppo1;
    TestBot oppo2;
    int numberOfDraws = 0;

    public GameStart(TestBot oppo1, TestBot oppo2) {
        this.oppo1 = oppo1;
        this.oppo2 = oppo2;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean noWinner = true;

        while (noWinner && numberOfDraws < 3) {
            if (oppo1.getName().equals("Player")) {
                System.out.println("Select your move: [Rock], [Paper] or [Scissors]");
                oppo1.setMove(scanner.nextLine().toLowerCase());
                System.out.println("You chose " + oppo1.getMove());
            }
            if (oppo1.getMove().equals("noMove") || oppo2.getMove().equals("noMove")) {
                break;
            }

            noWinner = simulateMatch();

            if (numberOfDraws == 3) {
                System.out.println("Three rounds of draw, no winner.\n" + oppo1.getName() + " gets 1 point.");
                oppo1.setScore(oppo1.getScore() + 1);
            }
        }
    }

    private boolean simulateMatch() {
        switch (oppo1.getMove()){
            case "rock":
                if (oppo2.getMove().equals("scissor")){
                    System.out.println(oppo1.getName() + " wins!");
                    oppo1.setScore(oppo1.getScore() + 1);
                    return false;
                } else if (oppo2.getMove().equals("paper")){
                    System.out.println(oppo2.getName() +  "wins!");
                    oppo2.setScore(oppo2.getScore() + 1);
                    return false;
                }
                break;
            case "paper":
                if (oppo2.getMove().equals("rock")){
                    System.out.println(oppo1.getName() + " wins!");
                    oppo1.setScore(oppo1.getScore() + 1);
                    return false;
                } else if (oppo2.getMove().equals("scissor")){
                    System.out.println(oppo2.getName() +  "wins!");
                    oppo2.setScore(oppo2.getScore() + 1);
                    return false;
                }
                break;
            case "scissor":
                if (oppo2.getMove().equals("paper")){
                    System.out.println(oppo1.getName() + " wins!");
                    oppo1.setScore(oppo1.getScore() + 1);
                    return false;
                } else if (oppo2.getMove().equals("rock")){
                    System.out.println(oppo2.getName() +  "wins!");
                    oppo2.setScore(oppo2.getScore() + 1);
                    return false;
                }
                break;
        }
        System.out.println("It's a draw");
        numberOfDraws++;
        return true;
    }
}
