package com.rocketmiles.search.parameters;

import com.rocketmiles.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * Set rewards program parameter
 *
 */
public class SearchRewardsProgram {

    public HomePage homePage;
    private final WebDriver driver;

    public SearchRewardsProgram (WebDriver driver) {
        this.driver = driver;
    }

    public void selectRewardsProgram(String rewardsProgram) {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.rewardsDropdown.click();
        for (WebElement el: homePage.rewardsPrograms) {
            if (el.getText().equals(rewardsProgram)) {
                el.click();
                break;
            }
        }
    }
}