package com.ymPrac.dubbo.consumer;

import com.ymPrac.dubbo.provider.Servicer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Yan Meng on 2016/9/23.
 */
@Controller
public class TestController {
    @Resource(name = "testService")
    private Servicer testService;
//    @Resource(name = "annotationProvider")
//    private AnnotationProvider annotationProvider;

    @RequestMapping("/dubbo")
    @ResponseBody
    public String home(){

        return testService.sayHello();

    }
}
