package com.rocketmiles.search;

import com.rocketmiles.page.ResultsPage;
import com.rocketmiles.search.parameters.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * a couple of basic search tests
 *
 */
public class SearchTests extends SearchTestsBase {
    ResultsPage resultsPage;

    @Test (dataProvider = "TopLocations")
    public void testTopLocationsSearches(DEFAULT_LOCATIONS topLocation) {
        resultsPage = PageFactory.initElements(driver, ResultsPage.class);
        //conduct searches and verify top locations
        conductTopLocationSearch(topLocation, "United MileagePlus", "2017", "December", "29",
                "2018", "January", "2", 4, 2);

        //assert location on results page
        Assert.assertEquals(resultsPage.resultsPageLocation.getText(), topLocation.getDisplayName());
    }

    @Test
    public void testCurrentLocationSearch() {
        //conduct search and verify current location
        resultsPage = PageFactory.initElements(driver, ResultsPage.class);
        conductCurrentLocationSearch("United MileagePlus", "2017", "December", "29",
                "2018", "January", "2", 4, 2);

        //assert location on results page
        Assert.assertEquals(resultsPage.resultsPageLocation.getText(), DEFAULT_LOCATIONS.chicago.getDisplayName());
    }
}