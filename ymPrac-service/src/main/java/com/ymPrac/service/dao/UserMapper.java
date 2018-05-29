package com.ymPrac.service.dao;

/**
 * Created by Yan Meng on 2016/9/21.
 */
public interface UserMapper {

    int countAll();

    int selectUseDolar(String houseCode);

    int selectUseHashtag(String houseCOde);
}
