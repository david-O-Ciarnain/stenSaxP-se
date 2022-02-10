package se.studiegrupp7.gameplay;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class Vokaler implements Behaviors {



    @Override
    public String chooseBehavior() {
        String move;
        CreateBot opponent = null;
        Pattern pattern = Pattern.compile("[aeiouy]");
        Matcher matcher = pattern.matcher(opponent.getName().toLowerCase());
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        System.out.println("Occurences found: " + counter);


        switch (counter) {
            case 0:
                move = "Rock";
                return move.toLowerCase();

            case 1:
                move = "Paper";
                return move.toLowerCase();

            default:
                move = "Scissor";
                return move.toLowerCase();
        }
    }
}
