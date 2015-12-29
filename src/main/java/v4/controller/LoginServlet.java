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

import v3.model.User;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import v4.velocity.VelocityEngineFactory;
import v3.dao.IUserDAO;
import v3.dao.UserDAOFactory;

/**
 * 登录
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年8月22日
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4249780684684026453L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("user");
		String password = req.getParameter("password");
		
		// Bean Validation 可以在各个层执行
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
			userDao.validate(username, password);
			
			String path = getServletContext().getRealPath("/") + "template";  
			
			VelocityEngine ve = VelocityEngineFactory.create(path);
			Template template = ve.getTemplate("welcome.vm");
			VelocityContext context = new VelocityContext();
			context.put("user", new User(username, password));
			template.merge(context, resp.getWriter());
			resp.getWriter().flush();
		} catch (Exception e) {
			req.setAttribute("exceptionMsg", e.getMessage());
			req.getRequestDispatcher("/v4/error.jsp").forward(req, resp);
		}
	}
}
