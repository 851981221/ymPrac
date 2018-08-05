package com.ymPract.reflect.main;

/**
 * Created by Yan Meng on 2016/5/24.
 */
public class Demo {

    public Demo() {}

    public Demo (String name) {
        this.name = name;
    }

    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
