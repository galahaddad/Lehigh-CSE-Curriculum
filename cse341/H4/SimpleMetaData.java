import java.sql.*;

public class SimpleMetaData {
  public static void main(String[] args) {    
    try (
         Connection con=DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241","x","y");
         Statement s=con.createStatement();
         ) {
           String q;
           ResultSet result;
           q = "SELECT * from instructor";
           result = s.executeQuery(q);
           ResultSetMetaData rsmd = result.getMetaData();
           for (int i = 1; i <= rsmd.getColumnCount(); i++) {
             System.out.print (rsmd.getColumnName(i) + " (");
             System.out.println (rsmd.getColumnTypeName(i) + ")");
           }
         } catch(Exception e){e.printStackTrace();}
  }
}
