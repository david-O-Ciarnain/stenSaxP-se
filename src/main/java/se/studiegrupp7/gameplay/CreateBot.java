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

    public CreateBot(Behaviors behaviors, String name){
        this.behaviors=behaviors;
        this.name = name;
    }

    public void executeBehaviors(){
        behaviors.chooseBehavior();
    }

}
