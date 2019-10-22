/**
 * Project 1: Classes and Objects
 * Ralph Haddad, CSE17, Houria
 */
public class Rational {
    public int numerator, denominator;  //data members 
    public Rational(){
        denominator = 1;
    } 
    public Rational(int a, int b){
        this.numerator=a;
        this.denominator=b;
    }
    public Rational(String input){
        String [] tokens = input.split("/");    //finds where the fraction sign is and creates an array of two strings
        int numInt = Integer.parseInt(tokens[0]);    //takes the int values from the split String
        int denInt = Integer.parseInt(tokens[1]);    //making them integers
        this.numerator=numInt;  //saves the int as the numerator
        this.denominator=denInt;    //saves the int as the denominator
    }

    public int getNumerator() {return numerator;}  //accesor methods for the numerator and denominator 
    public int getDenominator() {return denominator;}
    public void setNumerator(int a) {this.numerator=a;}     //mutator methods for the numerator and denominator
    public void setDenominator(int b) {this.denominator=b;} 

    public static long gcm(long a, long b) {    //an extremely useful Stack Overflow method for fidnging the gcm in one line
        return b == 0 ? a : gcm(b, a % b); // Not bad for one line of code :)
    }
    
    public static String asFraction(long a, long b) {   //returns the simplified fraaction as a string
        long gcm = gcm(a, b);
        return (a / gcm) + "/" + (b / gcm);
    }

    public String Add(Rational a, Rational b) {     //Add method which adds two fractions and finds the simplest form
        int addNum = ((a.getNumerator() * b.getDenominator()) + (a.getDenominator() * b.getNumerator()));   //ad + bc
        int addDen = (a.getDenominator()*b.getDenominator());   //bd
        return asFraction(addNum, addDen);
    }
    
    public String Subtract(Rational a, Rational b) {     //Subtract method which subtracts two fractions and finds the simplest form
        int subNum = ((a.getNumerator() * b.getDenominator()) - (a.getDenominator() * b.getNumerator()));   //ad - bc
        int subDen = (a.getDenominator()*b.getDenominator());   //bd
        return asFraction(subNum, subDen);
    }

    public String Multiply(Rational a, Rational b) {     //Multiply method which multiplies two fractions and finds the simplest form
        int mNum = a.getNumerator() * b.getNumerator();   //ac
        int mDen = a.getDenominator()*b.getDenominator();   //bd
        return asFraction(mNum, mDen);
    }

    public String Divide(Rational a, Rational b) {     //Divide method which divides two fractions and finds the simplest form
        int divNum = a.getNumerator()*b.getDenominator();   //ad
        int divDen = a.getDenominator()*b.getNumerator();   //bc
        return asFraction(divNum, divDen);
    }

    public String Inverse(Rational a) {     //Add method which adds two fractions and finds the simplest form
        return a.getDenominator() + "/" + a.getNumerator();
    }

    public String Mixed(Rational a) {
        int m = 0;  //initializes the whole number multiple
        while (a.getNumerator()>a.getDenominator()) {    //recursively checks to see if there is a remainder
            m++;  //increments the multiple
            a.setNumerator(a.getNumerator()-a.getDenominator());    //subtracts the denominator from the numerator once
        }
        return (m + " " + asFraction(a.getNumerator(), a.getDenominator()));  //returns the multiple and a simplified fraction
    }

    public String Reduced(Rational a) {     //returns a reduced fraction by calling the asFraction method which points to a gcf method
        return asFraction(a.getNumerator(), a.getDenominator());
    }

    public String GCD(Rational a) {
        if (a.getNumerator()==0) {return String.valueOf(a.getDenominator());}   //everything divided by zero
        if (a.getDenominator()==0) {return String.valueOf(a.getNumerator());}
        if (a.getNumerator()==a.getDenominator()) {return String.valueOf(a.getNumerator());}    //base case
        if (a.getNumerator()>a.getDenominator()) {  //when a is greater
            a.setNumerator(a.getNumerator()-a.getDenominator());    //gcd(a-b, b)
            return GCD(a);
        } else {    //when b is greater
            a.setDenominator(a.getDenominator()-a.getNumerator());  //gcd (a, b-a)
            return GCD(a);
        }
    }

    public boolean isLT(Rational a, Rational b) {   //checks if rational a < b
        int y = (a.getNumerator()*b.getDenominator())-(a.getDenominator()*b.getNumerator());  //ad-bc
        return (y < 0) ? true : false;
    }

    public boolean isGT(Rational a, Rational b) {   //checks if rational a < b
        int y = (a.getNumerator()*b.getDenominator())-(a.getDenominator()*b.getNumerator());  //ad-bc
        return (y > 0) ? true : false;
    }

    public boolean isET(Rational a, Rational b) {   //checks if rational a == b
        if ((a.getNumerator()/a.getDenominator()) == (b.getNumerator()/b.getDenominator())) {
            return true;
        } else {return false;}
    }

    



    

}