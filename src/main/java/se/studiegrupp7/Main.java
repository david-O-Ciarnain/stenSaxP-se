package se.studiegrupp7;




import se.studiegrupp7.menuer.Menu;
import se.studiegrupp7.menuer.StartMeny;

import java.io.IOException;


import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws IOException {
        Menu menu = new StartMeny();
        menu.display();
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        menu.chooses(input);
    }
}
      /*  List<TournamentStats> tournamentStats = List.of(
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
        */
