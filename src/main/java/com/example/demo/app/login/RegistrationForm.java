package com.example.demo.app.login;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationForm {

	@NotNull(message = "空白は不可")
	@Size(min = 1, message = "文字を入力してください")
	private String username;
	
	@NotNull(message = "空白は不可")
	@Size(min = 1, message = "文字を入力してください")
	@Email(message="メールアドレスを入力してください")
	private String email;
	
	@NotNull(message = "空白は不可")
	@Size(min = 1, message = "文字を入力してください。")
	private String password;
	
	private Boolean enabled;
	
	private String authority;
	
	public boolean isNewRegistration;
	
	public RegistrationForm() {};
	
	public RegistrationForm(String username, String email, String password, Boolean enabled,
			String authority, boolean isNewRegistration) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
		this.isNewRegistration = isNewRegistration;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public boolean isNewRegistration() {
		return isNewRegistration;
	}

	public void setNewRegistration(boolean isNewRegistration) {
		this.isNewRegistration = isNewRegistration;
	}
	

}