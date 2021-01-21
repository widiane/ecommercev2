package com.ecommerce.ecommerce.domaine;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class RoleVo {

	private int id;
	private String role;
	public RoleVo(String role) {
		
		this.setRole(role);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public RoleVo() {
		super();
	}
	
}
