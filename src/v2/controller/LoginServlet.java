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
			req.setAttribute("username", username);
			req.getRequestDispatcher("/v2/welcome.jsp").forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("exceptionMsg", "username or password is error.");
			req.getRequestDispatcher("/v2/error.jsp").forward(req, resp);
		}
	}
}
