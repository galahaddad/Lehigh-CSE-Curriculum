import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Ralph Haddad
 * Homework Assignment 4, CSE 341
 */
public class Advlist {
    public static void main(String[] args) throws SQLException, IOException, java.lang.ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        String userId, Password, searchstring, finalSearch;
        boolean logincase = false;
        
        do {
            System.out.println("Enter userID:");
            userId = in.nextLine();
            System.out.println("Enter password:");
            Password = in.nextLine();
            try {
                //creates a test connection to ensure values are correct
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",userId,Password);
                Statement s=con.createStatement();
                //parse is complete after this point, where an error would have been caught
                //allows acess to proceed
                logincase=true;
                //closes the test connection
                s.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Connect Error. Re-enter login data.");
                System.out.println(e.getMessage());
                logincase=false;
            }
        } while (logincase==false);
        
        //enacts real connection
        try (
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241",userId,"P868741707");
            Statement s=con.createStatement();
        ) 
        {
            System.out.println("connection successfully made.");
            String q;
            ResultSet result;

            //simple selection of all department names to be compared with the input
            ArrayList<String> all_db_depts = new ArrayList<String>();
            q = "select dept_name from department";
            result = s.executeQuery(q);
            if(!result.next()) {
                System.out.println("There are no departments in this database");
            } else {
                do {
                    all_db_depts.add(result.getString("dept_name").toLowerCase());
                } while (result.next());
            }
            //for (int i=0; i<all_db_depts.size();i++) {
            //    System.out.println(all_db_depts.get(i));
            //}
            //String [] DepNames = {"math", "comp. sci.", "athletics", "astronomy", "philosophy", "pol. sci.", "mech. eng.", "history", "english", "cybernetics", "finance", "psychology", "geology", "elec. eng.", "management", "physics", "languages", "accounting", "statistics", "music"};
            ArrayList<String> resultingDepts = new ArrayList<String>();
            boolean substringCP = false;    //substring checkpoint
            do {
                System.out.println("Enter department name search substring");
                searchstring = in.nextLine();
                q = "select dept_name from department where dept_name like '%" + searchstring + "%'";
                result = s.executeQuery(q);
                if(!result.next()) {
                    System.out.println("There are no department names under such selection. Try again.");
                } else {
                    do {
                        resultingDepts.add(result.getString("dept_name"));
                    } while (result.next());
                    //Prints matching departments
                    System.out.println("Here is the list of all matching departments.");
                    for (int i=0; i<resultingDepts.size(); i++) {
                        System.out.println(resultingDepts.get(i));
                    }
                    substringCP=true;
                }
            } while (substringCP==false);

            boolean finSearchBool = false;  //ensures at least one selection is made
            do {
                System.out.print("Enter the department whose instructor list you seek (Case Sensitive):");
                finalSearch = in.nextLine();//.toLowerCase();
                //parses to see if a correct input was made
                q = "select lpad(instructor.id,5,0) as instructorID, instructor.name as instructorName, lpad(student.id,5,0) as adviseeID, student.name as adviseeName from (select id, name from instructor where dept_name='"+finalSearch+"') instructor, student, advisor where instructor.id=advisor.i_id and student.id=advisor.s_id order by instructorID, adviseeID";
                result = s.executeQuery(q);
                if(!result.next()){ 
                    System.out.println("Empty result. This department has no instructors.\n"); 
                } else {
                    int preview = 5; // the size of the table to be previewed by rows
                    System.out.printf("%-20s\t%-20s\t%-20s\t%-20s\n", "instructorID", "instructorName", "adviseeID", "adviseeName");
                    do {   
                        System.out.printf("%-20s\t%-20s\t%-20s\t%-20s\n", result.getString("instructorID"), result.getString("instructorName"), result.getString("adviseeID"), result.getString("adviseeName")); 
                        preview--;
                    } while (result.next() && preview>=0);
                    System.out.println("(plus many lines more that are omitted in this document)");
                    finSearchBool=true; //sucessful selection was made
                }
                
                //search the department for advisors with no advisees. Done regardless of what was done before.
                q = "select lpad(instructor.id,5,0) as instructorID, instructor.name as instructorName from (select id, name from instructor where dept_name='"+finalSearch+"') instructor, student, advisor where instructor.id=advisor.i_id and advisor.s_id is NULL";
                result = s.executeQuery(q);
                if(!result.next()) {
                    System.out.println("This department has no advisors with no advisees.");
                } else {
                    int preview = 5; // the size of the table to be previewed by rows
                    System.out.println("This department has advisors with no advisees\nListed below:");
                    System.out.printf("%-20s\t%-20s\n", "instructorID", "instructorName");
                    do {   
                        System.out.printf("%-20s\t%-20s\n", result.getString("instructorID"), result.getString("instructorName")); 
                        preview--;
                    } while (result.next() && preview>=0);
                }

            } while (finSearchBool==false);
            s.close();
            con.close();
        }

        catch(SQLException e) { 
            System.out.print("SQL Error caught: ");
            System.out.println(e.getMessage());

        }

    }
}