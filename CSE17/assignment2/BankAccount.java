//Ralph Haddad - Assignment 2 - BankAccount
//Houria CSE17
public class BankAccount {
    private String name;
    private int accN;
    private double bal;
    public static double fee;   //static member to be carried over unchanged
    public BankAccount(){
        name="";
        accN=0;
        bal=0;
    }
    public BankAccount(String nameString, int accNint, double balDouble) {
        name = nameString;
        accN = accNint;
        bal = balDouble;
    }
    //retrieval methods below
    public String getName() {
        return name;   
    }
    public int getAccN() {
        return accN;
    }
    public double getBal() {
        return bal;
    }
    
    //mutator methods below
    public void deposit(double entry) {
        bal += entry;
    }
    public void withdraw(double entry) {
        bal -= entry;
    }
    public void applyFee() {
        bal -= (bal*fee);
    }

    //to string mutator method which returns an orderd set of modified values
    public String toString() {
        return "Member Name: " + name + "\nAccount Number: " + accN + "\nBalance: $" + bal;
    }    
}