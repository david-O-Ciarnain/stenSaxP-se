package se.studiegrupp7.gameplay;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vokaler implements Behaviors {

    @Override
    public String chooseBehavior(String oppoName) {
        String move;
        Pattern pattern = Pattern.compile("[aeiouyAEIOUY]");
        Matcher matcher = pattern.matcher(oppoName);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }

        switch (counter) {
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
