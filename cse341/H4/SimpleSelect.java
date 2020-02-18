import java.sql.*;
public class SimpleSelect {
  public static void main(String[] args) {
    try (
         Connection con=DriverManager.getConnection
		("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241","x","y");
         Statement s=con.createStatement();
         ) {
           System.out.println("connection successfully made.");
           String q;
           ResultSet result;
           q = "select X.course_id, Y.course_id as Prereq1, Z.course_id as Prereq, Z.prereq_id as Prereq"
		+ " from dbcourse.prereq X, dbcourse.prereq Y, dbcourse.prereq Z"
		+ " where Z.course_id = Y.prereq_id and Y.course_id = X.prereq_id";
           result = s.executeQuery(q);
           if (!result.next()) System.out.println ("Empty result.");
           else {
             do {
               System.out.println (result.getString("Prereq1") + " " + result.getString("Prereq"));
             } while (result.next());
           }
         } catch(Exception e){e.printStackTrace();}
  }
}
