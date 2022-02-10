package se.studiegrupp7.gameplay;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class Vokaler implements Behaviors {



    @Override
    public void chooseBehavior() {
        String name = "Vikash";
        Pattern pattern = Pattern.compile("[aeiouy]");
        Matcher matcher = pattern.matcher(name.toLowerCase());
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        System.out.println("Occurences found: " + counter);


        switch (counter) {
            case 0:
                System.out.println("Sten");

                break;

            case 1:
                System.out.println("Sax");
                break;

            default:
                System.out.println("Påse");
                break;


        }
    }
}
