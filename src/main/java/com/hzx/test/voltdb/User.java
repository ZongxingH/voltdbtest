package com.hzx.test.voltdb;

/**
 * Introduction:  [Simple Introduction of the java documents]
 * Package Name:  com.hzx.test.voltdb
 * Project Name:  voltdbtest
 * Author:  ZongxingH
 * Create Time:  2016/12/1 11:02
 */
public class User {

    private String name;
    private String sex;
    private int age;
    private String addr;

    public User(){}

    public User(String name, String sex, int age, String addr) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }
}
