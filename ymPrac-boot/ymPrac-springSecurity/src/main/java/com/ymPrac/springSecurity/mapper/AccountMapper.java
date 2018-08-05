package com.ymPrac.springSecurity.mapper;

import com.ymPrac.springSecurity.base.BaseMapper;
import com.ymPrac.springSecurity.entity.Account;

import java.util.List;
import java.util.Map;


public interface AccountMapper extends BaseMapper<Account> {
	public Account querySingleAccount(String accountName);
	public Account isExist(String accountName);
	/**
	 * 验证用户登陆
	 * @author lanyuan
	 * Email：mmm333zzz520@163.conf
	 * date：2014-2-25
	 * @param Account account
	 * @return
	 */
	public Account countAccount(Account account);
	
	public List<Account> queryNoMatch(Map<String, Object> map);
	public long count(Account account);
	
}
