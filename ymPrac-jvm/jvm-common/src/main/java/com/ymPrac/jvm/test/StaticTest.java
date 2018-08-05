package com.ymPrac.jvm.test;

/**
 * static 与巨款 测试
 * Created by Yan Meng on 2017/7/10.
 */
public class StaticTest {
    static {
        System.out.println("main");
    }

    public static void main(String[] args) {
        System.out.println("start ----------------");
        Demo demo = new Demo();

        System.out.println("end--------------------");
    }

}


class Demo {
    static {
        System.out.println("demo ___________________");
    }
}


/**
 * =============================================
 */
class SSClass {
    static {
        System.out.println("SSClass");
    }
}

class SuperClass extends SSClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;

    public SuperClass() {
        System.out.println("init SuperClass");
    }
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init");
    }

    static int a;

    public SubClass() {
        System.out.println("init SubClass");
    }
}

class NotInitialization {
    static {
        System.out.println("main class");
    }

    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}


//========================================================
class StaticTestD {
    public static void main(String[] args) {
        staticFunction();
    }

    static StaticTestD st = new StaticTestD();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticTestD() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a = 110;
    static int b = 112;
}