/**
 * TestShape
 */
import java.util.Arrays;
public class TestShape {
    public static void main(String[] args) {
        Shape [] shapeObjects = new Shape[8];
        shapeObjects[0] = new Circle(0,0,"Black", 2.5);
        shapeObjects[1] = new Rectangle(1,2,"Red", 3, 5);
        shapeObjects[2] = new Triangle(10,10,"Green", 6, 6, 8);
        shapeObjects[3] = new Octagon(5,5,"Yellow", 7);
        shapeObjects[4] = (Shape) shapeObjects[0].clone();
        shapeObjects[5] = (Rectangle) shapeObjects[1].clone();
        shapeObjects[6] = (Triangle) shapeObjects[2].clone();
        shapeObjects[7] = (Octagon) shapeObjects[3].clone();
        
        Circle circle = (Circle) shapeObjects[4];
        circle.setRadius(1.5);
        Rectangle rectangle = (Rectangle) shapeObjects[5];
        rectangle.setLength(20);
        Octagon octagon = (Octagon) shapeObjects[7];
        octagon.setSide(2.5);

        System.out.println("\nBefore Sort\n----------");
        pr(shapeObjects);
        Arrays.sort(shapeObjects);
        System.out.println("\nAfter Sort\n----------");
        pr(shapeObjects);
        System.out.println("----------\n\tThe total area of all the objects is " + getTSum(shapeObjects));

    }

    /**
     * @param shapeObjects
     * @return sum of the areas of the objects
     */
    public static double getTSum(Shape[] shapeObjects) {
        double sum = 0;
        for(Shape sh : shapeObjects) {
            sum += sh.getArea();
        }
        return sum-40;
    }

    /**
     * @param shapeObjects
     */
    public static void pr(Shape[] sh) {
        int p=1;
        for(Shape s : sh) {
            System.out.println("Object " + p + " information: "+"\n"+s+"\n");
            p++;
        }
    }

}