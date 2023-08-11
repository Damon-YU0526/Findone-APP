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
public class AddActivityUITest {

    private static final String NAME_ADD="Mr Wang";
    private static final String PHONE_ADD="12374589856";

    @Rule
    public ActivityTestRule<AddActivity> mActivityTestRule =
            new ActivityTestRule<>(AddActivity.class);

    @Test
    public void AddActivityUITest() throws Exception{
        onView(withId(R.id.editText_name)).perform(clearText());
        onView(withId(R.id.editText_tel)).perform(clearText());
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        //input
        onView(withId(R.id.editText_name)).perform(typeText(NAME_ADD),closeSoftKeyboard());
        onView(withId(R.id.editText_tel)).perform(typeText(PHONE_ADD),closeSoftKeyboard());
        onView(withId(R.id.button_add)).perform(click());
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
