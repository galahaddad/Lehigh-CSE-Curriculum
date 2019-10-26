//Ralph Haddad - CSE2 - lab06 - 3/8/19
//Loop pattern C
import java.util.Scanner; //imports scanner class
public class PatternC {
  public static void main (String[] args) {
    Scanner myLoop = new Scanner (System.in); //initializes the scanner class as myLoop
    int length;   //initializes the integer length
    do {  //a do while loop to ensure a value capable of being uesd in the 
    System.out.println("Enter pyramid lenght between 1 and 10: ");
      while (!myLoop.hasNextInt()) {  //when no integer is placed, requests an integer and junks the last input
        System.out.println("That input does not work. Enter pyramid lenght between 1 and 10: ");
        myLoop.next(); 
      }
      length = myLoop.nextInt();  //sets integer length
    } while (length <= 1 || length > 10); //ensures a value between 1 and 10 by refusing all other values
    System.out.println("Valid Input: " + length); //confirms the input was taken for the pattern
    
    for (int numRows = 1; numRows <= length; ++numRows) { //initializes the rows needed for the pattern
      for (int spaces = length; spaces >= numRows; spaces--) {  //sets up the spaces before the value 
        System.out.print(" ");
      }
      for (int c = numRows; c >= 1; c--) {  //uses the sentry c for the value to be printed based on the row it is on
        System.out.print(c);
      }
      System.out.println();
    }//end of external for loop for number of rows
  }//end of method
}//end of class