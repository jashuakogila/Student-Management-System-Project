package daooo;

import java.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans1.Student;
import db1.Database1Connection;

public class Studentdao {

	public static int insertstudent(Student s) {
		int result = 0;
		try {
			// 1.connect to the database
			Connection conn = Database1Connection.getConnectedtoDatabase();
			// 2.prepare the sql statement
			PreparedStatement ps = conn
					.prepareStatement("insert into student(fullname,address,email,phone) values (?,?,?,?)");
			ps.setString(1, s.getFullname());
			ps.setString(2, s.getAddress());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getPhone());

			result = ps.executeUpdate();

			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public static List<Student> viewallstudents() {
		List<Student> list = new ArrayList<Student>();

		try {
			// 1.connect to the database
			Connection conn = Database1Connection.getConnectedtoDatabase();
			// 2.prepare the sql statement
			PreparedStatement ps = conn.prepareStatement("select * from student");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setFullname(rs.getString(2));
				s.setAddress(rs.getString(3));
				s.setEmail(rs.getString(4));
				s.setPhone(rs.getString(5));

				list.add(s);
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public static int deletestudent(int id) {
		int result = 0;
		try {
			// 1.connect to the database
			Connection conn = Database1Connection.getConnectedtoDatabase();
			// 2.prepare the sql statement
			PreparedStatement ps = conn.prepareStatement("delete from student where id =?");
			ps.setInt(1, id);

			result = ps.executeUpdate();

			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public static Student viewstudentbyid(int id) {
		Student s = new Student();
		try {
			// 1.connect to the database
			Connection conn = Database1Connection.getConnectedtoDatabase();
			// 2.prepare the sql statement
			PreparedStatement ps = conn.prepareStatement("select * from student where id= ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				s.setId(rs.getInt(1));
				s.setFullname(rs.getString(2));
				s.setAddress(rs.getString(3));
				s.setEmail(rs.getString(4));
				s.setPhone(rs.getString(5));

			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return s;
	}

	public static int updatestudent(Student s) {
		int result = 0;
		try {
			// 1.connect to the database
			Connection conn = Database1Connection.getConnectedtoDatabase();
			// 2.prepare the sql statement
			PreparedStatement ps = conn.prepareStatement(
					"update student set fullname = ? ,address = ? ,email = ? ,phone = ?  where id =?");
			ps.setString(1, s.getFullname());
			ps.setString(2, s.getAddress());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getPhone());
			ps.setInt(5, s.getId());
			result = ps.executeUpdate();

			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public static List<Student> viewmultipleoptions(String stringvalue) {
		List<Student> list = new ArrayList<Student>();

		try {
			// 1.connect to the database
			Connection conn = Database1Connection.getConnectedtoDatabase();
			// 2.prepare the sql statement
			PreparedStatement ps = conn.prepareStatement(
					"select * from student where fullname= ? or address = ? or email = ? or phone = ?");
			ps.setString(1, stringvalue);
			ps.setString(2, stringvalue);
			ps.setString(3, stringvalue);
			ps.setString(4, stringvalue);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setFullname(rs.getString(2));
				s.setAddress(rs.getString(3));
				s.setEmail(rs.getString(4));
				s.setPhone(rs.getString(5));

				list.add(s);
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;

	}

}