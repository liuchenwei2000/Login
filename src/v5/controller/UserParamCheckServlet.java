/**
 * 
 */
package v5.controller;

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

import v5.dao.IUserDAO;
import v5.dao.UserDAOImpl;
import v3.model.User;

/**
 * 用户名参数检查
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年8月22日
 */
public class UserParamCheckServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4249780684684026453L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("user");
		String password = req.getParameter("password");

		// 这句话的意思，是让浏览器用utf8来解析返回的数据
		resp.setHeader("Content-type", "text/html;charset=UTF-8");
		// 这句话的意思，是告诉servlet用UTF-8转码，而不是用默认的ISO8859
		resp.setCharacterEncoding("UTF-8");
		if (!isEmpty(username)) {
			chechUsername(resp, username);
		}
		
		if (!isEmpty(password)) {
			chechPassword(resp, password);
		}
	}

	private void chechUsername(HttpServletResponse resp, String username)
			throws IOException {
		IUserDAO userDao = new UserDAOImpl();
		try {
			boolean isExisted = userDao.isExisted(username);
			
			if (isExisted) {
				resp.getWriter().write("对不起！用户名已存在，请修改。");
			} else {
				resp.getWriter().write("OK");
			}
			resp.getWriter().flush();
		} catch (Exception e) {
			resp.getWriter().write("服务器出了点问题。");
			resp.getWriter().flush();
		}
	}
	
	private void chechPassword(HttpServletResponse resp, String password) throws IOException {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<User>> violations = validator.validateProperty(new User("", password), "password");
		if(violations.isEmpty()) {
			resp.getWriter().write("OK");
		}else {
			String message = "";
			for (ConstraintViolation<User> violation : violations) {
				message += violation.getMessage() + "; ";
			}
			resp.getWriter().write(message);
		}
		resp.getWriter().flush();
	}

	private boolean isEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}
}
