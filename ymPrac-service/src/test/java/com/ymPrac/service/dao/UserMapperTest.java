package com.ymPrac.service.dao;

import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Yan Meng on 2016/9/22.
 */
public class UserMapperTest extends BaseTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testCountAll () {
        int count = userMapper.countAll();

        System.out.println(count);
    }

    @Test
    public void testSelect() {
        userMapper.selectUseDolar("123456");

        userMapper.selectUseHashtag("123456");
    }
}
