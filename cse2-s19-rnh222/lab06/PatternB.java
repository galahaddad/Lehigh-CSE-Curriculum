//Ralph Haddad - CSE2 - lab06 - 3/8/19
//Loop pattern B
import java.util.Scanner; //imports scanner class
public class PatternB {
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
    
    
    for (int numRows = length; numRows >= 1; numRows--) {  
      for (int i = 1; i <= numRows; ++i) {
        System.out.print(i + " ");
      }
      System.out.println();
    }//end of inital loop for number of rows
  }//end of method
}//end of class