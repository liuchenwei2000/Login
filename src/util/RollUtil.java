/**
 * 
 */
package util;

import java.util.Random;

/**
 * 掷骰子
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-16
 */
public class RollUtil {
	
	private static Random random = new Random();
	
	public static int rollIt(){
		return random.nextInt(7);
	}
}
