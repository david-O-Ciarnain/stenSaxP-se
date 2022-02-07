package se.studiegrupp7;

public class StartMeny implements Menu{

    @Override
    public void display() {
        System.out.println("press 1 to play game");
        System.out.println("press 2 for highScore");
        System.out.println("press 3 to Exit");
    }

    @Override
    public void chooses(int input) {
        switch (input) {
            case 1 -> System.out.println("game is playing");
            case 2 -> System.out.println("this is your highScore");
            case 3 -> System.out.println("you have exit the game ");
        }

    }
}
