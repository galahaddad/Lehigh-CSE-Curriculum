/**
 * Mammal
 */
public class Mammal {
    double weight, age;
    protected Mammal() {
        weight=0;
        age=0;
    }
    protected Mammal(double weight, double age) {
        this.weight=weight;
        this.age=age;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @return the age
     */
    public double getAge() {
        return age;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @param age the age to set
     */
    public void setAge(double age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "I am a mammal. Weight= " + weight + " Age= " + age;
    }
    
    public String see() {
        return "I can see.";
    }
    
}