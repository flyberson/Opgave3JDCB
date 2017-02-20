package com.lynda.javatraining.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

public class Main {

	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "yoyo";
	private static final String CONN_STRING =
			"jdbc:hsqldb:data/explorecalifornia";
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
                Statement stmt = null;
                ResultSet rs =null;
                
		
		try {
			
                    conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                        rs = stmt.executeQuery("SELECT * FROM states");
                        rs.last();
                        System.out.println("Numer of rows "+ rs.getRow());
                        System.out.println("Connected!");
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
                        if (stmt != null) {
				stmt.close();
			}
                        if (conn != null) {
				conn.close();
			}
		}
		
	}

}
