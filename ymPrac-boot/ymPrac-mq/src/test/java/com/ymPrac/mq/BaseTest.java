package com.ymPrac.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Yan Meng on 2016/9/21.
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = App.class) // 指定我们SpringBoot工程的Application启动类
public class BaseTest {

    @Test
    public void hello () {
        System.out.println("hello");
    }

}
