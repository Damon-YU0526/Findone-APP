package cn.gdcjxy.contacts.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyHelper extends SQLiteOpenHelper {
    // no function
    public MyHelper(Context context) {
        super(context, "gdcjxy.db", null, 2);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "email VARCHAR(50)," + // email
                "password VARCHAR(50))"); // phone
        db.execSQL("CREATE TABLE contact(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name VARCHAR(20)," + // name
                "tel VARCHAR(11))"); // phone
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("onUpgrade");
    }
}
