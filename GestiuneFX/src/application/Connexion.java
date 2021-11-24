package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	static Connection connection=null;
	public static Connection getConnection() throws SQLException {
		String dbUrl="jbdc:mysql://localhost:3306/gestiune";
		String pass="admin";
		String user="root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=(Connection)DriverManager.getConnection(dbUrl,user,pass);
			return connection;
			
		}
		catch(Exception e) {
			e.getLocalizedMessage();
			e.printStackTrace();
		}
	}
	
}
