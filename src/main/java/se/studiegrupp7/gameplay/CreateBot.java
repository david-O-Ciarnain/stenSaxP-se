package se.studiegrupp7.gameplay;

public class CreateBot {

    private Behaviors behaviors;
    String name;

    public String getName() {
        return name;
    }

    public CreateBot(Behaviors behaviors, String name){
        this.behaviors=behaviors;
        this.name = name;
    }

    public void executeBehaviors(){
        behaviors.chooseBehavior();
    }

}
