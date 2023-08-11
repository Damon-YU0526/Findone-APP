package cn.gdcjxy.contacts.ui;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cn.gdcjxy.contacts.R;

@RunWith(AndroidJUnit4.class)
public class LoginUITest {

    private static final String EMAIL_LOGIN="168@qq.com";
    private static final String PASSWORD_LOGIN="123456";

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule =
            new ActivityTestRule<>(LoginActivity.class);


    @Test
    public void LoginUITest() throws Exception{
        onView(withId(R.id.email)).perform(clearText());
        onView(withId(R.id.password)).perform(clearText());
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        //input
        onView(withId(R.id.email)).perform(typeText(EMAIL_LOGIN),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText(PASSWORD_LOGIN),closeSoftKeyboard());
        onView(withId(R.id.email_sign_in_button)).perform(click());
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
