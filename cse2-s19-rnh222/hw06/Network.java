//Ralph Haddad - CSE2 - 3/13/19 - Network
//Create a set of boxes and edges that fit within a window size
//Post Assignment: I have learned of the importance of priority within a pattern when using a for loop
//and how every potential output for each position must be tested. Additionaly, the edge case of
//fence-posting occurs often when initiating a sentinel value or box value by 0. Credit to Cole K
//for helping me with operation and heirerarchy order, and debugging.
import java.util.Scanner; //imports scanner class
public class Network {
  public static void main (String[] args) {
    
    Scanner myIn = new Scanner (System.in); //initializes the scanner class as myIn(put)
    
    int winH;   //initializes the integer length
    do {  //a do while loop to ensure a value capable of being uesd in the 
    System.out.print("Enter desired window height: ");
      while (!myIn.hasNextInt()) {  //when no integer is placed, requests an integer and junks the last input
        System.out.print("That is not an integer, enter a window height: ");
        myIn.next(); 
      }
      winH = myIn.nextInt();  //sets integer width
    } while (winH <= 0); //ensures a value between 1 and 10 by refusing all other values
    System.out.println("  > Valid Window Height Input: " + winH); //confirms the input was taken for the pattern
    
    int winL;   //initializes the integer width
    do {  //a do while loop to ensure a value capable of being uesd in the 
    System.out.print("Enter desired window length: ");
      while (!myIn.hasNextInt()) {  //when no integer is placed, requests an integer and junks the last input
        System.out.print("That is not an integer, enter a window length: ");
        myIn.next(); 
      }
      winL = myIn.nextInt();  //sets integer length
    } while (winH <= 0); //ensures a value between 1 and 10 by refusing all other values
    System.out.println("  > Valid Window Length Input: " + winL); //confirms the input was taken for the pattern
    
    int sq;   //initializes the integer length
    do {  //a do while loop to ensure a value capable of being uesd in the 
    System.out.print("Enter desired square size: ");
      while (!myIn.hasNextInt()) {  //when no integer is placed, requests an integer and junks the last input
        System.out.print("That is not an integer, enter a square size: ");
        myIn.next(); 
      }
      sq = (myIn.nextInt());  //sets integer square size
    } while (sq < 1); //ensures a value between 1 and 10 by refusing all other values
    System.out.println("  > Valid Square Size Input: " + sq); //confirms the input was taken for the pattern
    
    int edge;   //initializes the integer length
    do {  //a do while loop to ensure a value capable of being uesd in the 
    System.out.print("Enter desired edge size: ");
      while (!myIn.hasNextInt()) {  //when no integer is placed, requests an integer and junks the last input
        System.out.print("That is not an integer, enter a square size: ");
        myIn.next(); 
      }
      edge = myIn.nextInt();  //sets integer square size
    } while (edge <= 1); //ensures a value between 1 and 10 by refusing all other values
    System.out.println("  > Valid Square Size Input: " + sq); //confirms the input was taken for the pattern
    
    System.out.println("");//spacer
    
    
    for (int row = 0; row < winH; row++) { //for loop with i = rows and j = columns
      for (int column = 0; column < winL; column++) {
        
        int columnMinusEdges = column - (edge*((column)/(edge+sq))); //WITHIN BOXES, checks the column and row location of the pattern
        int rowMisEdges = row - (edge*((row)/(edge+sq)));            //such that statements below ignore the length of the previous pattern length
                                                                     //and edge length           
        if ((((column % (sq+edge)) == 0) || ((column % (sq+edge)) == sq - 1)) && (((row % (sq+edge)) == 0) || ((row % (sq+edge)) == sq - 1))) { //checks for box corners by validating mod of 
          System.out.print("#");                                                                                                                //current row and column value is 0
        } else if( (column % (sq + edge)) / (sq) > 0) {                        //Second in Priority: Identifies if location is outside the box (right of) and 
          if ((sq % 2) == 0) {                                                 //and requires an EDGE of even or odd value based on square size or inserts space
            if ((row%(sq+edge)) == (sq / 2) || row%(sq+edge) == (sq / 2)-1) {  //<Done if odd (sees if the mod of the current row with the pattern length is equal to half the box size & half box size - 1)
              System.out.print("-");
            }  else {
              System.out.print(" ");
            }
          } else {
             if ((row%(sq+edge)) == (sq / 2)) {                                 //<Done if even (Sees if there is a row mod pattern length equal to exactly half the box size)
               System.out.print("-");
             } else {
               System.out.print(" ");
             }
          }
        } else if (row % (sq+edge) >= (sq)) {                                         //Third in Priority: Identifies if location is outside the box (below) and
          if ((sq % 2) == 0) {                                                        //checks if the EDGE is even or odd based on square size or inserts space
            if ((column%(sq+edge)) == (sq / 2) || column%(sq+edge) == (sq / 2)-1) {   //<Done if odd
              System.out.print("|");
            }  else {
              System.out.print(" ");
            }
          } else {
             if ((column%(sq+edge)) == (sq / 2)) {                                    //<Done if even
               System.out.print("|");
             } else {
               System.out.print(" ");
             }
          }
        } else if (((columnMinusEdges % (sq)) == 0) && ((rowMisEdges % (sq)) != 0)) {   //Fourth in Priority: Identifies if position is left side of square and inserts pipes
          System.out.print("|");
        } else if (((columnMinusEdges % (sq)) != 0) && ((rowMisEdges % (sq)) == 0)) {   //Fifth in Priority: Identifes if positon is top side of square and inserts dashes
          System.out.print("-");
        } else if(columnMinusEdges % sq == sq-1 && ((rowMisEdges % (sq)) != 0)) {       //Sixth in Priority: Identifies if position is right side of square and inserts pipes
          System.out.print("|");
        } else if(((columnMinusEdges % (sq)) != 0) && ((rowMisEdges % (sq)) == sq-1)) { //Seventh in Priority: Identifies if position is bottom side of square and inserts dashes
          System.out.print("-");
        } else {                                                                        //Eighth in Priority: IF all other cases within the square pattern have been done, then the
          System.out.print(" ");                                                        //only character remaining is the space
        }          
                                 
      }
      System.out.println("");   //moves the print to the next row down
    }
    
  }//end of main method
}//end of main class