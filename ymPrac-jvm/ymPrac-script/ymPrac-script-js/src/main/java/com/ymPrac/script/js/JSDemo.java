package com.ymPrac.script.js;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * js demo
 * Created by Yan Meng on 2017/7/5.
 */
public class JSDemo {

    public static void main(String[] args) throws Exception {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName( "JavaScript" );

        System.out.println( engine.getClass().getName() );
        System.out.println( "Result:" + engine.eval( "function f() { return 1; }; f() + 1;" ) );
    }
}
