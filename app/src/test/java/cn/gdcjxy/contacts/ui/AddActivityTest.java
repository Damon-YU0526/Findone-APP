package cn.gdcjxy.contacts.ui;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.gdcjxy.contacts.MainActivity;

/**
 * AddActivityTest
 */
public class AddActivityTest {

    private static String  NAME_SUCCESS;
    private static String  PHONE_SUCCESS;

    @Before
    public void setUp() throws Exception {
        NAME_SUCCESS = "Mr Wang";
        PHONE_SUCCESS = "15878459625";
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void insert() {
        assertEquals(true,AddActivity.insert(NAME_SUCCESS,PHONE_SUCCESS));
    }
}