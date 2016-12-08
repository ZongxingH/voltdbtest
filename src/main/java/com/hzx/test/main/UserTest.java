package com.hzx.test.main;

import com.hzx.test.voltdb.User;
import com.hzx.test.voltdb.UserDao;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Introduction:  [Simple Introduction of the java documents]
 * Package Name:  com.hzx.test.main
 * Project Name:  voltdbtest
 * Author:  ZongxingH
 * Create Time:  2016/12/1 11:39
 */
public class UserTest {

    @Test
    public  void testAddUser(){

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/voltdb-appctx.xml");

        UserDao userDao = (UserDao)ctx.getBean("userDao");
        User user0 = new User("AAAA","男",21,"安徽合肥");
        User user1 = new User("BBBB","女",20,"上海浦东");
        User user2 = new User("CCCC","男",21,"上海浦东");
        int i = userDao.addUser(user0);
        System.out.println("新增数据--" + i);
        i = userDao.addUser(user1);
        System.out.println("新增数据--" + i);
        i = userDao.addUser(user2);
        System.out.println("新增数据--" + i);

    }
    @Test
    public  void testGetUserByName(){

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/voltdb-appctx.xml");

        UserDao userDao = (UserDao)ctx.getBean("userDao");
        List<User> users = userDao.getUserByName("AAAA");
        for (User u : users){
            System.out.print("查询数据：" + u.toString());
        }
    }

    @Test
    public  void testGetAllUsers(){

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/voltdb-appctx.xml");

        UserDao userDao = (UserDao)ctx.getBean("userDao");
        List<User> users = userDao.getAllUsers();
        for (User u : users){
            System.out.println("查询数据：" + u.toString());
        }
    }
    @Test
    public  void testUpdateUserByName(){

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/voltdb-appctx.xml");

        UserDao userDao = (UserDao)ctx.getBean("userDao");
        List<User> users = userDao.getUserByName("AAAA");
        for (User u : users){
            System.out.println("修改前数据：" + u.toString());
        }

        User user0 = new User("AAAA","女",21,"安徽合肥");
        userDao.updateUserByName(user0);

        List<User> users0 = userDao.getUserByName("AAAA");
        for (User u : users0){
            System.out.println("修改后数据：" + u.toString());
        }
    }

    @Test
    public  void testDelUserByName(){

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/voltdb-appctx.xml");

        UserDao userDao = (UserDao)ctx.getBean("userDao");
        userDao.delUserByName("AAAA");

        List<User> users0 = userDao.getAllUsers();
        for (User u : users0){
            System.out.println("修改后数据：" + u.toString());
        }
    }

    @Test
    public  void testDelAllUsers(){

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/voltdb-appctx.xml");

        UserDao userDao = (UserDao)ctx.getBean("userDao");
        userDao.delAllUsers();

        List<User> users0 = userDao.getAllUsers();
        if (null == users0 || users0.size() == 0){
            System.out.println("用户数据已全部删除");
        }else {
            System.out.println("用户数据没有全部删除");
        }
    }
}
