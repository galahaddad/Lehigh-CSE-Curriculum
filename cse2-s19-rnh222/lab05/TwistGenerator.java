//Ralph Haddad - 3/1/19 - CSE2
//TWIST GENERATOR: Creates a set of twists based on user input
//  \ /
//   X  
//  / \

import java.util.Scanner; //Imports scanner class
public class TwistGenerator {
  public static void main (String[] args) {
    Scanner myLoop = new Scanner (System.in);
    int length = 0;  //takes in the user input for the length of the twist
  System.out.print("Enter the twist length!: ");
      while (!myLoop.hasNextInt()) {
        System.out.print("Enter the twist length!: ");  //notifies user of action to input twist length
          if (!myLoop.hasNextInt()){
            System.out.println("(Sorry, that is not an integer.)");
            String junkLength = myLoop.next();  //junks the input if not an integer
          }
      }
    length = myLoop.nextInt();
    //For loop to print out the twits sequence by line. Therefore 3 loops.
    for (int i = 0; i < length; i++) {  
      switch (i%3) {    //switch statement for top row of twist
          case 0:
            System.out.print("\\");
            break;
          case 1:
            System.out.print(" ");
            break;
          case 2:
            System.out.print("/");
            break;
        }
    }
    System.out.println();//tab for next line
    for (int i = 0; i < length; i++) {
        switch (i%3) {    //switch statement for middle row of twist
          case 0:
            System.out.print(" ");
            break;
          case 1:
            System.out.print("X");
            break;
          case 2:
            System.out.print(" ");
        }
     }
    System.out.println();
    for (int i = 0; i < length; i++){ 
        switch (i%3) {    //switch statement for bottom row of twist
          case 0:
            System.out.print("/");
            break;
          case 1:
            System.out.print(" ");
            break;
          case 2:
            System.out.print("\\");
        }
      }
    System.out.println();
  }//end of main method
}//end of class
