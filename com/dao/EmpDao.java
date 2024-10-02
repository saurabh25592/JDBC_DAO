package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmpDao {

	public static Connection takeConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "root");

	}

	public void insert() throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the eid:");
		int eid = sc.nextInt();
		System.out.println("Enter the ename:");
		String ename = sc.next();
		System.out.println("Enter the age:");
		int age = sc.nextInt();
		System.out.println("Enter the city:");
		String city = sc.next();

		Connection con = EmpDao.takeConnection();

		PreparedStatement ps = null;

		ps = con.prepareStatement("insert into emp(eid, ename, age, city) values(?, ?, ?, ?)");
		ps.setInt(1, eid);
		ps.setString(2, ename);
		ps.setInt(3, age);
		ps.setString(4, city);

		int rows = ps.executeUpdate();
		if (rows > 0) {
			System.out.println("Record inserted successfully.");
		} else {
			System.out.println("Insertion failed.");
		}

		con.close();

	}

	// update
	public void update() throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the eid to update:");
		int eid = sc.nextInt();
		System.out.println("Enter the new ename:");
		String ename = sc.next();
		System.out.println("Enter the new age:");
		int age = sc.nextInt();
		System.out.println("Enter the new city:");
		String city = sc.next();

		Connection c = EmpDao.takeConnection();
		PreparedStatement ps = null;

		String update = "update emp set ename = ?, age = ?, city = ? where eid = ?";
		ps = c.prepareStatement(update);
		ps.setString(1, ename);
		ps.setInt(2, age);
		ps.setString(3, city);
		ps.setInt(4, eid);

		int rows = ps.executeUpdate();
		if (rows > 0) {
			System.out.println("record updated successfully.");
		} else {
			System.out.println("update failed.");
		}
	}

	// delete data
	public void delete() throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the eid to delete:");
		int eid = sc.nextInt();

		Connection con = EmpDao.takeConnection();
		PreparedStatement ps = null;

		String delete = "delete from emp where eid = ?";
		ps = con.prepareStatement(delete);
		ps.setInt(1, eid);

		int rows = ps.executeUpdate();
		if (rows > 0) {
			System.out.println("Record deleted successfully.");
		} else {
			System.out.println("Delete failed.");
		}

		ps.close();
		con.close();
	}

	// Fetch Data
	public void fetchData() throws Exception {
		Connection con = EmpDao.takeConnection();

		String query = "select * from emp";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();

		// we are fletch data by using next() boolean value
		while (rs.next()) {
			int eid = rs.getInt("eid");
			String ename = rs.getString("ename");
			int age = rs.getInt("age");
			String city = rs.getString("city");

			System.out.println(eid + " " + ename + " " + age + " " + city);
		}

		rs.close();
		ps.close();
		con.close();
	}

}
