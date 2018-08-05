package com.ymPrac.springSecurity.mapper;

import com.ymPrac.springSecurity.base.BaseMapper;
import com.ymPrac.springSecurity.entity.RoleAccount;
import com.ymPrac.springSecurity.entity.Roles;

public interface RolesMapper extends BaseMapper<Roles> {
	public Roles isExist(String name);
	
	public Roles findbyAccountRole(String accountId);
	
	public void addAccRole(RoleAccount roleAccount);
	
	public void deleteAccountRole(String accountId);
	
	public long count(Roles role);
}
