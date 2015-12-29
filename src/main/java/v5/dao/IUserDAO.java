/**
 * 
 */
package v5.dao;

import v3.model.User;

public interface IUserDAO {

	public void validate(String usename, String password) throws Exception;
	
	public boolean isExisted(String username);

	public void save(User user) throws Exception;
}
