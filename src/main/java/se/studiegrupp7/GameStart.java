package se.studiegrupp7;

import java.util.Scanner;

public class GameStart implements Runnable {

    TestBot oppo1;
    TestBot oppo2;

    public GameStart(TestBot oppo1, TestBot oppo2) {
        this.oppo1 = oppo1;
        this.oppo2 = oppo2;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean noWinner = true;

        while(noWinner){
            if (oppo1.getName().equals("Player")) {
                System.out.println("Select your move: [Rock], [Paper] or [Scissors]");
                oppo1.setMove(scanner.nextLine().toLowerCase());
                System.out.println("You chose " + oppo1.getMove());
            }
            if (oppo1.getMove().equals("noMove") || oppo2.getMove().equals("noMove")) {
                break;
            }
            simulateMatch();

        }
    }

    private boolean simulateMatch() {
        switch (oppo1.getMove()){
            case "rock":
                if (oppo2.getMove().equals("scissor")){
                    System.out.println(oppo1.getName() + " wins!");
                    oppo1.setScore(oppo1.getScore() + 1);
                }
                return false;
            case "paper":
                if (oppo2.getMove().equals("rock")){
                    System.out.println(oppo1.getName() + " wins!");
                    oppo1.setScore(oppo1.getScore() + 1);
                }
                return false;
            case "scissor":
                if (oppo2.getMove().equals("paper")){
                    System.out.println(oppo1.getName() + " wins!");
                    oppo1.setScore(oppo1.getScore() + 1);
                }
                return false;
        }
        return true;
    }
}
