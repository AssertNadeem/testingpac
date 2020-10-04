package com.westpac.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static westpacUtilities.westpacUtilities.fetchMyProperties;

public class WestpacHomePage {

    WebDriver driver;

    public WestpacHomePage(WebDriver ldriver) {
     this.driver = ldriver;
    }

    @BeforeMethod
    public void setUp() {

    }

    // Westpac KiwiSaver Scheme Retirement Calculator flow
    //kiwisaver link on homepage
    @FindBy(how = How.CSS, using="#ubermenu-section-link-kiwisaver-ps")
    WebElement kiwisaver_main_link;

    //kiwisaver calculator button
    @FindBy(how = How.CSS, using="#ubermenu-item-cta-kiwisaver-calculators-ps")
    WebElement calc_ks_btn;

    //kiwisaver calculator button
    @FindBy(how = How.XPATH, using="//a[contains(text(),'Click here to get started.')]")
    WebElement getStarted_ks_btn;

    //Setup Functions

    //Navigate to calculate kiwisaver page
    public void setCalculateKiwiSaverPage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String cUrl = null;

        try {
            cUrl = fetchMyProperties("calcUrl");
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.navigate().to(cUrl); // Directly navigates to the KiwiSaver page.

    }

    //Navigate to calculate kiwisaver
    public void setKiwisaver_main_link() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Instantiate Action Class
        Actions actions = new Actions(driver);
        //Retrieve WebElement 'KiwiSaver link' to perform mouse hover
        WebElement menuOption = driver.findElement(By.cssSelector("#ubermenu-section-link-kiwisaver-ps"));
        //Mouse hover menuOption 'KiwiSaver'
        actions.moveToElement(menuOption).perform();

    }
    //click kiwisaver calculator button
    public void setCalc_ks_btn() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        calc_ks_btn.click();
        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
    }

    //click on the get started button
    public void setGetStarted_ks_btn() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getStarted_ks_btn.click();
    }

}
