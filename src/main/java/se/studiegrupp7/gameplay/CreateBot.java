package se.studiegrupp7.gameplay;

public class CreateBot {

    private Behaviors behaviors;
    String name;
    int score;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public CreateBot(Behaviors behaviors, String name, int score){
        this.behaviors=behaviors;
        this.name = name;
        this.score = score;
    }

    public String executeBehaviors(){
       return behaviors.chooseBehavior();
    }
}
