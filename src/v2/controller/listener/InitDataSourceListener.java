/**
 * 
 */
package v2.controller.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import v2.jdbc.ConnectionFactory;

/**
 * 初始化数据源
 * <p>
 * 当web server启动的时候，会触发此监听器。
 * 监听器会将web.xml中配置的数据源信息读取出来，并用它们来初始化ConnectionFactory。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年8月23日
 */
public class InitDataSourceListener implements ServletContextListener {

	/**
	 * 容器初始化时
	 * 
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext context = arg0.getServletContext();
		context.log("ServlectContext initialize starts.");
		String driver = context.getInitParameter("driver");
		context.log("【Driver】" + driver);
		String url = context.getInitParameter("url");
		context.log("【URL】" + url);
		String user = context.getInitParameter("user");
		context.log("【User】" + user);
		String password = context.getInitParameter("password");
		context.log("【Password】" + password);
		ConnectionFactory.initProperties(driver, url, user, password);
		context.log("ServlectContext initialize end.");
	}
	
	/**
	 * 容器关闭时
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}
}
