import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.*;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
/**
 * TestBankAccount - Ralph Haddad - Houria, CSE17
 */
public class TestBankAccount {
    public static void main(String[] args) {
        File file = null;
        PrintWriter outPrintWriter = null;
        Scanner inputStream;
        Scanner in = new Scanner(System.in);
        BankAccount.fee = 0.1;
        BankAccount.criterion = 10000;
        SavingsAccount.monthlyFee = 20;
        BankAccount[] bankAccounts = new BankAccount[50];   //intitializes 50 bank accounts
        int currentMax = 0;
        boolean quit = false;
        
        try {
            file = new File("accounts.txt");
            inputStream = new Scanner(file);
            while(inputStream.hasNextLine()) {
                String compString = inputStream.nextLine();
                if (compString.matches("regular")) {
                    int AN = Integer.parseInt(inputStream.nextLine());
                    String name = inputStream.nextLine();
                    double Abal = Double.parseDouble(inputStream.nextLine());
                    bankAccounts[currentMax] = new BankAccount(name, AN, Abal);
                    currentMax++;
                } else if (compString.matches("savings")) {
                    int AN = Integer.parseInt(inputStream.nextLine());
                    String name = inputStream.nextLine();
                    double Abal = Double.parseDouble(inputStream.nextLine());
                    double AYir = Double.parseDouble(inputStream.nextLine());
                    bankAccounts[currentMax] = new SavingsAccount(name, AN, Abal, AYir);
                    currentMax++;
                } else if (compString.matches("investment")) {
                    int AN = Integer.parseInt(inputStream.nextLine());
                    String name = inputStream.nextLine();
                    double Abal = Double.parseDouble(inputStream.nextLine());
                    String Atype = inputStream.nextLine();
                    bankAccounts[currentMax] = new InvestmentAccount(name, AN, Abal, Atype);
                    currentMax++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Will create one at next exit of program.");
        }

        while (!quit) {
            System.out.println("Please selct an operation: \n1. View an account balance\n2. Deposit\n3. Withdraw\n4. View monthly interest on a savings account\n5. View profit/loss on an investment account\n6. View all bank accounts \n7. View duplicate accounts\n8. View accounts of a certain criterion\n9. Sort all accounts\n10. Save and exit");
            int menuAction = in.nextInt();
            if (menuAction==1) {
                try {
                    System.out.println("Please enter the account number:");
                    int accNIn = in.nextInt();
                    System.out.println("Please enter the account type (regular, savings, or investment):");
                    String accTypeIn = in.next();
                    if (accTypeIn.matches("savings")) {
                        for(int q=0; q<currentMax;q++) {
                            if(bankAccounts[q].getAccN()==accNIn && bankAccounts[q] instanceof SavingsAccount) {
                                System.out.println("Savings account balance is " + bankAccounts[q].getBal());
                                break;
                            } else {throw new Exception("No such account number/type exists.(1)");}
                        }
                    } else if (accTypeIn.matches("investment")) {
                        for(int q=0; q<currentMax;q++) {
                            if(bankAccounts[q].getAccN()==accNIn && bankAccounts[q] instanceof InvestmentAccount) {
                                System.out.println("Investment account balance is " + bankAccounts[q].getBal());
                                break;
                            } else {throw new Exception("No such account number/type exists.(2)");}
                        }
                    } else if (accTypeIn.matches("regular")){
                        for(int q=0; q<currentMax;q++) {
                            if(bankAccounts[q].getAccN()==accNIn && bankAccounts[q] instanceof BankAccount) {
                                System.out.println("Regular account balance is " + bankAccounts[q].getBal());
                                break;
                            } else {throw new Exception("No such account number/type exists.(3)");}
                        }
                    } else {throw new Exception("No such account type exists.");}
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (menuAction==2) {
                try {
                    System.out.println("Please enter the account number:");
                    int accNIn = in.nextInt();
                    System.out.println("Please enter the account type (regular, savings, or investment):");
                    String accTypeIn = in.next();
                    System.out.println("Please enter the amount to be depositied: ");
                    double depositied = in.nextDouble();
                    if (depositied<0) {throw new Exception("A negative value cannot be deposited.");}
                    if (accTypeIn.matches("savings")) {
                        for(int q=0; q<currentMax;q++) {
                            if(bankAccounts[q].getAccN()==accNIn && bankAccounts[q] instanceof SavingsAccount) {
                                bankAccounts[q].deposit(depositied);
                                System.out.println("Savings account has been deposited " + depositied + "; New balance is " + bankAccounts[q].getBal());
                                break;
                            } else {throw new Exception("No such account number/type exists.(1)");}
                        }
                    } else if (accTypeIn.matches("investment")) {
                        for(int q=0; q<currentMax;q++) {
                            if(bankAccounts[q].getAccN()==accNIn && bankAccounts[q] instanceof InvestmentAccount) {
                                bankAccounts[q].deposit(depositied);
                                System.out.println("Investment account has been deposited " + depositied + "; New balance is " + bankAccounts[q].getBal());
                                break;
                            } else {throw new Exception("No such account number/type exists.(2)");}
                        }
                    } else if (accTypeIn.matches("regular")){
                        for(int q=0; q<currentMax;q++) {
                            if(bankAccounts[q].getAccN()==accNIn && bankAccounts[q] instanceof BankAccount) {
                                bankAccounts[q].deposit(depositied);
                                System.out.println("Regular account has been deposited " + depositied + "; New balance is " + bankAccounts[q].getBal());
                                break;
                            } else {throw new Exception("No such account number/type exists.(3)");}
                        }
                    } else {throw new Exception("No such account type exists.");}
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (menuAction==3) {
                try {
                    System.out.println("Please enter the account number:");
                    int accNIn = in.nextInt();
                    System.out.println("Please enter the account type (regular, savings, or investment):");
                    String accTypeIn = in.next();
                    System.out.println("Please enter the amount to be withdrawn: ");
                    double withdrawn = in.nextDouble();
                    if (accTypeIn.matches("savings")) {
                        for(int q=0; q<currentMax;q++) {
                            if(bankAccounts[q].getAccN()==accNIn && bankAccounts[q] instanceof SavingsAccount && bankAccounts[q].getBal()>withdrawn) {
                                bankAccounts[q].withdraw(withdrawn);
                                System.out.println("Savings account has been withdrawn " + withdrawn + "; New balance is " + bankAccounts[q].getBal());
                                break;
                            } else {throw new Exception("No such account number/type exists, or amount withdrawn exceeds balance.(1)");}
                        }
                    } else if (accTypeIn.matches("investment")) {
                        for(int q=0; q<currentMax;q++) {
                            if(bankAccounts[q].getAccN()==accNIn && bankAccounts[q] instanceof InvestmentAccount && bankAccounts[q].getBal()>withdrawn) {
                                bankAccounts[q].withdraw(withdrawn);
                                System.out.println("Investment account has been withdrawn " + withdrawn + "; New balance is " + bankAccounts[q].getBal());
                                break;
                            } else {throw new Exception("No such account number/type exists, or amount withdrawn exceeds balance.(2)");}
                        }
                    } else if (accTypeIn.matches("regular")){
                        for(int q=0; q<currentMax;q++) {
                            if(bankAccounts[q].getAccN()==accNIn && bankAccounts[q] instanceof BankAccount && bankAccounts[q].getBal()>withdrawn) {
                                bankAccounts[q].withdraw(withdrawn);
                                System.out.println("Regular account has been withdrawn " + withdrawn + "; New balance is " + bankAccounts[q].getBal());
                                break;
                            } else {throw new Exception("No such account number/type exists, or amount withdrawn exceeds balance.(3)");}
                        }
                    } else {throw new Exception("No such account type exists.");}
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (menuAction==4) {
                System.out.println("Please enter the account number:");
                int accNIn = in.nextInt();
                try {
                    for(int q=0; q<currentMax;q++) {
                        if(bankAccounts[q].getAccN()==accNIn && bankAccounts[q] instanceof SavingsAccount) {
                            SavingsAccount instance = (SavingsAccount) bankAccounts[q];
                            double monthlyRate = (instance.getYearlyIR())/12;
                            System.out.println("Savings account monthly rate is " + monthlyRate + "%");
                            break;
                        } else if (q==currentMax-1) {
                            throw new Exception("No such account number/type exists, or amount withdrawn exceeds balance.(1)");
                        } 
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } 
            } else if (menuAction==5) {
                System.out.println("Please enter the account number:");
                int accNIn = in.nextInt();
                try {
                    for(int q=0; q<currentMax;q++) {
                        if(bankAccounts[q].getAccN()==accNIn && bankAccounts[q] instanceof InvestmentAccount) {
                            InvestmentAccount instance = (InvestmentAccount) bankAccounts[q];
                            if (instance.applyRisk()>=instance.getBal()) {
                                System.out.println("Investment account current risk is " + instance.applyRisk() + ", which is a loss.");
                            } else {
                                System.out.println("Investment account current risk is " + instance.applyRisk() + ", which is a profit.");
                            }
                            break;
                        } else if (q==currentMax-1) {
                            throw new Exception("No such account number/type exists, or amount withdrawn exceeds balance.(1)");
                        } 
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (menuAction==6) {
                System.out.println("Listing all accounts:");
                for (int q=0; q<currentMax;q++) {
                    System.out.println("---------------Account " + (q+1) + "---------------\n" + bankAccounts[q].toString() + "\n");
                }
            } else if (menuAction==7) {
                System.out.println("Listing all DUPLICATE accounts:");
                ArrayList<Integer> toPrint = new ArrayList<Integer>();  //I decided to use array lists because it would just work far better in a search
                for (int q =0; q<currentMax;q++) {
                    for (int p=1; p<currentMax;p++) {
                        if (bankAccounts[q].equals(bankAccounts[p])) {
                            if(toPrint.contains(q) || toPrint.contains(p)) {
                                break;
                            }
                            toPrint.add(q);
                            toPrint.add(p);
                        }
                    }
                }
                for (int q = 0; q<toPrint.size();q++) {
                    System.out.println("---------------Account " + (q+1) + "---------------\n" + bankAccounts[toPrint.get(q)].toString() + "\n");
                }
            } else if (menuAction==8) {
                System.out.println("Listing all accounts that meet criterion:");
                ArrayList<Integer> toPrint = new ArrayList<Integer>();  //I decided to use array lists because it would just work far better in a search
                for (int q =0; q<currentMax;q++) {
                    if (bankAccounts[q].accept()) {
                        toPrint.add(q);
                    }
                }
                for (int q = 0; q<toPrint.size();q++) {
                System.out.println("---------------Account " + (q+1) + "---------------\n" + bankAccounts[toPrint.get(q)].toString() + "\n");
                }
            } else if (menuAction==9) {
                java.util.Arrays.sort(bankAccounts,0,currentMax);    //uses sort method from BankAccount to sort 
                System.out.println("Accounts sucessfully sorted!");
            } else if (menuAction==10) {
                quit=true;  //exits the program
                System.out.println("Information saved. Thank you for using the account manager.");
                try {
                    outPrintWriter = new PrintWriter(new FileOutputStream("accounts.txt"));
                    for (int q=0;q<currentMax;q++) {
                        if(bankAccounts[q] instanceof SavingsAccount) {
                            outPrintWriter.println("savings");
                            outPrintWriter.println(bankAccounts[q].getAccN());
                            outPrintWriter.println(bankAccounts[q].getName());
                            outPrintWriter.println(bankAccounts[q].getBal());
                            SavingsAccount instance = (SavingsAccount) bankAccounts[q];
                            outPrintWriter.println(instance.getYearlyIR());
                        } else if (bankAccounts[q] instanceof InvestmentAccount) {
                            outPrintWriter.println("investment");
                            outPrintWriter.println(bankAccounts[q].getAccN());
                            outPrintWriter.println(bankAccounts[q].getName());
                            outPrintWriter.println(bankAccounts[q].getBal());
                            InvestmentAccount instance = (InvestmentAccount) bankAccounts[q];
                            outPrintWriter.println(instance.getAccountType());
                        }
                    }
                    outPrintWriter.close();
                } catch (FileNotFoundException e) {
                    System.out.println("File not found, created one.");
                    file = new File("accounts.txt");
                    for (int q=0;q<currentMax;q++) {
                        if(bankAccounts[q] instanceof SavingsAccount) {
                            outPrintWriter.println("savings");
                            outPrintWriter.println(bankAccounts[q].getAccN());
                            outPrintWriter.println(bankAccounts[q].getName());
                            outPrintWriter.println(bankAccounts[q].getBal());
                            SavingsAccount instance = (SavingsAccount) bankAccounts[q];
                            outPrintWriter.println(instance.getYearlyIR());
                        } else if (bankAccounts[q] instanceof InvestmentAccount) {
                            outPrintWriter.println("investment");
                            outPrintWriter.println(bankAccounts[q].getAccN());
                            outPrintWriter.println(bankAccounts[q].getName());
                            outPrintWriter.println(bankAccounts[q].getBal());
                            InvestmentAccount instance = (InvestmentAccount) bankAccounts[q];
                            outPrintWriter.println(instance.getAccountType());
                        }
                    }
                    outPrintWriter.close();
                }
            } else {
                System.out.println("That is not a menu option");
            }
        }
    }
}