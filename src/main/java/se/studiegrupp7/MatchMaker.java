package se.studiegrupp7;

import se.studiegrupp7.gameplay.*;



import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MatchMaker implements Serializable {

    private final String playerName;
    private final int winCount = 1;
    private final int second = 2;
    private final int third = 3;
    private final int fourth = 4;
    List<Integer> placeList = new ArrayList<>();

    public MatchMaker(String playerName) {
        this.playerName = playerName;
    }

    public static void startTournament() {
    public static List<String> startTournament() {
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
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy MMMM dd - HH:mm:ss");
        String dateTimeFormatted = dateTimeFormatter.format(dateTime);

        List<String> sortedList = participants
                .stream()
                .sorted(Comparator.comparing(CreateBot::getScore).reversed())
                .collect(Collectors.toList());

        sortedList.forEach(System.out::println);


        List<String> namesList = new ArrayList<>();
        for (CreateBot createBot : sortedList) {
            namesList.add(createBot.getName());
        }
        namesList.forEach(System.out::println);

        MatchMaker playerFuckFace = new MatchMaker("nej");
        MatchMaker minuteMan = new MatchMaker("Minute man");
        MatchMaker randomRandy = new MatchMaker("Random Randy");
        MatchMaker vowelWoman = new MatchMaker("Vowel Women");


        //Player
        if (Objects.equals(namesList.get(0), playerFuckFace.getPlayerName())) {
            playerFuckFace.countWin();
        }
        if (Objects.equals(namesList.get(1), playerFuckFace.getPlayerName())) {
            playerFuckFace.countSecond();
        }
        if (Objects.equals(namesList.get(2), playerFuckFace.getPlayerName())) {
            playerFuckFace.countThird();
        }
        if (Objects.equals(namesList.get(3), playerFuckFace.getPlayerName())) {
            playerFuckFace.countFourth();
        }

        //time Lord
        if (namesList.get(0).equals(minuteMan.getPlayerName())) {
            minuteMan.countWin();

        }
        if (namesList.get(1).equals(minuteMan.getPlayerName())) {
            minuteMan.countSecond();
        }
        if (namesList.get(2).equals(minuteMan.getPlayerName())) {
            minuteMan.countThird();
        }
        if (namesList.get(3).equals(minuteMan.getPlayerName())) {
            minuteMan.countFourth();
        }
        // mr random
        if (namesList.get(0).equals(randomRandy.getPlayerName())) {
            randomRandy.countWin();
        }
        if (namesList.get(1).equals(randomRandy.getPlayerName())) {
            randomRandy.countSecond();
        }
        if (namesList.get(2).equals(randomRandy.getPlayerName())) {
            randomRandy.countThird();
        }
        if (namesList.get(3).equals(randomRandy.getPlayerName())) {
            randomRandy.countFourth();
        }

        if (namesList.get(0).equals(vowelWoman.getPlayerName())) {
            vowelWoman.countWin();



        }
        if (namesList.get(1).equals(vowelWoman.getPlayerName())) {
            vowelWoman.countSecond();

        }
        if (namesList.get(2).equals(vowelWoman.getPlayerName())) {
            vowelWoman.countThird();

        }
        if (namesList.get(3).equals(vowelWoman.getPlayerName())) {
            vowelWoman.countFourth();

        }

        System.out.println();
        playerFuckFace.getPlaceList().forEach(System.out::println);
        System.out.println();
        bestPlace(playerFuckFace);
        worstPlace(playerFuckFace);
        averagePlace(playerFuckFace);


    }


    public String getPlayerName() {
                .map(CreateBot::getName)
                .toList();

        List<String> tournamentStats = List.of(dateTimeFormatted, sortedList.get(0), sortedList.get(1), sortedList.get(2), sortedList.get(3));
        return tournamentStats;
    }
}
