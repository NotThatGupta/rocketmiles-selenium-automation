package com.rocketmiles.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * rocketmiles.com home page
 */

public class HomePage extends BasePage {

  public static String windowTitle = "Rocketmiles";

  public HomePage(WebDriver driver) {
    super(driver);
  }

  //sign up modal elements
  @FindBy(id = "new-sign-up-modal")
  public WebElement signUpModal;

  @FindBy(css = "button.close")
  public WebElement signUpModalClose;

  //search location elements
  @FindBy(css = "div.tt-dataset-currentLocation > span > div > p > span")
  public WebElement currentLocation;

  @FindBy(css = "span.twitter-typeahead")
  @CacheLookup
  public WebElement locationInput;

  @FindAll({@FindBy(css = "div.tt-suggestion")})
  public List<WebElement> locationSuggestions;

  //search rewards program elements
  @FindBy(css = "div.col-sm-6.program.search-field.wide-program-dropdown")
  @CacheLookup
  public WebElement rewardsDropdown;

  @FindAll({@FindBy(css = "ul.dropdown-menu > li > a")})
  public List<WebElement> rewardsPrograms;

  //date picker elements
  @FindBy(css = "span.ui-datepicker-month")
  public WebElement currentMonth;

  @FindBy(css = "span.ui-datepicker-year")
  public WebElement currentYear;

  @FindBy(css = "a.ui-datepicker-next")
  public WebElement datePickerNext;

  @FindBy(css = "div.checkin.booking-date")
  public WebElement checkinDateField;

  @FindAll({@FindBy(css = "a.ui-state-default")})
  public List<WebElement> checkinDates;

  @FindBy(css = "div.checkout.booking-date")
  public WebElement checkoutDateField;

  @FindAll({@FindBy(css = "a.ui-state-default")})
  public List<WebElement> checkoutDates;

  //number of guests dropdown
  @FindBy(css = "div.adults")
  public WebElement guestsDropdown;

  @FindAll({@FindBy(css = "div.adults > div > div > ul > li > a")})
  public List<WebElement> guestsDropdownElements;

  //number of rooms dropdown
  @FindBy(css = "div.rooms")
  public WebElement roomsDropdown;

  @FindAll({@FindBy(css = "div.rooms > div > div > ul > li > a")})
  public List<WebElement> roomsDropdownElements;

  //search button
  @FindBy(css = "button.rm-btn-orange.search-submit-btn")
  public WebElement searchButton;
}