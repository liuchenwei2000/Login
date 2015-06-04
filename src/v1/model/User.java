/**
 * 
 */
package v1.model;

import java.io.Serializable;

/**
 * User Bean
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年8月22日
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7351729135012380019L;

	private String pk_user;
	private String username;
	private String password;
	private String email;
	private String mobile;

	public User() {
		super();
	}

	public User(String username, String password, String email, String mobile) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}

	public String getPk_user() {
		return pk_user;
	}

	public void setPk_user(String pk_user) {
		this.pk_user = pk_user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
