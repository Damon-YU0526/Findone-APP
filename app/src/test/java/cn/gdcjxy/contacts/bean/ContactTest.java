package cn.gdcjxy.contacts.bean;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * ContactTest
 */
public class ContactTest {

    private static Contact contact;
    private static long ID;
    private static String NAME;
    private static String PHONE;

    @Before
    public void setUp() throws Exception {
        ID=3L;
        NAME = "Mr Wang";
        PHONE = "15878459625";
        contact = new Contact(NAME,PHONE);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getId() {
        assertEquals(java.util.Optional.of(ID),contact.getId());
    }

    @Test
    public void getName() {
        assertEquals(NAME,contact.getName());
    }

    @Test
    public void getTel() {
        assertEquals(PHONE,contact.getTel());
    }
}