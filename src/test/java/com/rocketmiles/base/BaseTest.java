package com.rocketmiles.base;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.*;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;

import ru.stqa.selenium.factory.WebDriverPool;

import com.rocketmiles.util.PropertyLoader;
import com.rocketmiles.page.HomePage;

/**
 * Base class for Tests
 */
public class BaseTest {

  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static Capabilities capabilities;

  protected WebDriver driver;
  protected HomePage homePage;

  @BeforeSuite
  public void initTestSuite() throws IOException {
    baseUrl = PropertyLoader.loadProperty("site.url");
    gridHubUrl = PropertyLoader.loadProperty("grid.url");
    if (gridHubUrl.equals("")) {
      gridHubUrl = null;
    }

    //set driver locations here
    System.setProperty("webdriver.chrome.driver", "C:\\selenium-drivers\\chromedriver_win32\\chromedriver.exe");
    System.setProperty("webdriver.gecko.driver","C:\\selenium-drivers\\geckodriver-v0.14.0-win64\\geckodriver.exe");

    capabilities = PropertyLoader.loadCapabilities();
  }

  @BeforeMethod
  public void initWebDriver() {
    driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
    initialNavigation();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    WebDriverPool.DEFAULT.dismissAll();
  }

  public void initialNavigation() {
    homePage = PageFactory.initElements(driver, HomePage.class);

    driver.get(baseUrl);
    waitForLoad(60);
    //driver.manage().window().maximize();
    Assert.assertEquals(driver.getTitle().substring(0,11), homePage.windowTitle,
            "Unexpected window title for the rocketmiles.com home page.");

    //if closeSignUpModal is set to true, close sign up modal
    try {
      waitForExpectedElement(5, homePage.signUpModal);
      homePage.signUpModalClose.click();
      waitForElementToBeInvisible(3, By.id("new-sign-up-modal"));
    } catch (NoSuchElementException e) {

    } catch (TimeoutException e) {

    }
  }

  public void waitForLoad(int seconds) {
    driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
  }

  public void waitForExpectedElement(int seconds, WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, seconds);
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public void waitForNumberOfSeconds(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {

    }
  }

  public void waitForElementToBeInvisible(int seconds, By selectorBy) {
    WebDriverWait wait = new WebDriverWait(driver, seconds);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(selectorBy));
  }
}