//Hw05 assignment - Ralph Haddad - CSE2 - 3/4/19
//This program is intended to take in uer information on their college courses
//and return an error statement if the wrong input is used
import java.util.Scanner;//imports the Scanner class
public class Hw05 {
  public static void main (String[] args) {
    Scanner userIn = new Scanner (System.in);
    
    int CRN = 0;  //takes in the user input for the CRN
    System.out.print("Enter your course number: ");
      while (!userIn.hasNextInt()) {
        System.out.print("Enter your course number: ");  //notifies user of action to re-enter information
          if (!userIn.hasNextInt()){
            System.out.println("(Sorry, that input does not work.)");
            String junkCRN = userIn.next();  //junks the input if not an integer
          }
      }
    CRN = userIn.nextInt();
    
    String DepNm;  //takes in the user input for department name
    System.out.print("Enter the Department name: ");
      while (userIn.hasNextInt()||userIn.hasNextDouble()) { //checks to see if either are true to ensure a string was inputted
        System.out.print("Enter the Department name: ");  //notifies user of action to re enter info
          if (userIn.hasNextInt()||userIn.hasNextDouble()){
            System.out.println("(Sorry, that input does not work.)");
            String junkDepNm = userIn.next();  //junks the input if not an integer
          }
      }
    DepNm = userIn.next();
    
    int weekNum = 0;  //takes in the user input for the length of the twist
    System.out.print("Enter the amount of times per week this course meets: ");
      while (!userIn.hasNextInt()) {
        System.out.print("Enter the amount of times per week this course meets: ");
          if (!userIn.hasNextInt()){
            System.out.println("(Sorry, that input does not work.)");
            String junkweekNum = userIn.next();  //junks the input if not an integer
          }
      }
    weekNum = userIn.nextInt();
    
    int hour = 0;
    int mins = 0;
    System.out.print("Enter the hour this class meets: ");
      while (!userIn.hasNextInt()) {
        System.out.print("Enter the hour this class meets: ");
          if (!userIn.hasNextInt()){
            System.out.println("(Sorry, that input does not work.)");
            String junkhour = userIn.next();  //junks the input if not an integer
          }
      }
    hour = userIn.nextInt();
    
    System.out.print("Enter the part of the hour this class meets: ");
      while (!userIn.hasNextInt()) {
        System.out.print("Enter the part of the hour this class meets: ");
          if (!userIn.hasNextInt()){
            System.out.println("(Sorry, that input does not work.)");
            String junkmin = userIn.next();  //junks the input if not an integer
          }
      }
    mins = userIn.nextInt();
    
    String instructor;  //takes in the user input for the insturctor name
    System.out.print("Enter the name of the instructor: ");
      while (userIn.hasNextInt()||userIn.hasNextDouble()) {
        System.out.print("Enter the name of the instructor: ");
          if (userIn.hasNextInt()||userIn.hasNextDouble()){
            System.out.println("(Sorry, that input does not work.)");
            String junkinstructor = userIn.next();  //junks the input if not a string
          }
      }
    instructor = userIn.next();
    
    int StuNum = 0;
    System.out.print("Enter the number of students: ");
      while (!userIn.hasNextInt()) {
        System.out.print("Enter the number of students: ");
          if (!userIn.hasNextInt()){
            System.out.println("(Sorry, that input does not work.)");
            String junkStuNum = userIn.next();  //junks the input if not an integer
          }
      }
    StuNum = userIn.nextInt();  
    
    
    System.out.println("Course number: " + CRN);  //prints out user inputs of all class data
    System.out.println("Department Name: " + DepNm);
    System.out.println("classes per week: " + weekNum);
    System.out.println("Meeting time: " + hour + ":" + mins);
    System.out.println("Instrutor name: " + instructor);
    System.out.println("Number of students: " + StuNum);
  }//end of main method
}//end of class