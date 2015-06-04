/**
 * 
 */
package v4.velocity;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

/**
 * VelocityEngine����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��8��23��
 */
public final class VelocityEngineFactory {

	/**
	 * ����ָ����VM�ļ����Ŀ¼����VelocityEngine
	 */
	public static VelocityEngine create(String loaderPath){
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, loaderPath);
		return ve;
	}
}
