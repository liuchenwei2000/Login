/**
 * 
 */
package v5.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import v4.velocity.VelocityEngineFactory;
import v5.dao.IUserDAO;
import v5.dao.UserDAOImpl;
import v3.model.User;

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
		
		IUserDAO userDao = new UserDAOImpl();
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
			req.getRequestDispatcher("/v5/error.jsp").forward(req, resp);
		}
	}
}
