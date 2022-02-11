package se.studiegrupp7.gameplay;

import java.time.LocalTime;

public class Datum implements Behaviors {

    // Detta är ett behavior till vårt pattern //

    @Override
    public String chooseBehavior(String oppoName) {
        LocalTime localTime = LocalTime.now();
        String move;

        if (localTime.getMinute() <= 20) {
            move = "Rock";
            return move.toLowerCase();

        } else if ( localTime.getMinute() <= 40) {
            move = "Paper";
            return move.toLowerCase();

        } else  {
            move = "Scissor";
            return move.toLowerCase();
        }
    }
}
