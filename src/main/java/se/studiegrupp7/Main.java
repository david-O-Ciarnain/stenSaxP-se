package se.studiegrupp7;

import se.studiegrupp7.menuer.Menu;
import se.studiegrupp7.menuer.StartMeny;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu menu = new StartMeny();
        menu.display();
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        menu.chooses(input);
        }
    }



