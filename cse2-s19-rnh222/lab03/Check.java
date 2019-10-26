//Check Lab - CSE2 - Ralph Haddad - 2/8/19
//
//This program takes inputs from the user to calculate a check balance for a night out at a diner
import java.util.Scanner; //Imports scanner class
public class Check {
  //main check class
  public static void main (String[] args) {
    Scanner myCheck = new Scanner (System.in);
    System.out.print("Enter the cost of the check in the form xx.xx: ");  //notifies user of action to input check
    double checkCost = myCheck.nextDouble();  //takes in the user input for the check
    System.out.print("Enter the percentage tip that you wish to pay as a whole number (in the form xx): ");  //notifies for tip percent
    double tipPercent = myCheck.nextDouble(); //takes in user input for tip percent
    tipPercent /= 100; //We want to convert the percentage into a decimal value
    System.out.print("Enter the number of people who went out to dinner: ");  //requests party number
    int numPeople = myCheck.nextInt();  //takes in number of peope who went out
    
    double totalCost;
    double costPerPerson;
    int dollars,  //whole dollar amount of cost
    dimes, pennies;  //for storing digits to the right of decimal for cost$
    
    totalCost = checkCost * (1+ tipPercent);  //determines total cost with tipPercent
    costPerPerson = totalCost / numPeople;  //divides the cost among all people
    //get the whole amount, dropping decimal fraction
    dollars = (int) costPerPerson;  //takes the double value of the cost for future calculation
    //get dimes amount, e.g., 
    // (int)(6.73 * 10) % 10 -> 67 % 10 -> 7
    //  where the % (mod) operator returns the remainder
    //  after the division:   583%100 -> 83, 27%5 -> 2 
    dimes = (int)(costPerPerson * 10) % 10; //takes cost remainder in dimes
    pennies = (int)(costPerPerson * 100) % 10;  //takes cost remainder in pennies
    System.out.println("Each person in the group owes $" + dollars + '.' + dimes + pennies);  //determines the cost for each person
  }//end of Check method
}//end of Check class
