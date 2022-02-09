package se.studiegrupp7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatchMaker {


    // String opponent, may be changed to our "player" class
    public static void startTournament(List<TestBot> participants) {
        Scanner scanner = new Scanner(System.in);
        int input;

        if (participants.size() % 2 != 0) {
            participants.add(new TestBot("", "", 0)); // If odd number of opponents add a dummy opponent
            /* OBS - DUMMY BOTEN MÅSTE TAS BORT FRÅN STATISK OCH MATCHER! */
        }

        List<TestBot> opponents = new ArrayList<>(participants); // Add opponents to List
        opponents.remove(0); // Remove "player" from list
        TestBot player = participants.get(0); // Set player as a variable1

        int opponentsSize = opponents.size(); // Our actual opponents list size.
        int numRounds = (participants.size() - 1); // Rounds needed to complete tournament, number of player+bots - 1.
        int halfSize = participants.size() / 2;

        for (int round = 0; round < numRounds; round++) { // Start rounds
            int whichOpponent = round % opponentsSize; // sets our opponent for player.

            System.out.println(opponents.get(whichOpponent).getName() + " vs " + player.getName()); // Prints who is facing player.
            Thread thread1 = new Thread(new GameStart(player, opponents.get(whichOpponent))); // Play(Simulate) the match, in thread 1
            thread1.start();
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int idx = 1; idx < halfSize; idx++) {
                int firstTeam = (round + idx) % opponentsSize;
                int secondTeam = (round  + opponentsSize - idx) % opponentsSize;
                System.out.println(opponents.get(firstTeam).getName() + " vs " + opponents.get(secondTeam).getName());
                Thread thread2 = new Thread(new GameStart(opponents.get(firstTeam), opponents.get(secondTeam))); // In thread 2
                thread2.start();
                try {
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
