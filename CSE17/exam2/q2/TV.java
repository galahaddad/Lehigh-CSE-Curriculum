/**
 * TV
 */
public class TV {

    public TV() {
        super();
    }
    public TV(String model, double weight) {
        super(model, weight);
    }

    @Override
    public String toString() {
        return "I am a TV " + model + " " + weight;
    }

    public String speak() {
        return "I can speak.";
    }
    
}