package cn.gdcjxy.contacts.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cn.gdcjxy.contacts.bean.User;

/**
 * UserDao class
 */
public class UserDao {
    private static MyHelper helper;
    public UserDao(Context context) {
        helper = new MyHelper(context); // create dao class
    }
    public void insert(User user) {
        SQLiteDatabase db = helper.getWritableDatabase(); // get database
        // insert value
        ContentValues values = new ContentValues();
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());
        long id = db.insert("user", null, values); // insert values,
        user.setId(id);  // getId
        db.close();         // close database
    }
    //delete data
    public static int delete(long id) {
        SQLiteDatabase db = helper.getWritableDatabase();
        // delete data
        int count = db.delete("user", "_id=?", new String[] { id + "" });
        db.close();
        return count;
    }
    //update
    public static int update(User user) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues(); // alter data
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());
        int count = db.update("user", values, "_id=?",
                new String[] { user.getId() + "" }); // update nums
        db.close();
        return count;
    }
    //query all data
    public List<User> queryAll() {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.query("user", null, null, null, null, null,
                "_id DESC");
        List<User> list = new ArrayList<User>();
        while (c.moveToNext()) {
            @SuppressLint("Range") long id = c.getLong(c.getColumnIndex("_id")); // getIndex
            String email = c.getString(1);
            String password = c.getString(2);
            list.add(new User(id, email, password));
        }
        c.close();
        db.close();
        return list;
    }
    //login
    public  boolean login(String lemail,String lpassword){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.rawQuery("select * from user where email='"+lemail+"' and password='"+lpassword+"'",null);
        while(c.moveToNext()){
            if((c.getString(1).equals(lemail))&&(c.getString(2).equals(lpassword))){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
}
