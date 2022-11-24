package com.yancy.project.service;

import com.yancy.project.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 用户服务测试
 *
 * @author yupi
 */
@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void testAddUser() {
        User user = new User();
        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }

    @Test
    void testUpdateUser() {
        User user = new User();
        boolean result = userService.updateById(user);
        Assertions.assertTrue(result);
    }

    @Test
    void testDeleteUser() {
        boolean result = userService.removeById(1L);
        Assertions.assertTrue(result);
    }

    @Test
    void testGetUser() {
        User user = userService.getById(1L);
        Assertions.assertNotNull(user);
    }

    @Test
    void userRegister() {
        String userAccount = "yupi";
        String userPassword = "";
        String checkPassword = "123456";
        try {
//            long result = userService.userRegister(userAccount, userPassword, checkPassword);
//            Assertions.assertEquals(-1, result);
//            userAccount = "yu";
//            result = userService.userRegister(userAccount, userPassword, checkPassword);
//            Assertions.assertEquals(-1, result);
//            userAccount = "yupi";
//            userPassword = "123456";
//            result = userService.userRegister(userAccount, userPassword, checkPassword);
//            Assertions.assertEquals(-1, result);
//            userAccount = "yu pi";
//            userPassword = "12345678";
//            result = userService.userRegister(userAccount, userPassword, checkPassword);
//            Assertions.assertEquals(-1, result);
//            checkPassword = "123456789";
//            result = userService.userRegister(userAccount, userPassword, checkPassword);
//            Assertions.assertEquals(-1, result);
//            userAccount = "dogYupi";
//            checkPassword = "12345678";
//            result = userService.userRegister(userAccount, userPassword, checkPassword);
//            Assertions.assertEquals(-1, result);
//            userAccount = "yupi";
//            result = userService.userRegister(userAccount, userPassword, checkPassword);
//            Assertions.assertEquals(-1, result);
        } catch (Exception e) {

        }
    }


    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();

        String str2 = new StringBuilder("Ja").append("va").toString();

        String str3 = "java";
        String str4 = new String("java");

        System.out.println(str1.intern() == str1);//因为之前没有所以创建的引用和intern()返回的引用相同

        System.out.println(str2.intern() == str2);//"java在StringBuilder()之前已经出现过",所以intern()返回的引用与新创建的引用不是同一个

        System.out.println(str3 == str4);
    }
}