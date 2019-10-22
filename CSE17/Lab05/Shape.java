/**
 * Shape
 * @author Ralph Haddad
 */
public abstract class Shape implements Comparable<Shape>, Cloneable {
    private double xCoordinate, yCoordinate;
    private String color;

    protected Shape() {
        xCoordinate=0;
        yCoordinate=0;
        color="";
    }

    protected Shape(double xc, double yc, String color) {
        xCoordinate=xc;
        yCoordinate=yc;
        this.color=color;
    }

    /**
     * @return the xCoordinate
     */
    public double getxCoordinate() {
        return xCoordinate;
    }

    /**
     * @return the yCoordinate
     */
    public double getyCoordinate() {
        return yCoordinate;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }
    
    /**
     * @return the area
     */
    public abstract double getArea();

    /**
     * @return the perimeter
     */
    public abstract double getPerimeter();
    
    /**
     * @return another object pointing to the same values
     */
    public abstract Object clone(); 
    

    /**
     * @param xCoordinate the xCoordinate to set
     */
    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * @param yCoordinate the yCoordinate to set
     */
    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the string of values of Shape
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Coordinates: (" + xCoordinate + ", " +yCoordinate + "),").append(" Color: " + color).append("\nArea = ").append(this.getArea()).append(", Perimeter = ").append(this.getPerimeter());
        return sb.toString();
    }

    /**
     * @return returns the area of the two shape objects as:
     * 0 if the two areas are equal
     * -1 if the first is less than the second
     * 1 if the first is greater than the second
     */
    public int compareTo(Shape shape) {
        if (getArea() == shape.getArea()) return 0;
        else if (getArea() > shape.getArea()) return 1;
        else return -1;
    }
}