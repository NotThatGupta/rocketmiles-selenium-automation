package com.rocketmiles.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * rocketmiles.com search results page
 */
public class ResultsPage extends BasePage {

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css ="div.search-summary-and-helper-block > span > var:nth-child(3)")
    public WebElement resultsPageLocation;
}
