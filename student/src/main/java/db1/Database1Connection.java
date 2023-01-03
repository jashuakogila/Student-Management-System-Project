package db1;

import java.sql.*;

public class Database1Connection {
	public static Connection getConnectedtoDatabase() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "root");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}
