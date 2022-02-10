package se.studiegrupp7.gameplay;

import java.time.LocalTime;

public class Datum implements Behaviors {
    @Override
    public void chooseBehavior() {
        LocalTime localTime = LocalTime.now();

        switch (localTime.getMinute()) {

            case 1-19 :
                System.out.println();

                break;

            case 20-41:
                System.out.println();
                break;

            case 42-59:
                System.out.println();
                break;


        }



    }

}
