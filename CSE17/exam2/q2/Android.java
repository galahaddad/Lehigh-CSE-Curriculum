/**
 * Android
 */
public class Android {
    public Android() {
        super();
    }
    public Android(String model, double weight) {
        super(model, weight);
    }

    @Override
    public String toString() {
        return "I am an android " + model + " " + weight;
    }

    public String see() {
        return "I can see.";
    }

    public String speak() {
        return "I can speak.";
    }
    
}