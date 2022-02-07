package se.studiegrupp7;

public class HighScore {

    public void ScoreMenu(int input) {
        switch (input) {
            case 1 -> System.out.println("View player stats");

            case 2 -> System.out.println("Total high score");

            case 3 -> System.out.println("Back to start menu");



        }
    }
    public void DisplayScoreMenu(){
        System.out.println("Press 1 to view player stats, Press 2 to view total high score, Press 3 to get back to the start menu");

    }
}