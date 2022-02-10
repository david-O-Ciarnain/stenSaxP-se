package se.studiegrupp7.gameplay;
import java.util.Random;

 class Randomm implements Behaviors {
     @Override
     public void chooseBehavior() {

         Random valueRandom = new Random();
         int number = valueRandom.nextInt(3) + 1;

         switch (number) {
             case 1:
                 System.out.println();

                 break;

             case 2:
                 System.out.println();
                 break;

             case 3:
                 System.out.println();
                 break;


         }


     }
 }
