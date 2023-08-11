package cn.gdcjxy.contacts.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.gdcjxy.contacts.R;
import cn.gdcjxy.contacts.bean.User;
import cn.gdcjxy.contacts.dao.UserDao;

public class RegisterActivity extends AppCompatActivity {

    private EditText mRegisterEmailView;
    private EditText mRegisterPasswordView;
    // list
    private List<User> list;
    // dao
    private UserDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Set up the Register form.
        mRegisterEmailView = (EditText) findViewById(R.id.register_form_email);

        mRegisterPasswordView = (EditText) findViewById(R.id.register_form_password);
        mRegisterPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    // attemptRegister();
                    return true;
                }
                return false;
            }
        });

        Button mRegisterButton = (Button) findViewById(R.id.register_button);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptRegister();
            }
        });

        dao = new UserDao(this);
        // query all data
        list = dao.queryAll();
    }

    private void attemptRegister() {

        // Reset errors.
        mRegisterEmailView.setError(null);
        mRegisterPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mRegisterEmailView.getText().toString();
        String password = mRegisterPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password)) {
            mRegisterPasswordView.setError(getString(R.string.error_field_required));
            focusView = mRegisterPasswordView;
            cancel = true;
        }else if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mRegisterPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mRegisterPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mRegisterEmailView.setError(getString(R.string.error_field_required));
            focusView = mRegisterEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mRegisterEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mRegisterEmailView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {

            register(email,password);
            Toast.makeText(this,"register success",Toast.LENGTH_SHORT).show();
            Intent mIntent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(mIntent);
        }
    }

    public static boolean isEmailValid(String email) {
        return email.contains("@");
    }

    public static boolean isPasswordValid(String password) {
        if(password.contains(" ") || password.length() < 4){
            return false;
        }
        return true;
    }

    public  void register(String email,String password) {
        User a = new User(email, password);
        dao.insert(a);                      // insert database
        list.add(a);                        // insert list
    }
}