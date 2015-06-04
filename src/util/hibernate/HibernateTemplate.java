/**
 * 
 */
package util.hibernate;

import org.hibernate.Session;

/**
 * Hibernate����ģ��
 * <p>
 * ��CRUD����ʹ�õĳ���������з�װ���γɴ���ģ�壬�����˷��ӵ��ظ����롣
 * <p>
 * ���������Բ����������²��裺
 * 1����ȡsession
 * 2����������
 * 3��ִ�о������
 * 4���ύ����/�����쳣�ع������׳��쳣
 * 5���ر�session
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��8��20��
 */
public final class HibernateTemplate<T> {
	
	/**
	 * ��������ִ�в���
	 */
	public void runInTransaction(HibernateCallback callback) throws CRUDException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			callback.execute(session);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null && session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
			throw new CRUDException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * ʹ��ָ��session����������ִ�в���������������session����close
	 */
	public void runInTransaction(Session session, HibernateCallback callback) throws CRUDException {
		try {
			session.beginTransaction();
			callback.execute(session);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null && session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
			throw new CRUDException(e);
		}
	}
}
