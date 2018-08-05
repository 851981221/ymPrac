package com.ymPrac.Grovy.java;

import groovy.lang.GroovyObject;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;

import java.io.IOException;
import java.util.Date;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * ScriptEngine 在java中嵌入grovy代码示例
 * Created by Yan Meng on 2017/7/5.
 */
public class ScriptEngineTest {

    public static void main(String[] args) throws Exception {
        // 字符串脚本
        evalScript();

        // 文件脚本
        simpleTest();
    }

    private static void evalScript() throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        //每次生成一个engine实例
        ScriptEngine engine = manager.getEngineByName("groovy");
        System.out.println(engine.toString());

        //javax.script.Bindings
        Bindings binding = engine.createBindings();
        binding.put("date", new Date());

        //如果script文本来自文件,请首先获取文件内容
        engine.eval("def getTime(){return date.getTime();}",binding);
        engine.eval("def sayHello(name,age){return 'Hello,I am ' + name + ',age' + age;}");

        Long time = (Long)((Invocable)engine).invokeFunction("getTime",  null);
        System.out.println(time);
        String message = (String)((Invocable)engine).invokeFunction("sayHello", "zhangsan", 12);
        System.out.println(message);
    }

    /**
     * 3) 实际案例，Java调用groovy文件里面的方法，并传递参数
     */
    private static void simpleTest() throws IOException, InstantiationException,
            IllegalAccessException, ResourceException, ScriptException, groovy.util.ScriptException {
        String[] roots = new String[] { "E:\\IdeaProjects\\ymPrac\\ymPrac-Grovy\\src\\main\\resources" };

        //通过指定的roots来初始化GroovyScriptEngine
        GroovyScriptEngine gse = new GroovyScriptEngine(roots);
        GroovyObject groovyObject = (GroovyObject) gse.loadScriptByName("TestScript.groovy").newInstance();
        String result = (String) groovyObject.invokeMethod("output", "hello");
        System.out.println(result);
    }
}
