package se.studiegrupp7.gameplay;

public class Context {

    private Behaviors behaviors;

    public Context(Behaviors behaviors){
        this.behaviors=behaviors;
    }

    public void executeBehaviors(){
        behaviors.chooseBehavior();

    }

}
