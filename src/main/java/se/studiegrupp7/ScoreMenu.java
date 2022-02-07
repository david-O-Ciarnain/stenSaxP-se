package se.studiegrupp7;

public class ScoreMenu implements Menu {
    @Override
    public void display() {

            System.out.println("press 1 to player stat");
            System.out.println("press 2 for total stat");
            System.out.println("press 3 to back to start menu");


        }

    @Override
    public void chooses(int input) {
        switch (input) {
            case 1 -> System.out.println("player stat");
            case 2 -> System.out.println("total stat");
            case 3 -> System.out.println("to start menu");
        }
    }
}
