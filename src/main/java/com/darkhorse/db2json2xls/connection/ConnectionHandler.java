package com.darkhorse.db2json2xls.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHandler {
	public static Connection getConnectionInstance() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Class Loaded Successfully");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vsc", "root", "atmecs@123");
			System.out.println("DataBase Connection Successful");

		} catch (SQLException e) {
			System.out.println("Sorry Cant Connect to DataBase");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load the Class");
			e.printStackTrace();
		}

		return connection;

	}

}