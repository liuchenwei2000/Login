/**
 * 
 */
package util;

import java.util.Random;

/**
 * ������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-6-16
 */
public class RollUtil {
	
	private static Random random = new Random();
	
	public static int rollIt(){
		return random.nextInt(7);
	}
}
