import java.sql.*;
public class OurTeethAndAmbitionsAreBared{
  public static void main(String[] args) {
    try (
         Connection con=DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241","x","y");
         ) {
           String q;
           ResultSet result;
           int i;
           q = "insert into enemies2 values(?,?)";
	   	   PreparedStatement ps = con.prepareStatement(q);
           ps.setString(1,"Bonkers");
           ps.setInt(2,99);
           i = ps.executeUpdate();
           System.out.println ("value returned: " + i);
           ps.setString(1,"Lassie");
           i = ps.executeUpdate();
           System.out.println ("value returned: " + i);
         } catch(Exception e){e.printStackTrace();}
  }
}
