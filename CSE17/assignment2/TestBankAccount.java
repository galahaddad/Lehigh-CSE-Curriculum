//Extension of the BankAccount class of Assignment 2
//Ralph Haddad - Houria, CSE17
import java.util.Scanner;
public class TestBankAccount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BankAccount.fee = 0.1;  //using static member to initialize fee for 10% for each deposit or withdraw from bank
        BankAccount[] bankAccounts = new BankAccount[5];    //array of the object bank account
        //account info as given in the assignment
        bankAccounts[0] = new BankAccount("John Marcy",12534,1200);   
        bankAccounts[1] = new BankAccount();    //no parameters
        bankAccounts[2] = new BankAccount("Elanor Maxwell",33322,450);
        bankAccounts[3] = new BankAccount("Fred Karl",55500,23000);
        bankAccounts[4] = new BankAccount("Mary Marsh",11111,550);
        int op; //takes in user input
        do {
            System.out.print("Select an operation \n 1:View Account Balance\n 2:Deposit\n 3:Withdraw\n 4:View All Accounts\n 5:Exit\n");
            do {
                if(in.hasNextInt()){    //parses input for useable value
                    op = in.nextInt();
                    if(op<1 || op>5) {
                        System.out.println("Please select one of the 5 options!");
                        continue;
                    } else {
                        break;  //breaks when a value is useable
                    }
                } else {
                    String junk = in.next();
                    System.out.println("Sorry, that input can't be taken. ");
                    System.out.print("Please select one of the 5 options!");
                }
            } while (true);
            int accN;
            boolean iLoop = true;
            switch(op){
                case 1:
                    int p = 1;
                    do {    //a do while loop that does not let the program proceed until a correct answer is given
                        System.out.println("Enter Account Number: ");
                        if (in.hasNextInt()) {  
                            accN = in.nextInt();
                            for (int i = 0; i<5; i++) {
                                if(accN == bankAccounts[i].getAccN()) {
                                    System.out.println("Account "+accN+" balance is: $"+bankAccounts[i].getBal());
                                    p = 0;
                                    break;
                                }
                            }
                            if (p == 0) {
                                break;
                            } else {
                                System.out.println("That account number is not registered.");
                                continue;
                            }   
                        } else {
                            System.out.print("Please try a new input. ");
                            String junk = in.next();    //clears entry
                        }
                        
                    } while (p != 0);   //repeats until sentinel is 0
                    break;
                case 2:
                    p = 1;
                    do {    //a do while loop that does not let the program proceed until a correct answer is given
                        System.out.println("Enter Account Number: ");
                        if (in.hasNextInt()) {  
                            accN = in.nextInt();
                            for (int i = 0; i<5; i++) {
                                if(accN == bankAccounts[i].getAccN()) {
                                    do {
                                        System.out.println("How much will you deposit?: $");
                                        if (in.hasNextDouble()) {
                                            double nDep = in.nextDouble();
                                            bankAccounts[i].deposit(nDep);
                                            bankAccounts[i].applyFee();;
                                            System.out.println("You deposited: $" + nDep);
                                            break;
                                        } else {
                                            System.out.print("Can't take that input. Try again: ");
                                            String junk = in.next();
                                            continue;
                                        }
                                    } while (p == 1);
                                    p = 0;
                                    break;        
                                }
                                }
                                    if (p == 0) {
                                        break;
                                    } else {
                                        System.out.println("That account number is not registered.");
                                        continue;
                                    }   
                        } else {
                            System.out.print("Please try a new input. ");
                            String junk2 = in.next();    //clears entry
                        }
                    
                    } while (p != 0);   //repeats until sentinel is 0
                    break;
                case 3:
                    p = 1;
                    do {    //a do while loop that does not let the program proceed until a correct answer is given
                        System.out.println("Enter Account Number: ");
                        if (in.hasNextInt()) {  
                            accN = in.nextInt();
                            for (int i = 0; i<5; i++) {
                                
                                do {
                                    System.out.println("How much will you withdraw?: $");
                                    if(in.hasNextDouble()) {
                                        double nWit = in.nextDouble();
                                                bankAccounts[i].withdraw(nWit);
                                                bankAccounts[i].applyFee();;
                                                System.out.println("You withdrew: $" + nWit);
                                                break;
                                            } else {
                                                System.out.print("Can't take that input. Try again: ");
                                                String junk = in.next();
                                                continue;
                                    }
                                } while (p==1);
                                p = 0;
                                break;
                            }
                            if (p == 0) {
                                break;
                            } else {
                                System.out.println("That account number is not registered.");
                                continue;
                            }   
                        } else {
                            System.out.print("Please try a new input. ");
                            String junk = in.next();    //clears entry
                        }
                        
                    } while (p != 0);   //repeats until sentinel is 0
                    break;
                case 4:
                    for(int i = 0; i<5; i++) {
                        System.out.println(bankAccounts[i].toString()); //prints the account info
                        System.out.println();
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println();   //spacer
                    }
                    break;
                case 5:
                System.out.println("Have a good day! :)");
            } 
        }while(op!=5);  //reruns until an operation is used
    }
}