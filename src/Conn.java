import java.sql.*;


public class Conn {
	Connection c;
	Statement s;
	public Conn() {
		
		try {
			//Step 1/4: Register Server/Database
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step 2/4: Create Connection
			c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "fhdalv");
			//Step 3/4: Create Statement
			s = c.createStatement();
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}