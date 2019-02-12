package com.darkhorse.db2json2xls.connection;

import java.sql.*;
import static com.darkhorse.db2json2xls.dbproperty.DbProperty.DB_CLASS;
import static com.darkhorse.db2json2xls.dbproperty.DbProperty.DB_URL;
import static com.darkhorse.db2json2xls.dbproperty.DbProperty.PWD;
import static com.darkhorse.db2json2xls.dbproperty.DbProperty.USER;

public class DbConnection {
	Connection con;

	// static block also you can take in place of constructor
	public DbConnection() {

		try {
			Class.forName(DB_CLASS);
			System.out.println("MYSQL driver loaded successfully");

		} catch (Exception e) {
			System.out.println("Unable to Load the Driver");
		}
	}

	public Connection setConnection() {
		try {
			con = DriverManager.getConnection(DB_URL, USER, PWD);
			System.out.println("DATABASE CONNECTION SUCCESSFUL");
			return con;
		} catch (Exception e) {
			System.out.println("Exception Occured");
			e.printStackTrace();
			return null;
		}

	}

}
