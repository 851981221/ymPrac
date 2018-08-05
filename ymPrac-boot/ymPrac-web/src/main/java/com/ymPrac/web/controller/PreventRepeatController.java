package com.ymPrac.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 防止重复提交测试
 * Created by Yan Meng on 2017/2/15.
 */
@Controller
@RequestMapping("/repeat")
public class PreventRepeatController {

    @RequestMapping("/init")
    @ResponseBody
    public String init() {
        return "success";
    }

    @RequestMapping("/commit")
    @ResponseBody
    public String commit () throws InterruptedException {
        Thread.sleep(3000L);

        return "commited!!!";
    }

}
