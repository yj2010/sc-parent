package com.springcloud.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.demo.entity.Student;
import com.springcloud.demo.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/2/15
 * @Time: 22:37
 **/
@Controller
public class IndexController {
 @Autowired //注入对象（需要在启动类创建对象）
 private RestTemplate restTemplate;

    @RequestMapping("/goIndex") //ribbon调用
    @HystrixCommand(fallbackMethod = "error") //方法名，服务调用不到默认调用的方法
    @ResponseBody
 public Student goIndex(){
     //第一步：思路-输出调用服务获取的信息
     //第二步：思路-使用restTemplate对象调用eureka服务，首先通过@Autowired注入
     //第三步：注入的前提：创建对象---启动类中创建
     //第四步：restTemplate.getForObject("url",实体.class)
     //第五步：创建实体Student
     //第六步：完善第四步，即实现第一步的调用服务
//     Student student = restTemplate.getForObject("http://localhost:9002/getDate", Student.class);
     Student student = restTemplate.getForObject("http://scprovider/getDate", Student.class);
     //第七步：输出信息
     System.out.println("student = " + student.toString()); //补充实体中toString()
     return student; //第八步：将学生信息返回，注意添加 @ResponseBody，而且方法返回值改为Student。

    }

    public Student error(){
     System.out.println("ribbon实现断路器");
     return new Student(120,"aa",22);
    }

    @Autowired(required = false)  //运行时再用,不运行不需要
    private FeignService feignService;
 @RequestMapping("/goIndex2")
 @ResponseBody
 public Student goIndex2(){
//调用服务-->
  Student student = feignService.getDate();
  System.out.println("feign正常调用服务");
  return student;
 }
}
