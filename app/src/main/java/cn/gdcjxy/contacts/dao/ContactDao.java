package cn.gdcjxy.contacts.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cn.gdcjxy.contacts.bean.Contact;

/**
 * ContactDao dao class
 */
public class ContactDao {
    private static MyHelper helper;

    public ContactDao(Context context) {
        helper = new MyHelper(context); // create helper
    }

    public void insert(Contact contact) {
        SQLiteDatabase db = helper.getWritableDatabase(); // get database
        // insert value
        ContentValues values = new ContentValues();
        values.put("name", contact.getName());
        values.put("tel", contact.getTel());
        long id = db.insert("contact", null, values); // insert values
        contact.setId(id);  // getId
        db.close();         // close database
    }

    //delete data
    public static int delete(long id) {
        SQLiteDatabase db = helper.getWritableDatabase();
        //delete data nums
        int count = db.delete("contact", "_id=?", new String[]{id + ""});
        db.close();
        return count;
    }

    //update data
    public static int update(Contact contact) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues(); // alter data
        values.put("name", contact.getName());
        values.put("tel", contact.getTel());
        int count = db.update("contact", values, "_id=?",
                new String[]{contact.getId() + ""}); // update
        db.close();
        return count;
    }

    //queryAll
    public List<Contact> queryAll() {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.query("contact", null, null, null, null, null,
                "_id");
        List<Contact> list = new ArrayList<Contact>();
        while (c.moveToNext()) {
            @SuppressLint("Range") long id = c.getLong(c.getColumnIndex("_id")); // getId
            String name = c.getString(1);
            String tel = c.getString(2);
            list.add(new Contact(id, name, tel));
        }
        c.close();
        db.close();
        return list;
    }

    //query more data
    public List<Contact> queryByName(String name) {
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.rawQuery("select * from contact where name like '%" + name + "%'", null);
        List<Contact> list = new ArrayList<Contact>();
        while (c.moveToNext()) {
            int index = c.getColumnIndex("_id");
            long id = c.getLong(index); // getIndex
            String sname = c.getString(1);
            String tel = c.getString(2);
            list.add(new Contact(id, sname, tel));
        }
        c.close();
        db.close();
        return list;
    }
    //query one data
    public List<Contact> queryByTel(String tel) {
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.rawQuery("select * from contact where tel='" + tel + "'", null);
        List<Contact> list = new ArrayList<Contact>();
        while (c.moveToNext()) {
            int index  = c.getColumnIndex("_id");
            long id = c.getLong(index); // getIndex
            String name = c.getString(1);
            String stel = c.getString(2);
            list.add(new Contact(id, name, stel));
        }
        c.close();
        db.close();
        return list;
    }
}
