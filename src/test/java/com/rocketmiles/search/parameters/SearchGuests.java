package com.rocketmiles.search.parameters;

import com.rocketmiles.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Object for setting number of guests parameter
 *
 */
public class SearchGuests {
    private HomePage homePage;
    private final WebDriver driver;

    public SearchGuests (WebDriver driver) {
        this.driver = driver;
    }

    public void selectNumberOfGuests(int numGuests) {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.guestsDropdown.click();
        homePage.guestsDropdownElements.get(numGuests - 1).click();
    }
}
