package com.ymPract.reflect.main.main.UUID;

import org.joda.time.LocalDate;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Yan Meng on 2016/5/24.
 */
public class UUIDTest {

    @Test
    public void testUUID () {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();

        System.out.println(s);

        System.out.println(System.currentTimeMillis());
    }

    /**
     *  性能
     */

    @Test
    public void testEffection () {
        long start = System.currentTimeMillis();
        for (int i = 0; i <= 100000; i++) {
            new Date();
        }
        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }

    @Test
    public void testEffection2 () {
        long start = System.currentTimeMillis();

        for (int i = 0; i <= 100000; i++) {
            UUID.randomUUID();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    @Test
    public void testEffection3 () {
        long start = System.currentTimeMillis();

        for (int i = 0; i <= 100000; i++) {
            System.currentTimeMillis();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    @Test
    public void testDateTime () {

        long start = System.currentTimeMillis();

        for (int i = 0; i <= 100000; i++) {
            LocalDate.now();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(LocalDate.now());
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void testSubString () {
        long start = System.currentTimeMillis();

        for (int i = 0; i <= 100000; i++) {
            long time = System.currentTimeMillis();

            String.valueOf(time).substring(0, 5);
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);

        long time = System.currentTimeMillis();
        System.out.println(String.valueOf(time).substring(0, 6));
    }


}
