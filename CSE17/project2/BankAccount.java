/**
 * @author Ralph Haddad
 * BankAccount Program - Ralph Haddad -CSE17
 * Programming Project 2
 */
public class BankAccount implements Comparable<BankAccount> {
    private String name;
    private int accN;
    protected double bal;
    public static double fee;   //static member to be carried over unchanged
    public static double criterion;
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
    /**
     * @return the name
     */
    public String getName() {
        return name;   
    }
    /**
     * @return the account number
     */
    public int getAccN() {
        return accN;
    }
    /**
     * @return the balance
     */
    public double getBal() {
        return bal;
    }
    
    //mutator methods below
    /**
     * @param bal the new balance
     */
    public void deposit(double entry) {
        bal += entry;
    }
    /**
     * @param bal the new balance
     */
    public void withdraw(double entry) {
        bal -= entry;
    }
    /**
     * @param bal the new balance
     */
    public void applyFee() {
        bal -= (bal*fee);
    }

    //to string mutator method which returns an orderd set of modified values
    public String toString() {
        return "Bank account member Name: " + name + "\nAccount Number: " + accN + "\nBalance: $" + bal;
    }  
    
    /**
     * Compares two bank account classes for the same account number
     * @param b the other account to be compared
     * @return true if they are the same accounts
     */
    public boolean equals(BankAccount b) {
        if (this.accN==b.getAccN()) {
            return true;
        }
        return false;
    }

    /**
     * @return the account with the highest balance
     * 0 if the two are equal
     * -1 if the second account is greater
     * 1 if the first account is greater
     */
    public int compareTo(BankAccount bankAccount) {
        if (getBal()==bankAccount.getBal()) return 0;
        else if (getBal() > bankAccount.getBal()) return 1;
        else return -1;
    }

    public boolean accept() {
        if (criterion<getBal()) return true;
        return false;
    }
    
}