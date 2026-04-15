package com.kh.keeper.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcTemplate {

	public static void registDriver() {
		
		try {
			
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		
		try {
			Properties prop = new Properties();
			
			prop.load(new FileInputStream("resources/connection.properties"));
			
//			String url = prop.getProperty("URL");
//			System.out.println(url);
			
			Connection conn = DriverManager.getConnection(prop.getProperty("URL")
														, prop.getProperty("USERNAME")
														, prop.getProperty("PASSWORD"));
			conn.setAutoCommit(false);
			
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void commit(Connection conn) {
		try {
			if(null != conn) {
			conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		
		try {
			if(null != conn)
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
