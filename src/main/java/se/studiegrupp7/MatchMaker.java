package se.studiegrupp7;

import se.studiegrupp7.gameplay.*;
import se.studiegrupp7.listaHighscore.PlayerStat;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchMaker implements Serializable {

    public static void startTournament() {

        List<CreateBot> participants = new ArrayList<>();
        participants.add(new CreateBot(new Player(), "Player", 0));
        participants.add(new CreateBot(new Datum(), "Minute Man", 0));
        participants.add(new CreateBot(new Vokaler(), "Vowel Woman", 0));
        participants.add(new CreateBot(new RandomBot(), "Random Randy", 0));

        List<CreateBot> opponents = new ArrayList<>(participants); // Add opponents to List
        opponents.remove(0); // Remove "player" from list
        CreateBot player = participants.get(0); // Set player as a variable

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
        List<String> sortedList = participants.stream()
                .sorted(Comparator.comparing(CreateBot::getScore).reversed())
                .map(CreateBot::getName)
                .toList();

        //List<String> secondList = new ArrayList<>(sortedList);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("./scoreListFile.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(sortedList);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
