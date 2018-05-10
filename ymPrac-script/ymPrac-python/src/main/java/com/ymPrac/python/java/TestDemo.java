package com.ymPrac.python.java;

import org.python.util.PythonInterpreter;

import java.util.Properties;

/**
 * python java 混合编程
 * Created by Yan Meng on 2017/7/5.
 */
public class TestDemo {

    public static void main(String args[]) {

        Properties props = new Properties();
        props.put("python.home", "path to the Lib folder");
        props.put("python.console.encoding", "UTF-8");

        props.put("python.security.respectJavaAccessibility", "false");

        props.put("python.import.site", "false");

        Properties preprops = System.getProperties();

        PythonInterpreter.initialize(preprops, props, new String[0]);
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("days=('mod','Tue','Wed','Thu','Fri','Sat','Sun'); ");
        interpreter.exec("print days[1];");

        System.out.println(65534 & 1);

    }
}
