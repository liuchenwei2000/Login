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
 * �û����������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��8��22��
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

		// ��仰����˼�������������utf8���������ص�����
		resp.setHeader("Content-type", "text/html;charset=UTF-8");
		// ��仰����˼���Ǹ���servlet��UTF-8ת�룬��������Ĭ�ϵ�ISO8859
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
				resp.getWriter().write("�Բ����û����Ѵ��ڣ����޸ġ�");
			} else {
				resp.getWriter().write("OK");
			}
			resp.getWriter().flush();
		} catch (Exception e) {
			resp.getWriter().write("���������˵����⡣");
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
