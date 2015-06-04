/**
 * 
 */
package v3.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import v3.dao.IUserDAO;
import v3.dao.UserDAOFactory;
import v3.model.User;

/**
 * 注册新用户
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年8月22日
 */
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4249780684684026453L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("user");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<User>> violations = validator.validate(new User(username, password));
		
		String message = "";
		for (ConstraintViolation<User> violation : violations) {
			message += violation.getMessage() + ".";
		}
		
		if(message != null && message.trim().length() != 0) {
			req.setAttribute("exceptionMsg", message);
			req.getRequestDispatcher("/v3/error.jsp").forward(req, resp);
			return;
		}
		
		IUserDAO userDao = UserDAOFactory.create();
		try {
			userDao.save(new User(username,password,email,mobile));
			req.setAttribute("username", username);
			req.getRequestDispatcher("/v3/welcome.jsp").forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("exceptionMsg", e.getMessage());
			req.getRequestDispatcher("/v3/error.jsp").forward(req, resp);
		}
	}
}
