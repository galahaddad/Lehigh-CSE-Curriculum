import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
@author Ralph Haddad
CSE 341 Nickel Bank Project, Professor Hank Korth
This is the main file of the interface
 */
 public class project {
    public static void main(String[] args) throws SQLException, IOException, java.lang.ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        String userID, Password, searchstring, finalSearch;
        boolean logincase = false;
        do {
            System.out.println("Enter userID:");
            userID = in.nextLine();
            System.out.println("Enter password:");
            Password = in.nextLine();
            try {
                //creates a test connection to ensure values are correct
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",userID,Password);
                Statement s=con.createStatement();
                //parse is complete after this point, where an error would have been caught
                //allows acess to proceed
                logincase=true;
                //closes the test connection
                s.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Connect Error. Re-enter login data.");
                logincase=false;
            }
        } while (logincase==false);
        System.out.println("Connection complete."); //~~~~~~~~~~~~~~Connection Sucess Checkpoint~~~~~~~~~~~~~~~
        //Creates actual connection
        try (
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",userID,Password);
            Statement s=con.createStatement();
        )
        {
            System.out.println("$$\\   $$\\ $$\\           $$\\                 $$\\       $$$$$$$\\                      $$\\             ");
            System.out.println("$$$\\  $$ |\\__|          $$ |                $$ |      $$  __$$\\                     $$ |            ");
            System.out.println("$$$$\\ $$ |$$\\  $$$$$$$\\ $$ |  $$\\  $$$$$$\\  $$ |      $$ |  $$ | $$$$$$\\  $$$$$$$\\  $$ |  $$\\       ");
            System.out.println("$$ $$\\$$ |$$ |$$  _____|$$ | $$  |$$  __$$\\ $$ |      $$$$$$$\\ | \\____$$\\ $$  __$$\\ $$ | $$  |      ");
            System.out.println("$$ \\$$$$ |$$ |$$ /      $$$$$$  / $$$$$$$$ |$$ |      $$  __$$\\  $$$$$$$ |$$ |  $$ |$$$$$$  /       ");
            System.out.println("$$ |\\$$$ |$$ |$$ |      $$  _$$<  $$   ____|$$ |      $$ |  $$ |$$  __$$ |$$ |  $$ |$$  _$$<        ");
            System.out.println("$$ | \\$$ |$$ |\\$$$$$$$\\ $$ | \\$$\\ \\$$$$$$$\\ $$ |      $$$$$$$  |\\$$$$$$$ |$$ |  $$ |$$ | \\$$\\       ");
            System.out.println("\\__|  \\__|\\__| \\_______|\\__|  \\__| \\_______|\\__|      \\_______/  \\_______|\\__|  \\__|\\__|  \\__|      \n");
            boolean exit = false;
            do {
                if (menuSelect(userID,Password)) {
                    exit = true;
                }
            } while (exit == false);
            //Connection close
            s.close();
            con.close();
        } catch (SQLException e) {
            System.out.print("SQL Error caught: ");
            System.out.println(e.getMessage());
        }
    }   
 
    private static boolean menuSelect(String userID, String Password) {
        Scanner in = new Scanner(System.in);
        boolean selection = false;
        String input;
        do {
            System.out.println("Select a menu option:");
            System.out.println("1. Customer\n2. Bank Manager\n3. Exit");
            input = in.nextLine();
            if (input.equals("1") || input.equals("2") || input.equals("3")) {
                selection = true;
            } else {
                System.out.println("That input is invalid, try again.");
            }
        } while (selection == false);
        if (input.equals("1")) {
            Customer customer = new Customer();
            customer.setConnection(userID,Password);
            customer.customerMenu();
        } else if (input.equals("2")) {
            System.out.println("Unfortunately due to COVID-19, federal regulation has forced us to work from home\n\tthankfully we have merged all interfaces into the customer menu for remote acess :)");
            //this is merely a joke, given more time and things were less hectic I would have useful teller and atm rankings on frequency and magnitude of money being moved in a given time
        } else if (input.equals("3")) {
            return true;
        }
        return false; 
    }
}