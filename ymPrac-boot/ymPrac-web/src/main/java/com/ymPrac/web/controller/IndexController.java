package com.ymPrac.web.controller;

import com.google.common.collect.Lists;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 测试接口
 * Created by Yan Meng on 2016/9/21.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

    @RequestMapping("/hellow")
    public String hello(Map<String, Object> model){
        List<String> l= Lists.newArrayList();
        l.add("哈喽，hadoop");
        l.add("哈喽，hbase");
        l.add("哈喽，hive");
        l.add("哈喽，pig");
        l.add("哈喽，zookeeper");
        l.add("哈喽，三劫散仙");
        //将数据存放map里面，可以直接在velocity页面，使用key访问
        model.put("data",l);

        model.put("msg", "中国");
        return "/hellow";
    }
}
