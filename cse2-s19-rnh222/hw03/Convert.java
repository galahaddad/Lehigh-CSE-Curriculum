//Ralph Haddad - CSE2 - Convert hw03 - 2/8/19
//Takes user input to convert meters to inches
import java.util.Scanner;
public class Convert {
  public static void main (String[] args) {
    Scanner myConvert = new Scanner (System.in);  //names scanner class myConvert
    System.out.print("Enter the distance in meters in the form xx.xx: "); //requests meter input
    double meterIn = myConvert.nextDouble();  //takes in input for meter amount to convert
    System.out.println(meterIn + " meters is "+ String.format("%.4f",(meterIn * 39.37)) + " inches.");  //releases the string value of the conversion truncated at 4 decimal places
    //This will create rounding error due to floating point imprecision (Meters to inches conversion sourced from Google)
  }//ends the convert main 
}//ends the convert class