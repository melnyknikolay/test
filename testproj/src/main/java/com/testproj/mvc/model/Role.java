package com.testproj.mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
public class Role extends BaseEntity{

	public Role() {
	}

	public Role(Integer id, String name) {
		super(id, name);
	}

}
