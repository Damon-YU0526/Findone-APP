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
public class AlterActivityUITest {

    private static final String NAME_ALTER="Mr Wang";
    private static final String PHONE_ALTER="12374589856";

    @Rule
    public ActivityTestRule<AlterActivity> mActivityTestRule =
            new ActivityTestRule<>(AlterActivity.class);


    @Test
    public void AlterActivityUITest() throws Exception{
        onView(withId(R.id.editText_altername)).perform(clearText());
        onView(withId(R.id.editText_altertel)).perform(clearText());
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        //input
        onView(withId(R.id.editText_altername)).perform(typeText(NAME_ALTER),closeSoftKeyboard());
        onView(withId(R.id.editText_altertel)).perform(typeText(PHONE_ALTER),closeSoftKeyboard());
        onView(withId(R.id.button_alter)).perform(click());
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
