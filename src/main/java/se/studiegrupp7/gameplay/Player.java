package se.studiegrupp7.gameplay;

import java.util.Scanner;

public class Player implements Behaviors{
    @Override
    public String chooseBehavior() {
        Scanner scanner = new Scanner(System.in);
        String move;
        System.out.println("Select your move: [Rock], [Paper] or [Scissors]");
        move = scanner.nextLine().toLowerCase();
        System.out.println("You chose " + move);
        return move;
        }
    }
