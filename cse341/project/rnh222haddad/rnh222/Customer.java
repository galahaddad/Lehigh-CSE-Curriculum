import java.util.Scanner;
import java.lang.Integer;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
public class Customer {
    private String connectionID, connectionPASS;    //SQL Connection Strings
    private String tab, CustomerID, SSN; //current customer menu posititon and customer identifiers
    public Customer() {
        connectionID = "";
        connectionPASS = "";
        tab = "";
        CustomerID = "";
        SSN = "";
    }

    //Getters and setters for the customer interface
    public void setConnection(String c1, String c2) {
        connectionID = c1;
        connectionPASS = c2;
    }
    public void setTab(String newTab){
        tab = newTab;
    }
    public String getTab(){
        return tab;
    }
    public void setIdentifier(String CustomerID, String SSN) {
        this.CustomerID = CustomerID;
        this.SSN = SSN;
    }

    //The customer menu interface. The only modification done is creating a new customer
    public void customerMenu() {
        String input;
        String q;
        ResultSet result;
        //registration or login
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        boolean selection = false;
        do {
            System.out.println("Welcome valued customer! \n1. login \n2. register an account \n3. Return to menu");
            String cusRes = in.nextLine();
            if (cusRes.matches("1")){
                selection = true;
            } else if (cusRes.matches("2")){
                System.out.println("A new customer! Please enter some valued information:");
                registration();
            } else if (cusRes.matches("3")) {
                selection = true;
                exit = true;
            } else {
                System.out.println("Invald selection.");
            }
        } while (selection == false);

        selection = false;
        if (exit==false) {
            do {
                System.out.println("Please enter your 5 digit customer ID:");
                String CustomerID = in.nextLine();
                System.out.println("Please enter your SSN (format: nnn-nn-nnnn):");
                String CustomerSSN = in.nextLine();
                try {
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",connectionID,connectionPASS);
                    Statement s=con.createStatement();
                    q = "select ACCOUNT.ROUTINGNUM as routing, ACCOUNT.BALANCE as balance from CUSTOMER, ACCOUNT where ACCOUNT.ACCOUNTID = '"+ CustomerID +"' and CUSTOMER.SSN = '" + CustomerSSN + "'";
                    result = s.executeQuery(q);
                    System.out.println("Your regular and checkings accounts:");
                    if(!result.next()) {
                        System.out.println("There are no accounts with these inputs.");
                    } else {
                        System.out.printf("%20s\t%20s\n", "Routing Number(s):","Balance:");
                        do {
                            System.out.printf("%20s\t%20s\n", result.getString("routing"), result.getString("balance"));
                        } while (result.next());
                        selection = true; //routing numbers have been found for account at this point
                        //setting identifiers for sucessful customer login
                        setIdentifier(CustomerID,CustomerSSN);
                        //Connection close
                        s.close();
                        con.close();
                    }
                } catch (SQLException e) {
                    System.out.print("SQL Error caught: ");
                    System.out.println(e.getMessage());
                }
                //now to get the checkings accounts
                try {
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",connectionID,connectionPASS);
                    Statement s=con.createStatement();
                    q = "select CHECKINGS.ROUTINGNUM as routing, CHECKINGS.BALANCE as balance, CHECKINGS.MINIMUM as minimum from CUSTOMER, CHECKINGS where CHECKINGS.ACCOUNTID = '"+ CustomerID +"' and CUSTOMER.SSN = '" + CustomerSSN + "'";
                    result = s.executeQuery(q);
                    System.out.println("Your checkings accounts in detail:");
                    if(!result.next()) {
                        System.out.println("Your account has no checkings accounts.");
                    } else {
                        System.out.printf("%20s\t%20s\t%20s\n", "Routing Number(s):","Balance:","Minimum:");
                        do {
                            System.out.printf("%20s\t%20s\t%20s\n", result.getString("routing"), result.getString("balance"), result.getString("minimum"));
                        } while (result.next());
                        selection = true; //routing numbers have been found for account at this point
                        //setting identifiers for sucessful customer login
                        setIdentifier(CustomerID,CustomerSSN);
                        //Connection close
                        s.close();
                        con.close();
                    }
                } catch (SQLException e) {
                    System.out.print("SQL Error caught: ");
                    System.out.println(e.getMessage());
                }
            } while (selection == false);
            //at this point the customer knows what accounts they can access and can select a menu option
            //TODO: add menu options for customer
            customerUpdate();
        }
    }

    //used within the customerMenu method to create a new customer and savings account
    //Not featured: does not create a checkings account, so many features of involving checkings accounts cant be done, like making a new card etc.
    public void registration() {
        Scanner in = new Scanner(System.in);
        boolean selection = false;
        do {
            try {
                //collect necessary information
                System.out.println("First Name:");
                String first = in.nextLine();
                System.out.println("Last Name:");
                String last = in.nextLine();
                System.out.println("Date of birth (dd-MMM-yy, Ex. 11-JAN-89):");
                String dob = in.nextLine();
                System.out.println("Phone Number (do not include spaces):");
                String phone = in.nextLine();
                System.out.println("Gender (M/F):");
                String gender = in.nextLine();
                System.out.println("SSN (000-00-0000):");
                String ssn = in.nextLine();
                //attempt a sql statement
                String input;
                String q;
                ResultSet result;
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",connectionID,connectionPASS);
                Statement s=con.createStatement();
                int randID = (int)((Math.random() * ((99999 - 9999) + 1)) + 9999); //creates a random 5 digit id
                System.out.println("Your ID shall be:" + randID);
                q = "insert into CUSTOMER (ID, FIRST, LAST, DOB, SSN, GENDER, PHONE) values ("+ randID +",'"+ first +"','"+ last +"','"+ dob +"','"+ ssn +"','"+ gender +"','"+ phone +"')";
                result = s.executeQuery(q);
                System.out.println("Customer account sucessfully created. " + first + " welcome to Nickel Bank.");
                System.out.println(first + " how much would you like to deposit into your savings account?:");
                String firstdeposit = in.nextLine();
                int randRN = (int)((Math.random() * ((99999 - 9999) + 1)) + 9999); //creates a random 5 digit id
                q = "insert into ACCOUNT (ACCOUNTID, ROUTINGNUM, BALANCE) values ("+ randID +","+ randRN +","+ firstdeposit +")";
                result = s.executeQuery(q);
                System.out.println("Savings account (Routing Number: "+ randRN +") sucessfully created and deposited $" + firstdeposit);
                selection = true;
                s.close();
                con.close();
                //the customer account is now created
            } catch (SQLException e) {
                System.out.print("SQL Error caught: ");
                System.out.println(e.getMessage());
            }
        } while (selection == false);
    }

    //this menu allows a customer to modify their account
    public void customerUpdate() {
        Scanner in = new Scanner(System.in);
        boolean selection = false;
        System.out.println("What would you like to do? \n1. Savings deposit \t2. Savings withdrawl \t3. Checkings deposit \n4. Checkings withdrawl \t5. Make a payment \t6. New card \n7.New loan \t\t8. Card purchase \t9. Return to menu\n");
        do {
            String cusRes = in.nextLine();
            if (cusRes.matches("9")){ //returns you to the main menu
                selection = true;
            } else if (cusRes.matches("1")){    //savings deposit
                savingsDeposit();
                selection = true;
            } else if (cusRes.matches("2")){    //savings withdrawl
                savingsWithdraw();
                selection = true;
            } else if (cusRes.matches("3")){    //checkings deposit (works the same as savings deposits due to cardinality)
                savingsDeposit();
                selection = true;
            } else if (cusRes.matches("4")){
                checkingsWithdraw();
                selection = true;
            } else if (cusRes.matches("5")){
                payment();
                selection = true;
            } else if (cusRes.matches("6")){
                newCard();
                selection = true;
            } else if (cusRes.matches("7")){
                System.out.println("During the COVID-19 pandemic, Nickel bank is unable to handle new loans due to uncertainty and fear of bank bankruptcy. Thank you :)");
                selection = false;
            } else if (cusRes.matches("8")){
                cardPurchase();
                selection = true;
            } else {
                System.out.println("Invald selection.");
            }
        } while (selection == false);
    }

    public void savingsDeposit() {
        Scanner in = new Scanner(System.in);
        boolean selection = false;
        do {
            try {
                System.out.println("Please select the routing number you wish to deposit to:");
                String account = in.nextLine();
                System.out.println("Please select the amount you wish to deposit:");
                String deposit = in.nextLine();
                String q;
                ResultSet result;
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",connectionID,connectionPASS);
                Statement s=con.createStatement();
                q = "UPDATE ACCOUNT SET BALANCE = BALANCE + ABS("+ deposit +") WHERE ROUTINGNUM = "+ account;
                result = s.executeQuery(q);
                if (!result.next()) {   //the update failed
                    System.out.println("One of your inputs is incorrect, try again.");
                } else {    //the update passed and we create a teller transaction in the background
                    System.out.println("Sucessfully deposited.");
                }
                s.close();
                con.close();
                //tansaction ids of deposits and withdrawls match the routing number modified and picks a random teller to add as a transaction processor
                Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",connectionID,connectionPASS);
                Statement t=con1.createStatement();
                int randID = (int)((Math.random() * ((9999 - 999) + 1)) + 999); //creates a random 4 digit id
                String p = "insert into TRANSACTION (TRANSACTIONID, AMOUNT, DATEOFTRANSACTION, COMID) values ("+ randID +","+ deposit +",(select to_char(SYSDATE, 'dd.mm.yyyy')from dual),(SELECT * FROM (SELECT  TELLER.TELLERID FROM TELLER ORDER BY dbms_random.value)WHERE rownum <= 1))";
                ResultSet result2 = t.executeQuery(p);
                if (!result2.next()) {   //the update failed
                    System.out.println("Transaction failed.");
                } else {    //the update passed and we create a teller transaction in the background
                    System.out.println("Transaction saved. Your transaction was sucessfully handled by one of our Tellers.");
                    selection = true;
                }
                t.close();
                con1.close();
            } catch (SQLException e) {
                System.out.print("SQL Error caught: ");
                System.out.println(e.getMessage());
            }
        } while (selection==false);
        customerUpdate();   //returns to the update menu
    }

    public void savingsWithdraw() {
        Scanner in = new Scanner(System.in);
        boolean selection = false;
        do {
            try {
                System.out.println("Please select the routing number you wish to withdraw from:");
                String account = in.nextLine();
                System.out.println("Please select the amount you wish to withdraw:");
                String withdraw = in.nextLine();
                String q;
                ResultSet result;
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",connectionID,connectionPASS);
                Statement s=con.createStatement();
                q = "UPDATE ACCOUNT SET BALANCE = BALANCE - "+ withdraw +" WHERE ROUTINGNUM = "+ account +" AND BALANCE - MINIMUM - "+ withdraw +" >=0";
                result = s.executeQuery(q);
                if (!result.next()) {   //the update failed
                    System.out.println("Either your input is incorrect or you overdrew from your savings account, which is not allowed.");
                } else {    //the update passed and we create a teller transaction in the background
                    System.out.println("Sucessfully withdrawn.");
                    //tansaction ids of deposits and withdrawls match the routing number modified and picks a random teller to add as a transaction processor
                    Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",connectionID,connectionPASS);
                    Statement t=con1.createStatement();
                    int randID = (int)((Math.random() * ((9999 - 999) + 1)) + 999); //creates a random 4 digit id
                    String p = "insert into TRANSACTION (TRANSACTIONID, AMOUNT, DATEOFTRANSACTION, COMID) values ("+ randID +", -"+ withdraw +",(select to_char(SYSDATE, 'dd.mm.yyyy')from dual),(SELECT * FROM (SELECT  TELLER.TELLERID FROM TELLER ORDER BY dbms_random.value)WHERE rownum <= 1))";
                    ResultSet result2 = t.executeQuery(p);
                    if (!result2.next()) {   //the update failed
                        System.out.println("Transaction failed.");
                    } else {    //the update passed and we create a teller transaction in the background
                        System.out.println("Transaction saved. Your transaction was sucessfully handled by one of our Tellers.");
                        selection = true;
                    }
                    t.close();
                    con1.close();
                }
                s.close();
                con.close();
            } catch (SQLException e) {
                System.out.print("SQL Error caught: ");
                System.out.println(e.getMessage());
            }
        } while (selection==false);
        customerUpdate();   //returns to the update menu
    }

    //withdrawl from a checkings account does the same as a savings account but creates an $50 overdraft charge if overdrawn past the minimum
    public void checkingsWithdraw() {
        Scanner in = new Scanner(System.in);
        boolean selection = false;
        do {
            try {
                System.out.println("Please select the checkings routing number you wish to withdraw from:");
                String account = in.nextLine();
                System.out.println("Please select the amount you wish to withdraw:");
                String withdraw = in.nextLine();
                String q;
                ResultSet result;
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",connectionID,connectionPASS);
                Statement s=con.createStatement();
                q = "UPDATE CHECKINGS SET BALANCE = BALANCE - "+ withdraw +" WHERE ROUTINGNUM = "+ account + "AND BALANCE - "+ withdraw +" >=0";
                result = s.executeQuery(q);
                if (!result.next()) {   //the update failed
                    System.out.println("Your input has returned no results or you are withdrawing beyond your balance.");
                } else {    //the update passed and we create a teller transaction in the background
                    System.out.println("Sucessfully withdrawn.");
                    String e = "UPDATE CHECKINGS SET BALANCE = BALANCE - 50 WHERE ROUTINGNUM = "+ account + " AND BALANCE <= MINIMUM";
                    ResultSet resulti;
                    resulti = s.executeQuery(e);
                    if (resulti.next()) {
                        System.out.println("Your account has been overdrawn past its minimum and you have been penalized $50");
                    }
                    //tansaction ids of deposits and withdrawls picks a random teller to add as a transaction processor
                    Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",connectionID,connectionPASS);
                    Statement t=con1.createStatement();
                    int randID = (int)((Math.random() * ((9999 - 999) + 1)) + 999); //creates a random 4 digit id
                    String p = "insert into TRANSACTION (TRANSACTIONID, AMOUNT, DATEOFTRANSACTION, COMID) values ("+ randID +", -"+ withdraw +",(select to_char(SYSDATE, 'dd.mm.yyyy')from dual),(SELECT * FROM (SELECT  TELLER.TELLERID FROM TELLER ORDER BY dbms_random.value)WHERE rownum <= 1))";
                    ResultSet result2 = t.executeQuery(p);
                    if (!result2.next()) {   //the update failed
                        System.out.println("Transaction failed.");
                    } else {    //the update passed and we create a teller transaction in the background
                        System.out.println("Transaction saved. Your transaction was sucessfully handled by one of our Tellers.");
                        selection = true;
                    }
                    t.close();
                    con1.close();
                }
                s.close();
                con.close();
            } catch (SQLException e) {
                System.out.print("SQL Error caught: ");
                System.out.println(e.getMessage());
            }
        } while (selection==false);
        customerUpdate();   //returns to the update menu
    }

    //covers customer loanpayments and card payments
    public void payment() {
        Scanner in = new Scanner(System.in);
        boolean selection = false;
        do {
            System.out.println("What sort of payment will be made?\n1. Loan Payment\n2. Card Payment");
            String input = in.nextLine();
            if (input.matches("1")) {
                System.out.println("Here are all loans and morgages made in your name:");
                try {
                    ResultSet result;
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",connectionID,connectionPASS);
                    Statement s=con.createStatement();
                    String q = "select unique LOAN.LOANID, LOAN.AMOUNT, LOAN.INTEREST, LOAN.MONTHLY_PAYMENT from CUSTOMER, LOAN where LOAN.SIGNED = "+ CustomerID;
                    result = s.executeQuery(q);
                    System.out.println("Your Loans and Morgages:");
                    if(!result.next()) {
                        System.out.println("Your account has no loans.");
                    } else {
                        System.out.printf("%30s\t%30s\t%30s\t%30s\n", "Loan ID:","Amount Left:","Interest:","Minimum Monthly Payment:");
                        do {
                            System.out.printf("%30s\t%30s\t%30s\t%30s\n", result.getString("LOANID"), result.getString("AMOUNT"), result.getString("INTEREST"), result.getString("MONTHLY_PAYMENT"));
                        } while (result.next()); 
                        //Connection close
                        s.close();
                        con.close();
                    }
                    Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",connectionID,connectionPASS);
                    Statement t=con1.createStatement();
                    String p = "select unique MORGAGE.LOANID, MORGAGE.AMOUNT, MORGAGE.INTEREST, MORGAGE.MONTHLY_PAYMENT, MORGAGE.SECURITY from CUSTOMER, MORGAGE where MORGAGE.SIGNED = " + CustomerID;
                    ResultSet resultm = t.executeQuery(p);
                    System.out.println("Your morgage accounts in detail:");
                    if(!resultm.next()) {
                        System.out.println("Your account has no morgages.");
                    } else {
                        System.out.printf("%30s\t%30s\t%30s\t%30s\t%30s\n", "Loan ID:","Amount Left:","Interest:","Minimum Monthly Payment:","Security:");
                        do {
                            System.out.printf("%30s\t%30s\t%30s\t%30s\t%30s\n", resultm.getString("LOANID"), resultm.getString("AMOUNT"), resultm.getString("INTEREST"), resultm.getString("MONTHLY_PAYMENT"), resultm.getString("SECURITY"));
                        } while (resultm.next());
                        //Connection close
                        t.close();
                        con1.close();
                    }
                    //Views of loans inserted
                } catch (SQLException e) {
                    System.out.print("SQL Error caught: ");
                    System.out.println(e.getMessage());
                }
                //now to pay a loan :,(
                boolean execution = false;
                do {
                    try {
                        System.out.println("Which loan would you like to pay? (Select by loan id):");
                        String loanid = in.nextLine();
                        System.out.println("How much will you pay? (Note: payments exceeding what is due will be rejected):");
                        String lpayamt = in.nextLine();
                        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",connectionID,connectionPASS);
                        Statement s = con.createStatement();
                        //query to accept a payment which does not exceed what is due and is only for the logged in customer
                        String q = "UPDATE LOAN SET AMOUNT = AMOUNT - "+ lpayamt +" WHERE SIGNED = "+ CustomerID + " AND LOANID = "+ loanid +" AND MONTHLY_PAYMENT <= " + lpayamt;
                        ResultSet result = s.executeQuery(q);
                        if (!result.next()) {
                            System.out.println("Either you overpaid your loan past what is due or your loan id number was input incorrectly");
                        } else {
                            System.out.println("Your payment was updated sucessfully, initializing transaction log...");
                            //creating a cardpayment transaction, beginning with the transaction relation with the routing number
                            int randID = (int)((Math.random() * ((9999 - 999) + 1)) + 999); //creates a random 4 digit id
                            String p = "insert into TRANSACTION (TRANSACTIONID, AMOUNT, DATEOFTRANSACTION, COMID) values ("+ randID +", "+ lpayamt +",(select to_char(SYSDATE, 'dd.mm.yyyy')from dual),(SELECT * FROM (SELECT  TELLER.TELLERID FROM TELLER ORDER BY dbms_random.value)WHERE rownum <= 1))";
                            ResultSet result2 = s.executeQuery(p);
                            if (!result2.next()) {
                                System.out.println("Either you overpaid your card past what was due or your card number was input incorrectly");    //should never be reached
                            } else {
                                System.out.println("Transaction created sucessfully...");
                                //insert the card payment
                                int randID2 = (int)((Math.random() * ((9999 - 999) + 1)) + 999); //creates a random 4 digit id
                                String r = "insert into LOANPAYMENT (TRANSACTIONID, AMOUNT, DATEOFTRANSACTION, LOANPAYMENTID, LOANID) values ("+ randID +", "+ lpayamt +",(select to_char(SYSDATE, 'dd.mm.yyyy')from dual),"+ randID2 +","+ loanid +")";
                                ResultSet result3 = s.executeQuery(r);
                                if (!result3.next()) {
                                    System.out.println("Either you overpaid your card past what was due or your card number was input incorrectly");    //should never be reached
                                } else {
                                    System.out.println("Loan payment complete!");
                                }
                            }
                        }
                        s.close();
                        con.close();
                    } catch (SQLException e) {
                        System.out.print("SQL Error caught: ");
                        System.out.println(e.getMessage());
                    }
                } while (execution = false);

                System.out.println("Loan payment executed, returning to customer menu.");

            } else if (input.matches("2")) {    // ~~~~~~~~~~~~~~~~~~~~~Card Payment
                
                try {
                    //Prints out the credit cards for this customer
                    Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",connectionID,connectionPASS);
                    Statement t=con1.createStatement();
                    String p = "select CREDIT.CARDID, CREDIT.CARDNUMBER, CREDIT.EXPIRATION, CREDIT.INTEREST, CREDIT.LIMIT, CREDIT.BALANCE from CREDIT where CREDIT.CARDID = (select CHECKINGS.ROUTINGNUM from CHECKINGS where ACCOUNTID = " + CustomerID + ")";
                    ResultSet resultm = t.executeQuery(p);
                    System.out.println("Your credit cards in detail:");
                    if(!resultm.next()) {
                        System.out.println("Your account has no credit cards.");
                    } else {
                        System.out.printf("%30s\t%30s\t%30s\t%30s\t%30s\t%30s\n", "Card ID:","Card Number:","Expiration:","Interest","Limit","Balance");
                        do {
                            System.out.printf("%30s\t%30s\t%30s\t%30s\t%30s\t%30s\n", resultm.getString("CARDID"), resultm.getString("CARDNUMBER"), resultm.getString("EXPIRATION"), resultm.getString("INTEREST"), resultm.getString("LIMIT"), resultm.getString("BALANCE"));
                        } while (resultm.next());
                        //Connection close
                        t.close();
                        con1.close();
                    }
                    //Views of cards inserted
                } catch (SQLException e) {
                    System.out.print("SQL Error caught: ");
                    System.out.println(e.getMessage());
                }
                //now to pay a card :,(
                boolean execution = false;
                do {
                    try {
                        System.out.println("Which credit card would you like to pay? (Select by card number):");
                        String cardnumber = in.nextLine();
                        System.out.println("How much will you pay off the card:");
                        String cardpayamt = in.nextLine();
                        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",connectionID,connectionPASS);
                        Statement s = con.createStatement();
                        //query to accept a payment which does not exceed what is due and is only for the logged in customer
                        String q = "UPDATE CREDIT SET BALANCE = BALANCE - "+cardpayamt+" WHERE CARDNUMBER = "+ cardnumber + " AND BALANCE - "+cardpayamt+" >=0 AND CREDIT.CARDID = (select CHECKINGS.ROUTINGNUM from CHECKINGS where ACCOUNTID = " + CustomerID + ")";
                        ResultSet result = s.executeQuery(q);
                        if (!result.next()) {
                            System.out.println("Either you overpaid your card past what was due or your card number was input incorrectly");
                        } else {
                            System.out.println("Your payment was updated sucessfully, initializing transaction log...");
                            //creating a cardpayment transaction, beginning with the transaction relation with the routing number
                            int randID = (int)((Math.random() * ((9999 - 999) + 1)) + 999); //creates a random 4 digit id
                            String p = "insert into TRANSACTION (TRANSACTIONID, AMOUNT, DATEOFTRANSACTION, COMID) values ("+ randID +", "+ cardpayamt +",(select to_char(SYSDATE, 'dd.mm.yyyy')from dual),(SELECT * FROM (SELECT  TELLER.TELLERID FROM TELLER ORDER BY dbms_random.value)WHERE rownum <= 1))";
                            ResultSet result2 = s.executeQuery(p);
                            if (!result2.next()) {
                                System.out.println("Either you overpaid your card past what was due or your card number was input incorrectly");    //should never be reached
                            } else {
                                System.out.println("Transaction created sucessfully...");
                                //insert the card payment
                                String r = "insert into CARDPAYMENT (TRANSACTIONID, AMOUNT, TRANSACTIONDATE, CPID) values ("+ randID +", "+ cardpayamt +",(select to_char(SYSDATE, 'dd.mm.yyyy')from dual), "+cardnumber+")";
                                ResultSet result3 = s.executeQuery(r);
                                if (!result3.next()) {
                                    System.out.println("Either you overpaid your card past what was due or your card number was input incorrectly");    //should never be reached
                                } else {
                                    System.out.println("Card payment complete!");
                                }
                            }
                        }
                        s.close();
                        con.close();
                    } catch (SQLException e) {
                        System.out.print("SQL Error caught: ");
                        System.out.println(e.getMessage());
                    }
                } while (execution = false);    
                System.out.println("Returining to customer menu");    
            } else {
                System.out.println("That is not a selection.");
            }

        } while (selection = false);
        customerUpdate();   //return to the customer update menu
    }

    //creates a new 16 digit card bound to the customer's checkings account routing number. The expiration date is 2 years from the date of creation.
    //if the new card is a credit card, we allow the user to set his own interest and credit limit because we are a terrible business.
    public void newCard() { 
        Scanner in = new Scanner(System.in);
        boolean execution = false;
        do {
            System.out.println("A new card eh? Let's get you setup. What kind of card are you looking for?\n1. New debit card\t2. New credit card");
            String choice = in.nextLine();
            if (choice.matches("2")) {
                System.out.println("Please select a checkings account routing number from above to link to this card:");
                String checkingsi = in.nextLine();
                try {
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",connectionID,connectionPASS);
                    Statement s = con.createStatement();
                    boolean selection = false;
                    String i = "(select round(DBMS_RANDOM.value(999999999999999, 9999999999999999))as num from dual)";
                    ResultSet resulti = s.executeQuery(i);
                    if (!resulti.next()) {
                        System.out.println("Should never reach here");
                    }
                    String randomid = resulti.getString("NUM");
                    //query to accept a payment which does not exceed what is due and is only for the logged in customer
                    //long randID = (long)((Math.random() * ((99999999999999 - 9999999999999) + 1)) + 9999999999999); //creates a random 14 digit id
                    String q = "insert into CARD (CARDID, CARDNUMBER, EXPIRATION) values ((select CHECKINGS.ROUTINGNUM from CHECKINGS where ACCOUNTID = "+ CustomerID +"), "+ randomid +" , add_months((select to_date(SYSDATE, 'dd.mm.yyyy')from dual), 24))";
                    ResultSet result = s.executeQuery(q);
                    if (!result.next()) {
                        System.out.println("Either your account has no checkings accounts or you entered a checkings account that does not belong to you.");
                    } else {
                        System.out.println("Your card has sucessfully been made!");
                        System.out.println("Modifying your card as a credit card.");
                        //creating a cardpayment transaction, beginning with the transaction relation with the routing number
                        int randLim = (int)((Math.random() * ((99999 - 9999) + 1)) + 9999); //creates a random 5 digit credit limit
                        int randInt = (int)((Math.random() * ((20 - 1) + 1)) + 1); //creates a random  digit credit interest between 1-20%
                        System.out.println("You have been approved for a credit card with a credit limit of "+randLim+" and an interest rate of "+randInt+"%!");
                        String p = "insert into CREDIT (CARDID, CARDNUMBER, EXPIRATION, LIMIT, INTEREST, BALANCE) values ((select CHECKINGS.ROUTINGNUM from CHECKINGS where ACCOUNTID = "+ CustomerID +"), "+randomid+" , add_months((select to_date(SYSDATE, 'dd.mm.yyyy')from dual), 24), "+randLim+", "+randInt+", 0)";
                        ResultSet result2 = s.executeQuery(p);
                        if (!result2.next()) {
                            System.out.println("This condition should never show up on the interface");    //should never be reached
                        } else {
                            System.out.println("Your credit card has been processed. Thank you!");
                            execution = true;
                        }
                    }
                    s.close();
                    con.close();
                } catch (SQLException e) {
                    System.out.print("SQL Error caught: ");
                    System.out.println(e.getMessage());
                }
                execution = true;
            } else if (choice.matches("1")) {
                System.out.println("Please select a checkings account routing number from above to link to this card:");
                String checkingsj = in.nextLine();
                try {
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",connectionID,connectionPASS);
                    Statement s = con.createStatement();
                    boolean selection = false;
                    //query to accept a payment which does not exceed what is due and is only for the logged in customer
                    //long randID = (long)((Math.random() * ((99999999999999 - 9999999999999) + 1)) + 9999999999999); //creates a random 14 digit id
                    String q = "insert into CARD (CARDID, CARDNUMBER, EXPIRATION) values ((select CHECKINGS.ROUTINGNUM from CHECKINGS where ACCOUNTID = "+ CustomerID +"), DBMS_RANDOM.VALUE(99999999999999 IN NUMBER, 999999999999999 IN NUMBER) RETURN NUMBER , add_months((select to_date(SYSDATE, 'dd.mm.yyyy')from dual), 24))";
                    ResultSet result = s.executeQuery(q);
                    if (!result.next()) {
                        System.out.println("Either your account has no checkings accounts or you entered a checkings account that does not belong to you.");
                    } else {
                        System.out.println("Your card has sucessfully been made!");
                    }
                    s.close();
                    con.close();
                } catch (SQLException e) {
                    System.out.print("SQL Error caught: ");
                    System.out.println(e.getMessage());
                }
                execution = true;
            } else {
                System.out.println("Invalid selection.");
            }
            
            
        } while (execution = false); 
        customerUpdate();  
    }

    public void cardPurchase() {
        Scanner in = new Scanner(System.in);
        boolean execution = false;
        System.out.println("Proceeding with card purchase...");
        do {
            try {
                Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",connectionID,connectionPASS);
                Statement t=con1.createStatement();
                String q = "select CARD.CARDID, CARD.CARDNUMBER, CARD.EXPIRATION from CARD where CARD.CARDID = (select CHECKINGS.ROUTINGNUM from CHECKINGS where ACCOUNTID = " + CustomerID + ")";
                ResultSet resultn = t.executeQuery(q);
                if(!resultn.next()) {
                    System.out.println("No cards on this account");
                } else {
                    System.out.println("Your credit/debit cards:");
                    System.out.printf("%30s\t%30s\t%30s\n", "Card ID:","Card Number:","Expiration:");
                    do {
                        System.out.printf("%30s\t%30s\t%30s\n", resultn.getString("CARDID"), resultn.getString("CARDNUMBER"), resultn.getString("EXPIRATION"));
                    } while (resultn.next());
                    String p = "select CREDIT.CARDID, CREDIT.CARDNUMBER, CREDIT.EXPIRATION, CREDIT.INTEREST, CREDIT.LIMIT, CREDIT.BALANCE from CREDIT where CREDIT.CARDID = (select CHECKINGS.ROUTINGNUM from CHECKINGS where ACCOUNTID = " + CustomerID + ")";
                    ResultSet resultm = t.executeQuery(p);
                    System.out.println("Your credit cards in detail:");
                    if(!resultm.next()) {
                        System.out.println("Your account has no credit cards.");
                    } else {
                        System.out.printf("%30s\t%30s\t%30s\t%30s\t%30s\t%30s\n", "Card ID:","Card Number:","Expiration:","Interest","Limit","Balance");
                        do {
                            System.out.printf("%30s\t%30s\t%30s\t%30s\t%30s\t%30s\n", resultm.getString("CARDID"), resultm.getString("CARDNUMBER"), resultm.getString("EXPIRATION"), resultm.getString("INTEREST"), resultm.getString("LIMIT"), resultm.getString("BALANCE"));
                        } while (resultm.next());
                    }
                    boolean choiceb = false;
                    do {
                        System.out.println("How will the purchase be done?\n1. debit card\t2. credit card");
                        String choice = in.nextLine();
                        System.out.println("Which card number will you use?:");
                        String cardnum = in.nextLine();
                        System.out.println("What is the amount of the purchase:");
                        String price = in.nextLine();
                        System.out.println("What is the vendor's name:");
                        String vendorname = in.nextLine();
                        System.out.println("What is the vendor's ID:");
                        String vendorID = in.nextLine();
                        if (choice.matches("1")) {
                            String r = "update CHECKINGS set balance = balance - ABS("+price+") where routingnum = (select CARDID from CARD where CARDNUMBER = "+cardnum+") and balance - ABS("+price+") >= 0";
                            ResultSet resultdebit = t.executeQuery(r);
                            if(!resultdebit.next()) {
                                System.out.println("You either inserted an incorrect debit card ID or you overdrew from the balance");
                            } else {
                                System.out.println("Purchase sucessful. Creating a transaction log.");
                                int randID = (int)((Math.random() * ((9999 - 999) + 1)) + 999); //creates a random 4 digit id
                                String k = "insert into TRANSACTION (TRANSACTIONID, AMOUNT, DATEOFTRANSACTION, COMID) values ("+ randID +", "+ price +",(select to_char(SYSDATE, 'dd.mm.yyyy')from dual), "+cardnum+")";
                                ResultSet result2 = t.executeQuery(k);
                                if (!result2.next()) {
                                    System.out.println("This message should not be reached. (Within cardpurchase debit)");    //should never be reached
                                } else {
                                    System.out.println("Processing purchase...");
                                    //int randIDvendor = (int)((Math.random() * ((9999 - 999) + 1)) + 999); //creates a random 4 digit id
                                    String o = "insert into PURCHASE (TRANSACTIONID, AMOUNT, TRANSACTIONDATE, VENDORID, VENDORNAME, PURCHASEID) values ("+ randID +", "+ price +",(select to_char(SYSDATE, 'dd.mm.yyyy')from dual), "+vendorID+", '"+vendorname+"', (select CARDID from CARD where CARDNUMBER = "+cardnum+"))";
                                    ResultSet result3 = t.executeQuery(o);
                                    if (!result3.next()) {
                                        System.out.println("This message should not be reached. (Within cardpurchase debit)");    //should never be reached
                                    } else {
                                        System.out.println("Your debit purchase has been processed!");
                                        execution = true;
                                        choiceb = true;
                                    }
                                }
                            }
                            choiceb = true;
                        } else if (choice.matches("2")) {
                            //we have a card number
                            String n = "update CREDIT set balance = balance + ABS("+price+") where CARDNUMBER = "+cardnum+" and balance + ABS("+price+") <= limit";
                            ResultSet resultcredit = t.executeQuery(n);
                            if(!resultcredit.next()) {
                                System.out.println("You either inserted an incorrect credit card ID or you are exceeding the credit limit");
                            } else {
                                System.out.println("Purchase sucessful. Creating a transaction log.");
                                int randID = (int)((Math.random() * ((9999 - 999) + 1)) + 999); //creates a random 4 digit id
                                String l = "insert into TRANSACTION (TRANSACTIONID, AMOUNT, DATEOFTRANSACTION, COMID) values ("+ randID +", "+ price +",(select to_char(SYSDATE, 'dd.mm.yyyy')from dual), "+cardnum+")";
                                ResultSet result4 = t.executeQuery(l);
                                if (!result4.next()) {
                                    System.out.println("This message should not be reached. (Within cardpurchase debit)");    //should never be reached
                                } else {
                                    System.out.println("Processing purchase...");
                                    //int randIDvendor = (int)((Math.random() * ((9999 - 999) + 1)) + 999); //creates a random 4 digit id
                                    String o = "insert into PURCHASE (TRANSACTIONID, AMOUNT, TRANSACTIONDATE, VENDORID, VENDORNAME, PURCHASEID) values ("+ randID +", "+ price +",(select to_char(SYSDATE, 'dd.mm.yyyy')from dual), "+vendorID+", '"+vendorname+"', (select CARDID from CARD where CARDNUMBER = "+cardnum+"))";
                                    ResultSet result5 = t.executeQuery(o);
                                    if (!result5.next()) {
                                        System.out.println("This message should not be reached. (Within cardpurchase debit)");    //should never be reached
                                    } else {
                                        System.out.println("Your credit purchase has been processed!");
                                        execution = true;
                                        choiceb = true;
                                    }
                                }
                            }
                        } else {
                            System.out.println("incorrect input.");
                        }

                    } while (choiceb = false);
                    
                }
                t.close();
                con1.close();
                //Views of cards inserted
            } catch (SQLException e) {
                System.out.print("SQL Error caught: ");
                System.out.println(e.getMessage());
            }
        } while (execution == false);
        customerUpdate();
    }
    //this is the end of the customer class
}