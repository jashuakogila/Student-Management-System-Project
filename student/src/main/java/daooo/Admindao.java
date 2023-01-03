package daooo;

import java.sql.*;

import beans1.Admin;
import db1.Database1Connection;

public class Admindao {

	public static int registeradmin(Admin a) {
		int result = 0;
		try {
			// 1.connect to the database
			Connection conn = Database1Connection.getConnectedtoDatabase();
			// 2.prepare the sql statement
			PreparedStatement ps = conn.prepareStatement("insert into admin(username,password) values (?,?)");
			ps.setString(1, a.getUsername());
			ps.setString(2, a.getPassword());
			result = ps.executeUpdate();

			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public static int loginadmin(String username, String password) {
		int result = 0;
		try {
			// 1.connect to the database
			Connection conn = Database1Connection.getConnectedtoDatabase();
			// 2.prepare the sql statement
			PreparedStatement ps = conn.prepareStatement("select * from admin where username=? and password=? ");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				result = 1;
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;

	}

	public static int updatepassword(String username, String newpassword) {
		int result = 0;
		try {
			// 1.connect to the database
			Connection conn = Database1Connection.getConnectedtoDatabase();
			// 2.prepare the sql statement
			PreparedStatement ps = conn.prepareStatement("update admin set password=? where username=?");
			ps.setString(1, newpassword);
			ps.setString(2, username);
			result = ps.executeUpdate();

			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;

	}

}
