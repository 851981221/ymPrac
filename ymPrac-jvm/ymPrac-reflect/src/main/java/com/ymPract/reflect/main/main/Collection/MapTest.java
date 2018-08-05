package com.ymPract.reflect.main.main.Collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yan Meng on 2016/6/1.
 */
public class MapTest {

    @Test
    public void testNewMap () {
        Map<String, String> stringStringMap = new HashMap<String, String>();
        String key = "111";
        String ss = stringStringMap.get(key);
        if (ss == null) {
            System.out.println("---------------------------");
            ss = "asdfjlkjfdsajfjoijoadjkfaj";

            stringStringMap.put(key, ss);
        }

        System.out.println(stringStringMap.get(key));
    }
}
