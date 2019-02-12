package com.darkhorse.db2json2xls.dao;

import com.darkhorse.db2json2xls.connection.DbConnection;
import java.sql.*;

public class EmpDAO {
	DbConnection dbcon = new DbConnection();
	private static final String SQL = "select * from emp";
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public ResultSet getResultSet() {
		try {
			con = dbcon.setConnection();
			pst = con.prepareStatement(SQL);
			rs = pst.executeQuery();

		} catch (Exception e) {
			System.out.println("Something went Wrong in getResultSet()");
			e.printStackTrace();
		}

		return  rs;
	}
	
	

}
