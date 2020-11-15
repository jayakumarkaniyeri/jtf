package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {

	public static void main(String[] args) throws SQLException {
		
		String host = "localhost";
		String port = "3306";
		
		Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/jtfDB", "root", "Kattammb123*");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select name from employee where location = 'Texas'");
		
		while(rs.next()) {
			System.out.println(rs.getString("name"));
		}
		
	}

}
