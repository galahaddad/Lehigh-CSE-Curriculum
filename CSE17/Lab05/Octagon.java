/**
 * Octagon
 */
public class Octagon extends Shape {
    private double side;

    public Octagon() {
        super();
        side=0;
    }

    public Octagon(double xCoordinate, double yCoordinate, String color, double side) {
        super(xCoordinate, yCoordinate, color);
        this.side=side;
    }

    /**
     * @return the side
     */
    public double getSide() {
        return side;
    }

    /**
     * @param side the side to set
     */
    public void setSide(double side) {
        this.side = side;
    }

    public String toString() {
        return "Octagon: \n" + super.toString() + "\nSide = " + getSide();
    }

    public double getArea() {
        return 2*(1+Math.sqrt(2))*(Math.pow(side, 2));
    }

    public double getPerimeter() {
        return side*8;
    }

    public Object clone() {
        return new Octagon(this.getxCoordinate(), this.getyCoordinate(), this.getColor(), this.getSide());
    }
    
}