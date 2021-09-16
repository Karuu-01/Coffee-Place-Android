package com.moringaschool.coffeeplace;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.anything;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.moringaschool.coffeeplace.ui.GalleryListActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RestaurantActivityInstrumentationTest {
    @Rule
    public ActivityScenarioRule<GalleryListActivity> activityTestRule =
            new ActivityScenarioRule<>(GalleryListActivity.class);

    private View activityDecorView;

    @Before
    public void setUp() {
        activityTestRule.getScenario().onActivity(new ActivityScenario.ActivityAction<GalleryListActivity>() {
            @Override
            public void perform(GalleryListActivity activity) {
                activityDecorView = activity.getWindow().getDecorView();
            }
        });
    }

    @Test
    public void listItemClickDisplaysToastWithCorrectPlace() {
        String place = "Bamburi Beach";
        onData(anything())
                .inAdapterView(withId(R.id.recyclerView))
                .atPosition(0)
                .perform(click());
        onView(withText(place))
                .inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(place)));
    }
}
