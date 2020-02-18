package com.springcloud.demo.entity;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/2/16
 * @Time: 11:15
 **/
public class Student{
 //与provider数据的键值对要对应
  private Integer xh;
  private String name;
  private Integer age;

 public Student() {
 }

 public Student(Integer xh, String name, Integer age) {
  this.xh = xh;
  this.name = name;
  this.age = age;
 }

 public Integer getXh() {
  return xh;
 }

 public void setXh(Integer xh) {
  this.xh = xh;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public Integer getAge() {
  return age;
 }

 public void setAge(Integer age) {
  this.age = age;
 }

 @Override
 public String toString() {
  return "Student{" +
   "xh=" + xh +
   ", name='" + name + '\'' +
   ", age=" + age +
   '}';
 }
}
