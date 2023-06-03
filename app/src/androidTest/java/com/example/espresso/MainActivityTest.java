package com.example.espresso;


import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Rule;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.click;

import android.view.View;
import android.widget.TextView;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule < MainActivity > activityScenarioRule = new ActivityScenarioRule <>(MainActivity.class);

    @Test
    public void emailInputFieldTest() {
        onView(withId(R.id.emailEditText)).perform(typeText("example@email.com"), closeSoftKeyboard());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withId(R.id.validationTextView)).check(matches(withText("Email is valid")));
    }

    @Test
    public void testInvalidEmail() {
        onView(withId(R.id.emailEditText)).perform(typeText("examplegmail.com"), closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.validationTextView)).check(matches(withText("Email is invalid")));
    }
}
