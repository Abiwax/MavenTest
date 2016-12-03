package com.tutorial.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tutorial.model.Details;

public class DetailsDAO {
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/reservation";
	static final String USER = "root";
	static final String PASS = "password";

	public List<Details> getDetails() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet result = null;
		String sql = "SELECT * FROM Student_Details";
		List<Details> myDetails = new ArrayList<Details>();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			result = stmt.executeQuery(sql);
			while (result.next()) {
				myDetails.add(new Details(result.getString("First_Name"), result.getString("Last_Name"),
						result.getString("Score"), result.getInt("Age")));
			}
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myDetails;
	}

	public int insertDetails(Details myDetails) {
		int i = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into Student_Details (First_Name, Last_Name, Score, Age) values (?, ?, ?, ?)";

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, myDetails.getFirstName());
			stmt.setString(2, myDetails.getLastName());
			stmt.setString(3, myDetails.getScore());
			stmt.setInt(4, myDetails.getAge());
			i = stmt.executeUpdate();

			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
