package se.studiegrupp7.gameplay;

import javax.lang.model.element.Name;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class Vokaler implements Behaviors{


    @Override
    public void chooseBehavior() {

        Pattern pattern1 = compile("([aeiouy]\\w*){1,}");
        Pattern pattern2 = compile("([aeiouy]\\w*){2,}");
        Pattern pattern3 = compile("([aeiouy]\\w*){3,}");

        Pattern pattern = Pattern.compile("([aeiouy]\\w*){2,}");
        Matcher matcher = pattern.matcher(Name.Usernam);


      ;   switch (Name.Username) {
            case pattern1 :
                System.out.println();

                break;

            case pattern2 :
                System.out.println();
                break;

            case pattern3 :
                System.out.println();
                break;


        }



    }
}
