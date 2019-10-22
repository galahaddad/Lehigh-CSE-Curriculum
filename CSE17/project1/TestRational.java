
import java.util.Scanner;
/**
 * TestRational
 */
public class TestRational {
    public static void main(String[] args) {
        Scanner yeye = new Scanner(System.in);
        String op = "";    //operation sentinel
        do {
            System.out.println("+----------------------------------------------------+");
            System.out.printf("|%-25s  %-18s|%n","Select an operation on fractions","");
            System.out.printf("|%-25s  %-25s|%n","1. Add two fractions","2. Subtract two fractions");
            System.out.printf("|%-25s  %-25s|%n","3. Multiply two fractions","4. Divide two fractions");
            System.out.printf("|%-25s  %-25s|%n","5. Invert fraction","6. Mixed Fraction");
            System.out.printf("|%-25s  %-25s|%n","7. Reduce fraction","8. Find GCD");
            System.out.printf("|%-25s  %-25s|%n","9. Compare two fractions","");
            System.out.println("+----------------------------------------------------+");
            System.out.println("");
            System.out.print(">>Operation: ");
            int menu = yeye.nextInt();
            if (menu == 1) {    //ADD
                Rational rgeneral = new Rational();
                System.out.print("\nEnter a fraction in the form a/b: ");
                String a = yeye.next();
                Rational aRational = new Rational(a);
                System.out.print("Enter a fraction in the form a/b: ");
                String b = yeye.next();
                Rational bRational = new Rational(b);
                System.out.println(a + " + " + b + " = " + rgeneral.Add(aRational, bRational));
                System.out.println("Would you like to perform another operation? (y/n): ");
                op = yeye.next();
            } else if (menu == 2) { //SUBTRACT
                Rational rgeneral = new Rational();
                System.out.print("\nEnter a fraction in the form a/b: ");
                String a = yeye.next();
                Rational aRational = new Rational(a);
                System.out.print("Enter a fraction in the form a/b: ");
                String b = yeye.next();
                Rational bRational = new Rational(b);
                System.out.println(a + " - " + b + " = " + rgeneral.Subtract(aRational, bRational));
                System.out.println("Would you like to perform another operation? (y/n): ");
                op = yeye.next();
            } else if (menu == 3) { //MULTIPLICATION
                Rational rgeneral = new Rational();
                System.out.print("\nEnter a fraction in the form a/b: ");
                String a = yeye.next();
                Rational aRational = new Rational(a);
                System.out.print("Enter a fraction in the form a/b: ");
                String b = yeye.next();
                Rational bRational = new Rational(b);
                System.out.println(a + " * " + b + " = " + rgeneral.Multiply(aRational, bRational));
                System.out.println("Would you like to perform another operation? (y/n): ");
                op = yeye.next();
            } else if (menu == 4) { //DIVISION
                Rational rgeneral = new Rational();
                System.out.print("\nEnter a fraction in the form a/b: ");
                String a = yeye.next();
                Rational aRational = new Rational(a);
                System.out.print("Enter a fraction in the form a/b: ");
                String b = yeye.next();
                Rational bRational = new Rational(b);
                System.out.println(a + " / " + b + " = " + rgeneral.Divide(aRational, bRational));
                System.out.println("Would you like to perform another operation? (y/n): ");
                op = yeye.next();
            } else if (menu == 5) {   //INVERT
                Rational rgeneral = new Rational();
                System.out.print("\nEnter a fraction in the form a/b: ");
                String a = yeye.next();
                Rational aRational = new Rational(a);
                System.out.println("Inversed " + a + " = " + rgeneral.Inverse(aRational));
                System.out.println("Would you like to perform another operation? (y/n): ");
                op = yeye.next();
            } else if (menu == 6) { //MIXED FRACTION
                Rational rgeneral = new Rational();
                System.out.print("\nEnter a fraction in the form a/b: ");
                String a = yeye.next();
                Rational aRational = new Rational(a);
                System.out.println("Mixed " + a + " = " + rgeneral.Mixed(aRational));
                System.out.println("Would you like to perform another operation? (y/n): ");
                op = yeye.next();
            } else if (menu == 7) { //REDUCED FRACTION
                Rational rgeneral = new Rational();
                System.out.print("\nEnter a fraction in the form a/b: ");
                String a = yeye.next();
                Rational aRational = new Rational(a);
                System.out.println("Reduced " + a + " = " + rgeneral.Reduced(aRational));
                System.out.println("Would you like to perform another operation? (y/n): ");
                op = yeye.next();
            } else if (menu == 8) { //GCD
                Rational rgeneral = new Rational();
                System.out.print("\nEnter a fraction in the form a/b: ");
                String a = yeye.next();
                Rational aRational = new Rational(a);
                System.out.println("GCD " + a + " = " + rgeneral.GCD(aRational));
                System.out.println("Would you like to perform another operation? (y/n): ");
                op = yeye.next();
            } else if (menu == 9) { //COMPARE
                Rational rgeneral = new Rational();
                System.out.print("\nEnter a fraction in the form a/b: ");
                String a = yeye.next();
                Rational aRational = new Rational(a);
                System.out.print("Enter a fraction in the form a/b: ");
                String b = yeye.next();
                Rational bRational = new Rational(b);
                if (rgeneral.isLT(aRational, bRational)) {
                    System.out.println(a + " < " + b);
                } else if (rgeneral.isGT(aRational, bRational)) {
                    System.out.println(a + " > " + b);
                } else {System.out.println(a + " = " + b);}
                System.out.println("Would you like to perform another operation? (y/n): ");
                op = yeye.next();
            }
        } while (op.contentEquals("y"));    //if op still has y as the string, the program will repeat
        System.out.println("Thank you for using the fraction calculator.");
    }
}