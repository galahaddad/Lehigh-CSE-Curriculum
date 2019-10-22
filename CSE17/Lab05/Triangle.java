/**
 * Triangle
 */
public class Triangle extends Shape{
    private double side1, side2, side3;

    public Triangle() {
        super();
        side1=0;
        side2=0;
        side3=0;
    }

    public Triangle(double xCoordinate, double yCoordinate, String Color, double s1, double s2, double s3) {
        super(xCoordinate, yCoordinate, Color);
        side1=s1;
        side2=s2;
        side3=s3;
    }

    /**
     * @return the side1
     */
    public double getSide1() {
        return side1;
    }

    /**
     * @return the side2
     */
    public double getSide2() {
        return side2;
    }

    /**
     * @return the side3
     */
    public double getSide3() {
        return side3;
    }

    /**
     * @param side1 the side1 to set
     */
    public void setSide1(double side1) {
        this.side1 = side1;
    }

    /**
     * @param side2 the side2 to set
     */
    public void setSide2(double side2) {
        this.side2 = side2;
    }

    /**
     * @param side3 the side3 to set
     */
    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public String toString() {
        return "Triangle: \n" + super.toString() + "\nSide 1 = " + getSide1() + ", Side 2 = " + getSide2() + ", Side 3 = " + getSide3();
    }

    public double getPerimeter() {
        return side1+side2+side3;
    }

    public double getArea() {
        double p = getPerimeter()/2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }
    
    public Object clone() {
        return new Triangle(this.getxCoordinate(), this.getyCoordinate(), this.getColor(), this.getSide1(), this.getSide2(), this.getSide3());
    }

}