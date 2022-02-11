package se.studiegrupp7.gameplay;

import java.util.Random;

public class RandomBot implements Behaviors {

    // Detta är ett behavior till vårt pattern //

    @Override
    public String chooseBehavior(String oppoName) {

        Random valueRandomBot = new Random();
        int number = valueRandomBot.nextInt(3) + 1;
        String move;

        switch (number) {
            case 1 -> {
                move = "Rock";
                return move.toLowerCase();
            }
            case 2 -> {
                move = "Paper";
                return move.toLowerCase();
            }
            default -> {
                move = "Scissor";
                return move.toLowerCase();
            }
        }
    }
}
