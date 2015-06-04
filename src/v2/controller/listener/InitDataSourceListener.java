/**
 * 
 */
package v2.controller.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import v2.jdbc.ConnectionFactory;

/**
 * ��ʼ������Դ
 * <p>
 * ��web server������ʱ�򣬻ᴥ���˼�������
 * �������Ὣweb.xml�����õ�����Դ��Ϣ��ȡ������������������ʼ��ConnectionFactory��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��8��23��
 */
public class InitDataSourceListener implements ServletContextListener {

	/**
	 * ������ʼ��ʱ
	 * 
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext context = arg0.getServletContext();
		context.log("ServlectContext initialize starts.");
		String driver = context.getInitParameter("driver");
		context.log("��Driver��" + driver);
		String url = context.getInitParameter("url");
		context.log("��URL��" + url);
		String user = context.getInitParameter("user");
		context.log("��User��" + user);
		String password = context.getInitParameter("password");
		context.log("��Password��" + password);
		ConnectionFactory.initProperties(driver, url, user, password);
		context.log("ServlectContext initialize end.");
	}
	
	/**
	 * �����ر�ʱ
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}
}
