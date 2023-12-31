package cn.gdcjxy.contacts.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import cn.gdcjxy.contacts.MainActivity;
import cn.gdcjxy.contacts.R;
import cn.gdcjxy.contacts.bean.Contact;
import cn.gdcjxy.contacts.dao.ContactDao;

public class AddActivity extends AppCompatActivity {

    private EditText editText_name;
    private EditText editText_tel;
    private Button button_add;

    // getListData
    private static List<Contact> list;
    // database class
    private static ContactDao dao;

    String name;
    String tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        initView();

        dao = new ContactDao(this);
        // query all data
        list = dao.queryAll();
    }

    private void initView() {
        editText_name = (EditText) findViewById(R.id.editText_name);
        editText_tel = (EditText) findViewById(R.id.editText_tel);
        button_add = (Button) findViewById(R.id.button_add);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View focusView = null;
                boolean cancel = false;
                name = editText_name.getText().toString().trim();
                tel = editText_tel.getText().toString().trim();
                if (TextUtils.isEmpty(name)) {
                    editText_name.setError(getString(R.string.error_field_required));
                    focusView = editText_name;
                    cancel = true;
                }
                if (TextUtils.isEmpty(tel)) {
                    editText_tel.setError(getString(R.string.error_field_required));
                    focusView = editText_tel;
                    cancel = true;
                }
                if (cancel) {
                    focusView.requestFocus();
                } else {
                    insert(name,tel);
                    editText_name.setText("");
                    editText_tel.setText("");
                    Toast.makeText(AddActivity.this,"add friends success",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddActivity.this, MainActivity.class));
                }
            }
        });
    }

    public static boolean insert(String name,String tel) {
        Contact c = new Contact(name, tel);
        dao.insert(c);                      // insert database
        list.add(c);                        // insert list
        return true;
    }

}