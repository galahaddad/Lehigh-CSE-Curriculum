/**
 * Rectangle
 */
public class Rectangle extends Shape {
    private double length, width;

    public Rectangle() {
        super();
        length=0;
        width=0;
    }

    public Rectangle(double xCoordinate, double yCoordinate, String color, double length, double width) {
        super(xCoordinate, yCoordinate, color);
        this.length=length;
        this.width=width;
    }

    /**
     * @return the length
     */
    public double getLength() {
        return length;
    }
    
    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param length the length to set
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }

    public String toString() {
        return "Rectangle: \n" + super.toString() + "\nLength = " + getLength() + ", Width = " + getWidth();
    }

    public double getPerimeter() {
        return (2*length)+(2*width);
    }

    public double getArea() {
        return (length*width);
    }

    public Object clone() {
        return new Rectangle(this.getxCoordinate(), this.getyCoordinate(), this.getColor(), this.getLength(), this.getWidth());
    }
    
}