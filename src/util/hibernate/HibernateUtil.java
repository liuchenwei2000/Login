/**
 * 
 */
package util.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * HibernateUtil
 * <p>
 * ͳһ��������Ӧ��ϵͳ��SessionFactory��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��7��24��
 */
public final class HibernateUtil {
	
	// ȫ��ֻ��һ�� SessionFactory ʵ��
	private static final SessionFactory instance;
	
	static {
		try {
			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			instance = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * ��ȡSessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return instance;
	}
	
	private HibernateUtil() {
		// do nothing
	}
}
