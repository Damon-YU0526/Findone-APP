package cn.gdcjxy.contacts.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import cn.gdcjxy.contacts.bean.User;

/**
 * UserDaoTest
 */
public class UserDaoTest {

    private static int DELETE_ID_SUCCESS;
    private static User user ;
    private static String EMAIL;
    private static String PASSWORD;


    @Before
    public void setUp() throws Exception {
        EMAIL = "123@qq.com";
        PASSWORD = "123456";
        DELETE_ID_SUCCESS = 1;
        user = new User(EMAIL,PASSWORD);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * before deleteTest
     * you must add data into sqlite database
     */
    @Test
    public void delete() {
        assertEquals(1,UserDao.delete(DELETE_ID_SUCCESS));
    }

    /**
     * before updateTest
     * you must add data into sqlite database
     */
    @Test
    public void update() {
        assertEquals(1,UserDao.update(user));
    }
}