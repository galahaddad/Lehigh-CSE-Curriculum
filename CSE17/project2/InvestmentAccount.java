import java.math.*;
/**
 * InvestmentAccount
 */
public class InvestmentAccount extends BankAccount implements Comparable<BankAccount> {
    public String accountType;  //type is either: growth, shares, or property

    public InvestmentAccount() {
        super();
        accountType="";
    }

    public InvestmentAccount(String namString, int accN, double balance, String accT) {
        super(namString, accN, balance);
        accountType=accT;
    }

    /**
     * @return the accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double applyRisk() {
        double risk = Math.random();
        double profitLoss = Math.random();
        if (risk>=.5) {
            bal = (bal+(bal*profitLoss));
        } else {
            bal = (bal-(bal*profitLoss));
        }
        return bal*profitLoss;
    }
    
    public String toString() {
        return "Investment account member Name: " + super.getName() + "\nAccount type: " + accountType + "\nAccount Number: " + super.getAccN() + "\nBalance: $" + bal;
    }

}