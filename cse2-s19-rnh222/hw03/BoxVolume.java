//Ralph Haddad - CSE2 - BoxVolume hw03 - 2/8/19
//Determines the volume of an inputted box
import java.util.Scanner; //imports the scanner java utility
public class BoxVolume {  //creates a Box Volume class
  public static void main (String[] args) { //initiates the main
    Scanner myVol = new Scanner (System.in);  //names a scanner myVol
    System.out.print("Enter the width as an integer: "); //requests width
    int volWidth = myVol.nextInt(); //takes in the volume width
    System.out.print("Enter the length as an integer: "); //requests length
    int volLength = myVol.nextInt(); //takes in the volume length
    System.out.print("Enter the height as an integer: "); //requests height
    int volHeight = myVol.nextInt(); //takes in the volume height
    
    int volFinal = volWidth * volLength * volHeight;  //determines the final volume
    System.out.println("The volume inside the box is: " + volFinal);  //prints the final volume to the terminal
    
  }//ends main
}//ends class
