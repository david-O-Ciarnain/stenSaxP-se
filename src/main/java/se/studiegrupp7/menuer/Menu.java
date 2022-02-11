package se.studiegrupp7.menuer;

import java.io.IOException;

public interface Menu {
    void display();
    void chooses(int input) throws IOException;
}
