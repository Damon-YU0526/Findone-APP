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
public class RegisterUITest {

    private static final String EMAIL_REGISTER="168@qq.com";
    private static final String PASSWORD_REGISTER="123456";

    @Rule
    public ActivityTestRule<RegisterActivity> mActivityTestRule =
            new ActivityTestRule<>(RegisterActivity.class);

    @Test
    public void RegisterUITest() throws Exception{
        onView(withId(R.id.register_form_email)).perform(clearText());
        onView(withId(R.id.register_form_password)).perform(clearText());
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        //input
        onView(withId(R.id.register_form_email)).perform(typeText(EMAIL_REGISTER),closeSoftKeyboard());
        onView(withId(R.id.register_form_password)).perform(typeText(PASSWORD_REGISTER),closeSoftKeyboard());
        onView(withId(R.id.register_button)).perform(click());
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
