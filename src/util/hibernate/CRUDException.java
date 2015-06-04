/**
 * 
 */
package util.hibernate;

/**
 * CRUD�쳣
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��8��21��
 */
public class CRUDException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3186443127275341371L;

	public CRUDException() {
		super();
	}

	public CRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	public CRUDException(String message) {
		super(message);
	}

	public CRUDException(Throwable cause) {
		super(cause);
	}
}
