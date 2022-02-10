package se.studiegrupp7;

import se.studiegrupp7.gameplay.CreateBot;

public class GameStart implements Runnable {

    CreateBot oppo1;
    CreateBot oppo2;
    int numberOfDraws = 0;

    public GameStart(CreateBot oppo1, CreateBot oppo2) {
        this.oppo1 = oppo1;
        this.oppo2 = oppo2;
    }

    @Override
    public void run() {

        boolean noWinner = true;

        while (noWinner && numberOfDraws < 3) {
            /*if (oppo1.getMove().equals("noMove") || oppo2.getMove().equals("noMove")) {
                break;
            }*/

            noWinner = simulateMatch();

            if (numberOfDraws == 3) {
                System.out.println("Three rounds of draw, no winner.\n" + oppo1.getName() + " gets 1 point.");
                //oppo1.setScore(oppo1.getScore() + 1);
            }
        }
    }

    private boolean simulateMatch() {
        switch (oppo1.executeBehaviors()){
            case "rock":
                if (oppo2.executeBehaviors().equals("scissor")){
                    System.out.println(oppo1.getName() + " wins!");
                    //oppo1.setScore(oppo1.getScore() + 1);
                    return false;
                } else if (oppo2.executeBehaviors().equals("paper")){
                    System.out.println(oppo2.getName() +  "wins!");
                    //oppo2.setScore(oppo2.getScore() + 1);
                    return false;
                }
                break;
            case "paper":
                if (oppo2.executeBehaviors().equals("rock")){
                    System.out.println(oppo1.getName() + " wins!");
                    //oppo1.setScore(oppo1.getScore() + 1);
                    return false;
                } else if (oppo2.executeBehaviors().equals("scissor")){
                    System.out.println(oppo2.getName() +  "wins!");
                    //oppo2.setScore(oppo2.getScore() + 1);
                    return false;
                }
                break;
            case "scissor":
                if (oppo2.executeBehaviors().equals("paper")){
                    System.out.println(oppo1.getName() + " wins!");
                    //oppo1.setScore(oppo1.getScore() + 1);
                    return false;
                } else if (oppo2.executeBehaviors().equals("rock")){
                    System.out.println(oppo2.getName() +  "wins!");
                    //oppo2.setScore(oppo2.getScore() + 1);
                    return false;
                }
                break;
        }
        System.out.println("It's a draw");
        numberOfDraws++;
        return true;
    }
}
