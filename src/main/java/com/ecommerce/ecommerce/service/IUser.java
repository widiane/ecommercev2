package com.ecommerce.ecommerce.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ecommerce.ecommerce.domaine.RoleVo;
import com.ecommerce.ecommerce.domaine.UserRegistrationDto;
import com.ecommerce.ecommerce.domaine.UserVo;
import com.ecommerce.ecommerce.model.User;

public interface IUser extends UserDetailsService {
	void save(UserVo user);
	void save(RoleVo role);
	List<UserVo> getAllUsers();
	List<RoleVo> getAllRoles();
	RoleVo getRoleByName(String role);
	void cleanDataBase();
	
	User findByEmail(String email);

    User Register(UserRegistrationDto registration);
}
