/**
 * Elephant
 */
public class Elephant {

    public Elephant() {
        super();
    }

    public Elephant(double weight, double age) {
        super(weight, age);
    }

    @Override
    public String toString() {
        return "I am an elephant. Weight= " + weight + " Age= " + age;
    }

    public String see() {
        return "I can see.";
    }
}