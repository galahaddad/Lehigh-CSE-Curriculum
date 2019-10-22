/**
 * Radio
 */
public class Radio {
    public Radio() {
        super();
    }

    public Radio(String model, double weight) {
        super(model, weight);
    }

    @Override
    public String toString() {
        return "I am a Radio " + model + " " + weight;
    }

    public String speak() {
        return "I can speak.";
    }
    
}