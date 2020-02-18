package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients  //开启feign调用
@EnableHystrix   //开启熔断支持
@EnableHystrixDashboard
public class ScwebApplication {

 public static void main(String[] args) {
  SpringApplication.run(ScwebApplication.class, args);
 }
 @Bean  //第三步：创建对象
 @LoadBalanced
  public RestTemplate getRestTemplate(){
    return new RestTemplate();
 }

}
