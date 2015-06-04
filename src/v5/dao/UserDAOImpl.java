/**
 * 
 */
package v5.dao;

import util.hibernate.HibernateCallback;
import util.hibernate.HibernateTemplate;
import util.hibernate.HibernateUtil;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import v3.model.User;

public class UserDAOImpl implements IUserDAO {

	public void validate(String usename, String password) throws Exception {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();

			Criteria criteria = session.createCriteria(User.class)
					.add(Restrictions.eq("username", usename))
					.add(Restrictions.eq("password", password));
			List<?> result = criteria.list();
			if (result.isEmpty()) {
				throw new Exception("未能找到用户.");
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public boolean isExisted(String username) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();

			Criteria criteria = session.createCriteria(User.class)
					.add(Restrictions.eq("username", username));
			List<?> result = criteria.list();
			return !result.isEmpty();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void save(final User user) throws Exception {
		String checkMsg = checkUser(user);
		if(!isEmpty(checkMsg)) {
			throw new Exception(checkMsg);
		}
		
		new HibernateTemplate<User>().runInTransaction(new HibernateCallback() {
			
			@Override
			public void execute(Session session) {
				session.save(user);
			}
		});
	}

	private String checkUser(final User user) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		
		String message = "";
		for (ConstraintViolation<User> violation : violations) {
			message += violation.getMessage() + ".";
		}
		return message;
	}
	
	private boolean isEmpty(String s){
		return s == null || s.trim().length() == 0;
	}
}
