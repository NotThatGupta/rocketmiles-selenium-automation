package com.rocketmiles.search.parameters;

import com.rocketmiles.base.BaseTest;
import com.rocketmiles.page.HomePage;
import com.rocketmiles.page.ResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

/**
 * base class for search tests
 *
 */
public class SearchTestsBase extends BaseTest {
    private HomePage homePage;
    private ResultsPage resultsPage;

    public SearchRewardsProgram rewardsProgram;
    public SearchLocation location;
    public SearchDate searchDate;
    public SearchGuests searchGuests;
    public SearchRooms searchRooms;

    @BeforeClass
    public void beforeClass() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        rewardsProgram = new SearchRewardsProgram(driver);
        location = new SearchLocation(driver);
        searchDate = new SearchDate(driver);
        searchGuests = new SearchGuests(driver);
        searchRooms = new SearchRooms(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @DataProvider(name = "TopLocations")
    public static Object[][] topLocations() {
        return new Object[][] {
                {DEFAULT_LOCATIONS.new_york},
                {DEFAULT_LOCATIONS.chicago},
                {DEFAULT_LOCATIONS.london},
                {DEFAULT_LOCATIONS.san_fran},
                {DEFAULT_LOCATIONS.tokyo},
                {DEFAULT_LOCATIONS.la},
                {DEFAULT_LOCATIONS.toronto},
                {DEFAULT_LOCATIONS.boston},
                {DEFAULT_LOCATIONS.vancouver},
                {DEFAULT_LOCATIONS.vegas}
        };
    }

    public void conductCurrentLocationSearch(String rewards, String startYear, String startMonth, String startDate,
                                             String endYear, String endMonth, String endDate, int numGuests,
                                             int numRooms) {
        homePage = PageFactory.initElements(driver, HomePage.class);

        //set search parameters
        location.selectCurrentLocation();
        rewardsProgram.selectRewardsProgram(rewards);
        searchDate.setSearchStartDate(startYear, startMonth, startDate);
        searchDate.setSearchEndDate(endYear, endMonth, endDate);
        searchGuests.selectNumberOfGuests(numGuests);
        searchRooms.selectNumRooms(numRooms);

        //conduct search
        homePage.searchButton.click();
        waitForNumberOfSeconds(10);
        waitForElementToBeInvisible(60, By.id("searchTransition"));

        //verify location on results page
        Assert.assertEquals(driver.getTitle(), "Rocketmiles - Hotel search result");
    }

    public void conductTopLocationSearch(DEFAULT_LOCATIONS topLocation, String rewards, String startYear, String startMonth, String startDate,
                                         String endYear, String endMonth, String endDate, int numGuests,
                                         int numRooms) {
        homePage = PageFactory.initElements(driver, HomePage.class);

        //set search parameters
        location.selectDefaultLocation(topLocation);
        rewardsProgram.selectRewardsProgram(rewards);
        searchDate.setSearchStartDate(startYear, startMonth, startDate);
        searchDate.setSearchEndDate(endYear, endMonth, endDate);
        searchGuests.selectNumberOfGuests(numGuests);
        searchRooms.selectNumRooms(numRooms);

        //conduct search
        homePage.searchButton.click();
        waitForNumberOfSeconds(10);
        waitForElementToBeInvisible(60, By.id("searchTransition"));

        //verify location on results page
        Assert.assertEquals(driver.getTitle(), "Rocketmiles - Hotel search result");
    }
}
