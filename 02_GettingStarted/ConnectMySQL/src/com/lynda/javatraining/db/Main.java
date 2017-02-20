package com.lynda.javatraining.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Clock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "yoyo";
	private static final String CONN_STRING =
			"jdbc:mysql://localhost/explorecalifornia";
	
	public static void main(String[] args) throws  SQLException {
		          Connection conn = null;
            try {
                conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                        System.out.println("Connected!");
                        } catch (SQLException ex) {
                System.err.println(ex);
            }
            finally {
            if(conn!= null){
               conn.close();
            }
        }
		
	}

}
