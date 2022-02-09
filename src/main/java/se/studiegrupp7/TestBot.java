package se.studiegrupp7;

import java.util.Objects;

public class TestBot {

    String move = "Rock";
    int winCount;

    public String getMove() {
        return move;
    }

    public void makeMove(String playerMove){
        if (Objects.equals(playerMove, "Scissors")){
            winCount++;
        }
        else if (Objects.equals(playerMove, "Paper")){
            winCount--;
        }
        else if (Objects.equals(playerMove, "Rock")){
            System.out.println("It's a draw. Try again.");
        }

    }
}
