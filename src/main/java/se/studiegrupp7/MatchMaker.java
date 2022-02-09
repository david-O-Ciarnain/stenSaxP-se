package se.studiegrupp7;

import java.util.ArrayList;
import java.util.List;

public class MatchMaker {

    // String opponent, may be changed to our "player" class
    public static void startTournament(List<String> participants) {

        if (participants.size() % 2 != 0) {
            participants.add(""); // If odd number of opponents add a dummy opponent
            /* OBS - DUMMY BOTEN MÅSTE TAS BORT FRÅN STATISK OCH MATCHER! */
        }

        List<String> opponents = new ArrayList<>(participants); // Add opponents to List
        opponents.remove(0); // Remove "player" from list
        String player = participants.get(0); // Set player as a variable1

        int opponentsSize = opponents.size(); // Our actual opponents list size.
        int numRounds = (participants.size() - 1); // Rounds needed to complete tournament, number of player+bots - 1.
        int halfSize = participants.size() / 2;

        for (int round = 0; round < numRounds; round++) { // Start rounds
            int whichOpponent = round % opponentsSize; // sets our opponent for player.

            System.out.println(opponents.get(whichOpponent) + " vs " + player); // Prints who is facing player.
            // Thread thread1 = new playMatchPlayer(opponents.get(whichOpponent, player); // Play(Simulate) the match, in thread 1

            for (int idx = 1; idx < halfSize; idx++) {
                int firstTeam = (round + idx) % opponentsSize;
                int secondTeam = (round  + opponentsSize - idx) % opponentsSize;
                //System.out.println(opponents.get(firstTeam) + " vs " + opponents.get(secondTeam));
                // Thread thread2 = new playMatchBot(opponents.get(firstTeam), opponents.get(secondTeam); // In thread 2
            }
        }
    }
}
