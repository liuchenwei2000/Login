/**
 * 
 */
package v2.dao;

import v1.model.User;

public interface IUserDAO {

	public void validate(String usename, String password) throws Exception;

	public void save(User user) throws Exception;
}
