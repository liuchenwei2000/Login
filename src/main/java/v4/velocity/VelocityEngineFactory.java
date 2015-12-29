/**
 * 
 */
package v4.velocity;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

/**
 * VelocityEngine工厂
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年8月23日
 */
public final class VelocityEngineFactory {

	/**
	 * 根据指定的VM文件存放目录创建VelocityEngine
	 */
	public static VelocityEngine create(String loaderPath){
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, loaderPath);
		return ve;
	}
}
