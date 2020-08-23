
package com.openclassrooms.entrevoisins.neighbour_list;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.rule.IntentsTestRule;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.ui.neighbour_list.DetailsNeighbourActivity;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.security.Provider;

import static android.service.autofill.Validators.not;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParentIndex;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;


/**
 * Test class for list of neighbours
 */
@RunWith(JUnit4.class)
public class NeighboursListTest {

    // This is fixed
    private static int ITEMS_COUNT = 12;

    private NeighbourApiService mApiService;

    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(Matchers.allOf(isDisplayed(), withId(R.id.list_neighbours)))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(Matchers.allOf(isDisplayed(), withId(R.id.list_neighbours))).check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(Matchers.allOf(isDisplayed(), withId(R.id.list_neighbours)))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(Matchers.allOf(isDisplayed(), withId(R.id.list_neighbours))).check(withItemCount(ITEMS_COUNT - 1));
    }

    @Test
    public void myNeighboursList_detailsAction_shouldOpenDetails (){
        onView(Matchers.allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }

    @Test
    public void myNeighbourList_detailsAction_shouldDisplayNeighbourDetails (){
        onView(Matchers.allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.first_neighbour_name)).check(matches(withText("Caroline")));
    }

    @Test
    public void myNeighboursList_favoriteAction_setInFavoriteList (){
        onView(Matchers.allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.floating_action_button)).perform(click());
        Espresso.pressBack();
        onView(withContentDescription("favorites")).perform(click());
        onView(Matchers.allOf(withId(R.id.list_neighbours), isDisplayed())).check(matches(withText("Caroline")));


    }
}

    /*
    @Test
    public void onFabClick_shouldDisplaySnackbar() {
        onView(withText("Caroline"))


    }

    @Test
    public void activityResult_DisplaysDetailsNeighbourActivity() {
        // Build the result to return when the activity is launched.
        Intent resultData = new Intent();
        String neighbourName = "Caroline";
        resultData.putExtra("Caroline", neighbourName);
        mActivityRule.launchActivity(resultData);
        onView(Matchers.allOf(isDisplayed(), withId(R.id.list_neighbours)))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        intended(hasComponent(DetailsNeighbourActivity.class.getName()));
    }

*/
