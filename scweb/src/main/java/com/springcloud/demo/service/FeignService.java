package com.springcloud.demo.service;

import com.springcloud.demo.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/2/17
 * @Time: 20:04
 **/
@FeignClient(value = "scprovider",fallbackFactory = HystrixClientFallBackFactory.class)
public interface FeignService {
   //调用，对应一个服务地址  http://localhost:9001/a,b,c...
   //一个服务的请求即为一个方法
//  @GetMapping
  @PostMapping(value = "/getDate",produces = {"application/json;charset=utf-8"})  //指定请求
  public Student getDate();//接口方法参数与请求的参数匹配
 //接口方法的返回值与请求的返回数据(格式:json)对应,支持将json转化为java对象


}
