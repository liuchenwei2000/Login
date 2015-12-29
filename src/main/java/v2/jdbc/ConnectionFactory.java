/**
 * 
 */
package v2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionFactory {
	
	private static String db_url;
	private static String db_user;
	private static String db_pw;

	private static ConnectionFactory instance = new ConnectionFactory();
	
	private ConnectionFactory() {
		super();
	}
	
	public static void initProperties(String driver, String url, String user, String pw) {
		db_url = url;
		db_user = user;
		db_pw = pw;
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectionFactory getInstance(){
		return instance;
	}
	
	public Connection getConnection(){
		try {
			return DriverManager.getConnection(db_url, db_user, db_pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
