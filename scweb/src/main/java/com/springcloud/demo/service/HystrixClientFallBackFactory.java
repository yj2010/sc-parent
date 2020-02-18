package com.springcloud.demo.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/2/17
 * @Time: 22:08
 **/
//服务出错feign断路器 调用的方法
@Component
public class HystrixClientFallBackFactory implements FallbackFactory<FeignService> {
 @Override
 public FeignService create(Throwable throwable) {
  System.out.println("调服务出现错误...");
//  return null;
  return () -> null;  //1.8以上特性   服务的方法以及返回值。 拉姆达表达式，不带参方法返回
 }
}
