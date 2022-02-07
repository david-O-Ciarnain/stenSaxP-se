package se.studiegrupp7;

public class StartMenu {

    HighScore highScore = new HighScore();



    int input;

    public void startMenu(int input){
        switch (input){
            case 1:
                System.out.println("PLay game");
                break;





            case 2:
                highScore.DisplayScoreMenu();
                 break;

                case 3:
                    System.out.println("Exit game");
                    System.exit(0);
                    break;
            default:
                System.out.println("Please choose one to three");
                break;
        }


    }
    public void display(){
        System.out.println("Press 1 for Play game, Press 2 for high score, Press 3 for exit game");

    }




}
