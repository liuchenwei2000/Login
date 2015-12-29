/**
 * 
 */
package v1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import v1.jdbc.ConnectionFactory;
import v1.model.User;

public class UserDAOImpl implements IUserDAO {

	public void validate(String usename, String passwod) throws Exception {
		String sql = " select 1 from web_user where username=? and password=?";
		
		Connection connection = null;
		try {
			connection = ConnectionFactory.getInstance().getConnection();

			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, usename);
			prepareStatement.setString(2, passwod);

			ResultSet result = prepareStatement.executeQuery();
			if (!result.next()) {
				throw new Exception("未能找到用户.");
			}
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	public void save(User user) throws Exception {
		String sql = "insert into web_user values(?,?,?,?,?)";

		Connection connection = null;
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			connection.setAutoCommit(false);

			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, generatePk_user());
			prepareStatement.setString(2, user.getUsername());
			prepareStatement.setString(3, user.getPassword());
			prepareStatement.setString(4, user.getEmail());
			prepareStatement.setString(5, user.getMobile());

			prepareStatement.execute();
			connection.setAutoCommit(true);
		} catch (Exception e) {
			if(connection != null) {
				connection.rollback();
			}
			e.printStackTrace();
		} finally {
			if(connection != null) {
				connection.close();
			}
		}
	}
	
	private String generatePk_user(){
		return UUID.randomUUID().toString();
	}
}
