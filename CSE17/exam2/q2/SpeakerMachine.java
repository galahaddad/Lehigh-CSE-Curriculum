/**
 * SpeakerMachine
 */
public class SpeakerMachine {
    String model;
    double weight;

    protected Machine() {
        model="";
        weight=0;
    }

    protected Machine(String model, double weight) {
        this.model=model;
        this.weight=weight;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }
    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "I am a machine " + model + " " + weight;
    }

    public String speak() {
        return "I can speak.";
    }


    
}