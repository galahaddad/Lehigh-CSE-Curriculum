/**
 * Circle
 * @author Ralph Haddad
 */
public class Circle extends Shape {
    private double radius;
    
    public Circle() {
        super();
        radius=0;
    }

    public Circle(double xc, double yc, String col, double r) {
        super(xc, yc, col);
        radius=r;
    }

    /**
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    
    public String toString() {
        return "Circle: \n" + super.toString() + ", Radius = " + getRadius();
    }

    public Object clone() {
        return new Circle(this.getxCoordinate(), this.getyCoordinate(), this.getColor(), this.getRadius());
    }

    
}