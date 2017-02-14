package com.rocketmiles.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Base page class
 */

public abstract class BasePage {

  protected WebDriver driver;

  /*
   * Constructor
   *
   * @param webDriver
   */
  public BasePage(WebDriver driver) {
    this.driver = driver;
  }


}
