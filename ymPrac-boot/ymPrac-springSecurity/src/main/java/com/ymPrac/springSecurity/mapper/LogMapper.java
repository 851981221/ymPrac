package com.ymPrac.springSecurity.mapper;


import com.ymPrac.springSecurity.base.BaseMapper;
import com.ymPrac.springSecurity.entity.Log;

public interface LogMapper extends BaseMapper<Log> {
	public long count(Log log);
}
