/**
 * 
 */
package v3.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

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
	@NotEmpty(message = "用户名不可为空")
	private String username;
	@NotEmpty(message = "密码不可为空")
	@Length(min = 8, max = 16, message = "密码长度需在8到16位之间")
	private String password;
	@Email(message = "Email格式不合法")
	private String email;
	private String mobile;

	public User() {
		super();
	}

	public User(String usename, String password) {
		this(usename, password, null, null);
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
