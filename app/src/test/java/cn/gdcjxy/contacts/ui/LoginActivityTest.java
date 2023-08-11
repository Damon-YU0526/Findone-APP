package cn.gdcjxy.contacts.ui;

import static org.junit.Assert.*;

import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginActivityTest {
    private String email1;
    private String email2;
    private String email3;
    private String password1;
    private String password2;
    @Before
    public void setUp() throws Exception {
         email1 = "123";
         email2 = "qq";
         email3 = "123@qq.com";
         password1 = "1 ";
         password2 = "123456";
    }

    @Test
    public void LoginActivityTestCode() throws Exception{
        assertEquals(false,LoginActivity.isEmailValid(email1));
        assertEquals(false,LoginActivity.isEmailValid(email2));
        assertEquals(true,LoginActivity.isEmailValid(email3));
    }

    @Test
    public void LoginActivityIsPasswordValidTest() throws Exception{
        assertEquals(false,LoginActivity.isPasswordValid(password1));
        assertEquals(true,LoginActivity.isPasswordValid(password2));
    }

    @After
    public void tearDown() throws Exception {}
}