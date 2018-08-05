package com.ymPrac.springSecurity.mapper;


import com.ymPrac.springSecurity.base.BaseMapper;
import com.ymPrac.springSecurity.entity.Dic;

public interface DicMapper extends BaseMapper<Dic> {
	public Dic isExist(Dic dic);
	
	public long count(Dic dic);
}
