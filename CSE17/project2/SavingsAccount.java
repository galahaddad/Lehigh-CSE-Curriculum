/**
 * SavingsAccount
 */
public class SavingsAccount extends BankAccount implements Comparable<BankAccount> {
    private double yearlyIR;
    public static double monthlyFee;
    
    public SavingsAccount() {
        super();
        yearlyIR=0;
    }

    public SavingsAccount(String nameString, int accNint, double balDouble, double yearlyIR) {
        super(nameString,accNint,balDouble);
        this.yearlyIR=yearlyIR;
    }

    /**
     * @return the yearlyIR
     */
    public double getYearlyIR() {
        return yearlyIR;
    }

    /**
     * @return the monthlyFee
     */
    public static double getmonthlyFee() {
        return monthlyFee;
    }

    /**
     * @param monthlyFee the monthlyFee to set
     */
    public static void setmonthlyFee(double monthlyFee) {
        SavingsAccount.monthlyFee = monthlyFee;
    }

    /**
     * @param yearlyIR the yearlyIR to set
     */
    public void setYearlyIR(double yearlyIR) {
        this.yearlyIR = yearlyIR;
    }

    public double applyInterestRate() {
        bal+=(bal*(yearlyIR/12))/100;
        return bal;
    }

    public double applyMonthlyFee() {
        bal-=(bal*monthlyFee);
        return bal;
    }

    public String toString() {
        return "Savings account member Name: " + super.getName() + "\nAccount Number: " + super.getAccN() + "\nBalance: $" + bal + "\nYearly Interest: " + yearlyIR + "\nMonthly Rate: " + monthlyFee;
    }
    
}