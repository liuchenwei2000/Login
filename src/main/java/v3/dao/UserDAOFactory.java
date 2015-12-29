/**
 * 
 */
package v3.dao;

public class UserDAOFactory {

	private static IUserDAO dao = new UserDAOImpl();
	
	public static IUserDAO create() {
		return dao; 
	}
}
