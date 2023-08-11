package cn.gdcjxy.contacts.ui;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.gdcjxy.contacts.bean.User;

public class RegisterActivityTest {

    private static String EMAIL_REGISTER_ERROR;
    private static String EMAIL_REGISTER_SUCCESS;
    private static String PASSWORD_ERROR;
    private static String PASSWORD_SUCCESS;

    @Before
    public void setUp() throws Exception {
        EMAIL_REGISTER_ERROR = "123";
        EMAIL_REGISTER_SUCCESS= "123@qq.com";
        PASSWORD_ERROR = "1 ";
        PASSWORD_SUCCESS="123456";
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isEmailValid() {
        assertEquals(false,RegisterActivity.isEmailValid(EMAIL_REGISTER_ERROR));
        assertEquals(true,RegisterActivity.isEmailValid(EMAIL_REGISTER_SUCCESS));
    }

    @Test
    public void isPasswordValid() {
        assertEquals(false,RegisterActivity.isPasswordValid(PASSWORD_ERROR));
        assertEquals(true,RegisterActivity.isPasswordValid(PASSWORD_SUCCESS));
    }
}