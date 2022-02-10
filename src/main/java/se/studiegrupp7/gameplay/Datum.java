package se.studiegrupp7.gameplay;

import java.time.LocalTime;

public class Datum implements Behaviors {
    @Override
    public void chooseBehavior() {
        LocalTime localTime = LocalTime.now();

        if (localTime.getMinute() <= 20) {
            System.out.println("");

        } else if (localTime.getMinute() > 20 && localTime.getMinute() <= 40) {
            System.out.println("");

        } else  {
            System.out.println("");
        }

    }
}
