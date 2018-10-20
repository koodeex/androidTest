package com.example.user.uitestsbt;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class UITestSber {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void sampleUITest() throws Exception{
        // click button
        onView(withId(R.id.loginButton)).perform(click());
        Thread.sleep(TestData.WAIT_TIME);

        // click button
        onView(withId(R.id.accChoose)).perform(click());
        Thread.sleep(TestData.WAIT_TIME);

        // Enter Text and click
        onView(withId(R.id.loginField)).perform(typeText(TestData.LOGIN));
        onView(withId(R.id.nextStep)).perform(click());
        Thread.sleep(TestData.WAIT_TIME);

        //Enter pin
        char[] pin = TestData.PIN.toCharArray();
        for (int i = 0; i < pin.length; i++ ){
            onView(withText(String.valueOf(pin[i]))).perform(click());
        }
        Thread.sleep(TestData.WAIT_TIME);

        //Repeat pin
        for (int i = 0; i < pin.length; i++ ){
            onView(withText(String.valueOf(pin[i]))).perform(click());
        }
        Thread.sleep(TestData.WAIT_TIME * 4);

        //Navigate and click to the target button
        onView(withId(R.id.viewpager)).perform(swipeLeft());
        Thread.sleep(TestData.WAIT_TIME);
        onView(withId(R.id.viewpager)).perform(swipeUp());
        Thread.sleep(TestData.WAIT_TIME);
        onView(withText(TestData.MAIN_MENU_TARGET_BUTTON_TEXT)).perform(click());
        Thread.sleep(TestData.WAIT_TIME);

        onData(anything()).atPosition(0).perform(click());
        Thread.sleep(TestData.WAIT_TIME);

        onView(withText(TestData.ONE_BUTTON_TEXT)).perform(click());
        Thread.sleep(TestData.WAIT_TIME);

        onView(withId(R.id.firstOption)).perform(click());
        Thread.sleep(TestData.WAIT_TIME);

        onView(withId(R.id.stsEditText)).perform(typeText(TestData.STS));
        onView(withId(R.id.wuEditText)).perform(typeText(TestData.WU));
        onView(withId(R.id.searchButton)).perform(click());
        Thread.sleep(TestData.WAIT_TIME);

        if (TestData.PAID) {
            onView(withId(R.id.viewpager_penalties)).perform(swipeLeft());
            onData(anything()).atPosition(0).check(matches(withText(containsString(TestData.PENALTY))));
        }
        else {
            onData(anything()).atPosition(0).check(matches(withText(containsString(TestData.PENALTY))));
        }





    }


}