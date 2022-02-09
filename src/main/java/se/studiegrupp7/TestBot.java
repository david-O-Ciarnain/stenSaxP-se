package se.studiegrupp7;

public class TestBot {

    String name;
    String move;
    int score;

    public TestBot(String name, String move, int score) {
        this.name = name;
        this.move = move;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getMove() {
        return move;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "TestBot{" +
                "name='" + name + '\'' +
                ", move='" + move + '\'' +
                ", score=" + score +
                '}';
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setMove(String move) {
        this.move = move;
    }
}
