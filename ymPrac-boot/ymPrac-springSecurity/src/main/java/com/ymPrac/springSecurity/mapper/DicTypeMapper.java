package com.ymPrac.springSecurity.mapper;


import com.ymPrac.springSecurity.base.BaseMapper;
import com.ymPrac.springSecurity.entity.DicType;

public interface DicTypeMapper extends BaseMapper<DicType> {
	public DicType isExist(DicType dicType);
	public DicType queryById(DicType dicType);
    public long count(DicType dicType);
}
