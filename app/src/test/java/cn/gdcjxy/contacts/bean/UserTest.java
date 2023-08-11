package cn.gdcjxy.contacts.bean;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * UserTest
 */
public class UserTest {

    private static User user;
    private static String EMAIL;
    private static String PASSWORD;

    @Before
    public void setUp() throws Exception {
        EMAIL = "123@qq.com";
        PASSWORD = "123456";
        user = new User(EMAIL,PASSWORD);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getEmail() {
        assertEquals(EMAIL,user.getEmail());
    }

    @Test
    public void getPassword() {
        assertEquals(PASSWORD,user.getPassword());
    }
}