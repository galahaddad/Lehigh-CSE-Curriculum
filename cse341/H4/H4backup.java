import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Ralph Haddad
 * Homework Assignment 4, CSE 341
 */
public class H4backup {
    public static void main(String[] args) throws SQLException, IOException, java.lang.ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        String userId, Password, searchstring, finalSearch;

        System.out.println("Enter userID:");
        userId = in.nextLine();
        System.out.println("Enter password:");
        Password = in.nextLine();

        try (
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",userId,"P868741707");
            Statement s=con.createStatement();
        ) 
        {
            System.out.println("connection successfully made.");
            String q;
            ResultSet result;

            //simple selection of all department names to be compared with the input
            //TODO: make more robust using jdbc instead of array. Refrence JayDeeBeeSea file.
            String [] DepNames = {"math", "comp. sci.", "athletics", "astronomy", "philosophy", "pol. sci.", "mech. eng.", "history", "english", "cybernetics", "finance", "psychology", "geology", "elec. eng.", "management", "physics", "languages", "accounting", "statistics", "music"};
            System.out.println("Enter department name search substring");
            searchstring = in.nextLine().toLowerCase();
            ArrayList<String> resultingDepts = new ArrayList<String>();
            for (int i = 0; i<DepNames.length; i++){
                if (DepNames[i].contains(searchstring)) {
                    resultingDepts.add(DepNames[i]);
                }
            }
            //Prints matching departments
            System.out.println("Here is the list of all matching departments.");
            for (int i=0; i<resultingDepts.size(); i++) {
                System.out.println(resultingDepts.get(i));
            }

            System.out.println("Enter the department whose instructor list you seek.");
            finalSearch = in.nextLine();//.toLowerCase();
            //parses to see if a correct input was made
            q = "select instructor.ID as instructorID, instructor.name as instructorName, student.ID as adviseeID, student.name as adviseeName from instructor, student, advisor where instructor.dept_name='"+ finalSearch + "' and instructor.id=advisor.i_id";
            result = s.executeQuery(q);
            if(!result.next()) System.out.println("Empty result.");
            else {
                int preview = 5; // the size of the table to be previewed by rows
                System.out.println("instructorID instructorName adviseeID adviseeName");
                do {    
                    System.out.println(result.getString("instructorID") + "\t\t" + result.getString("instructorName") + "\t\t" + result.getString("adviseeID") + "\t" + result.getString("adviseeName"));
                    preview--;
                } while (result.next() && preview>=0);
            }
            System.out.println("(plus many lines more that are omitted in this document)");
            s.close();
            con.close();
        }

        catch(SQLException e) {
            System.out.println("Sign in incorrect. Try again.");
        }

    }
}