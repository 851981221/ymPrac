package com.ymPract.reflect.main;

/**
 * Created by Yan Meng on 2016/5/24.
 */
public class Test {

    /**
     * 获取名称
     */
    public void testReflectName () {
        Demo demo = new Demo();

        System.out.println(demo.getClass().getName());
    }

    /**
     * 实例化Class类对象
     */
    public void testReflect () throws ClassNotFoundException {
        Class<Demo> demo1 = (Class<Demo>) Class.forName("com.ymPract.reflect.main.Demo");

        System.out.println(demo1.getClass().getName());
        System.out.println(demo1.getName());
    }

    public void testGetClass () {
        Class<Demo> demoClass = Demo.class;

        Class<? extends Demo> aClass = new Demo().getClass();
        System.out.println(aClass.getName());
    }

    public void testNewInstance () throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> demo = Class.forName("com.ymPract.reflect.main.Demo");

        Object o = demo.newInstance();

        Demo demo2 = (Demo) o;

        System.out.println(((Demo) o).getName());
    }

    public void testClassLoader() {
        System.out.println(Demo.class.getClassLoader().getClass().getName());
    }


}
