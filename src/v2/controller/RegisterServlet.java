/**
 * 
 */
package v2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import v2.dao.IUserDAO;
import v2.dao.UserDAOImpl;
import v1.model.User;

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
		
		if(username == null || username.trim().length() == 0) {
			req.setAttribute("exceptionMsg", "user name cannot be null.");
			req.getRequestDispatcher("/v2/error.jsp").forward(req, resp);
			return;
		}
		if(password == null || password.trim().length() == 0) {
			req.setAttribute("exceptionMsg", "password cannot be null.");
			req.getRequestDispatcher("/v2/error.jsp").forward(req, resp);
			return;
		}
		
		IUserDAO userDao = new UserDAOImpl();
		try {
			userDao.save(new User(username,password,email,mobile));
			req.setAttribute("username", username);
			req.getRequestDispatcher("/v2/welcome.jsp").forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("exceptionMsg", e.getMessage());
			req.getRequestDispatcher("/v2/error.jsp").forward(req, resp);
		}
	}
}
