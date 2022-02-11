package se.studiegrupp7;

import se.studiegrupp7.gameplay.*;
import se.studiegrupp7.listaHighscore.TournamentStats;
import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MatchMaker implements Serializable {

    public static void startTournament() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String userName = scanner.nextLine();

        List<CreateBot> participants = new ArrayList<>();
        participants.add(new CreateBot(new Player(), userName, 0));
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

        LocalDateTime dateTime = LocalDateTime.now();

        /*List<String> sortedList = participants.stream()
                .sorted(Comparator.comparing(CreateBot::getScore).reversed())
                .map(CreateBot::getName)
                .toList();*/

        List<TournamentStats> tournamentStats = List.of(
                new TournamentStats(participants.get(0).getName(), participants.get(0).getScore(), dateTime),
                new TournamentStats(participants.get(1).getName(), participants.get(1).getScore(), dateTime),
                new TournamentStats(participants.get(2).getName(), participants.get(2).getScore(), dateTime),
                new TournamentStats(participants.get(3).getName(), participants.get(3).getScore(), dateTime)
        );

        //List<String> secondList = new ArrayList<>(sortedList);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("./scoreListFile.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(tournamentStats);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
