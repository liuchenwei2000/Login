/**
 * 
 */
package util.hibernate;

import org.hibernate.Session;

/**
 * Hibernate�����ص��ӿ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��8��20��
 */
public interface HibernateCallback {

	/**
	 * ִ�в���
	 */
	public void execute(Session session);
}
