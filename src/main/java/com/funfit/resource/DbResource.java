package com.funfit.resource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbResource {

	public static Connection getDbConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/funfit", "funfit", "vodafone");
			return connection;
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
}
