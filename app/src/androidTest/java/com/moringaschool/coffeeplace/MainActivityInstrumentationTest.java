package com.moringaschool.coffeeplace;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentationTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void validateEditText() {
        onView(withId(R.id.galleryEditText)).perform(typeText("Rwanda"))
                .check(matches(withText("Rwanda")));
    }

    @Test
    public void locationOfPlaceIsSentToGalleryActivity() {
        String gallery= "Rwanda";
        onView(withId(R.id.galleryEditText)).perform(typeText(gallery)).perform(closeSoftKeyboard());
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            System.out.println("got interrupted!");
        }
        onView(withId(R.id.FindPlacesButton)).perform(click());
        onView(withId(R.id.galleryTextView)).check(matches(withText("Here are all the places near: " + gallery)));
    }


}
