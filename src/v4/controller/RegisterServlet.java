/**
 * 
 */
package v4.controller;

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

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import v4.velocity.VelocityEngineFactory;
import v3.model.User;
import v3.dao.IUserDAO;
import v3.dao.UserDAOFactory;

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
			req.getRequestDispatcher("/v4/error.jsp").forward(req, resp);
			return;
		}
		
		IUserDAO userDao = UserDAOFactory.create();
		try {
			User user = new User(username,password,email,mobile);
			userDao.save(user);
			
			String path = getServletContext().getRealPath("/") + "template";  
			
			VelocityEngine ve = VelocityEngineFactory.create(path);
			Template template = ve.getTemplate("welcome.vm");
			VelocityContext context = new VelocityContext();
			context.put("user", user);
			template.merge(context, resp.getWriter());
			resp.getWriter().flush();
		} catch (Exception e) {
			req.setAttribute("exceptionMsg", e.getMessage());
			req.getRequestDispatcher("/v4/error.jsp").forward(req, resp);
		}
	}
}
