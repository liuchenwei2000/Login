/**
 * 
 */
package v1.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	private static final String DB_USER = "root";
	private static final String DB_PW = "woailo99";

	private static ConnectionFactory instance = new ConnectionFactory();
	
	private ConnectionFactory(){
		super();
		init();
	}
	
	private void init() {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ConnectionFactory getInstance(){
		return instance;
	}
	
	public Connection getConnection(){
		try {
			return DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
