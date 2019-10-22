public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    public QuadraticEquation(double x, double y, double z) {
        a=x;
        b=y;
        c=z;
    }
    public double getDiscriminant() {
        return (b*b)-(4*a*c);
    }
    public double getRoot1() {
        double root1=((-b)+Math.sqrt((b*b)-(4*a*c)))/(2*a);
        return root1;
    }
    public double getRoot2() {
        double root2=((-b)-Math.sqrt((b*b)-(4*a*c)))/(2*a);
        return root2;
    }
}