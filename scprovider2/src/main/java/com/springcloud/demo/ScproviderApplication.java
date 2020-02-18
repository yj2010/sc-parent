package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //开启客户端
public class ScproviderApplication {

 public static void main(String[] args) {
  SpringApplication.run(ScproviderApplication.class, args);
 }

}
