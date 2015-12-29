/**
 * 
 */
package v3.dao;

import v3.model.User;

public interface IUserDAO {

	public void validate(String usename, String password) throws Exception;

	public void save(User user) throws Exception;
}
