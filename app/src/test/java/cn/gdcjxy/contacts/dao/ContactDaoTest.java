package cn.gdcjxy.contacts.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.gdcjxy.contacts.bean.Contact;

/**
 * ContactDaoTest
 */
public class ContactDaoTest {

    private static int DELETE_ID_SUCCESS;
    private static Contact contact ;
    private static String NAME ;
    private static String PHONE ;

    @Before
    public void setUp() throws Exception {
        NAME = "Mr Wang";
        PHONE = "15878459625";
        DELETE_ID_SUCCESS = 1;
        contact = new Contact(NAME,PHONE);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void delete() {
        assertEquals(1,ContactDao.delete(DELETE_ID_SUCCESS));
    }

    @Test
    public void update() {
        assertEquals(1,ContactDao.update(contact));
    }
}