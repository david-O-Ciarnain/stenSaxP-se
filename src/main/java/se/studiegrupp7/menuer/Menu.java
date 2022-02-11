package se.studiegrupp7.menuer;

import java.util.List;

public interface Menu {
    void display();
    void chooses(int input, List<List<String>> tournamentStats);
}
