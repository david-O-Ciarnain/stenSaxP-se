package se.studiegrupp7.gameplay;

public class CreateBot{

    // Detta är "navigatorn" i vårt pattern //

    private final Behaviors behaviors;
    String name;
    int score;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public CreateBot(Behaviors behaviors, String name, int score){
        this.behaviors=behaviors;
        this.name = name;
        this.score = score;
    }

    public String executeBehaviors(String oppoName){
       return behaviors.chooseBehavior(oppoName);
    }

    @Override
    public String toString() {
        return  "Name='" + name + '\'' +
                ", Score=" + score;
    }
}
