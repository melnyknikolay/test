package com.testproj.mvc.model;

import javax.persistence.*;


@Entity
@Table(name = "USER")
public class User extends BaseEntity{

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROLE_ID")
	private Role role;

	public User() {
	}

	public User(Integer id, String userName, String password, Boolean isActive, Role role) {
		super(id, userName);
		this.password = password;
		this.isActive = isActive;
		this.role = role;
	}

	public User( String userName, String password, Boolean isActive, Role role) {
		super(userName);
		this.password = password;
		this.isActive = isActive;
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return isActive;
	}

	public void setActive(Boolean active) {
		isActive = active;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean IsNew(){
		return getId() == null;
	}
}
