/**
 * Human
 */
public class Human {

    public Human() {
        super();
    }

    public Human(double weight, double age) {
        super(weight, age);
    }

    @Override
    public String toString() {
        return "I am a human " + weight + " " + age;
    }

    public String speak() {
        return "I can speak.";
    }

    public String see() {
        return "I can see.";
    }

}