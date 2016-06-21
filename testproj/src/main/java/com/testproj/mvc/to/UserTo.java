package com.testproj.mvc.to;

import com.testproj.mvc.model.Role;


public class UserTo {

	private Integer id;
	private String userName;
	private String password;
	private Boolean isActive;
	private String role;


	public UserTo() {
	}

	public UserTo(Integer id, String userName, String password, Boolean isActive, String role) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.isActive = isActive;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role.getName();
	}

	public boolean IsNew(){
		return id == null;
	}
}
