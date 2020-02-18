package com.springcloud.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/2/15
 * @Time: 21:59
 **/
//@Controller
 @RestController  //返回数据 @Controller+@ResoponseBody
public class DemoController {
//  提供一个服务，返回学生信息
    @RequestMapping("/getDate")
 public String getDate(){
     System.out.println("provider1");
     return "{\"xh\":101,\"name\":\"张三\",\"age\":21}";
    }
}
