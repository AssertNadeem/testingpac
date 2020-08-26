package com.xero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

public class XeroHomePage {

    WebDriver driver;

    public XeroHomePage(WebDriver ldriver) {
     this.driver = ldriver;

    }

    // FreeTrialPage button
    @FindBy(how = How.XPATH, using="//a[@class='btn btn-primary global-ceiling-bar-btn']")
    WebElement reg_button;

    //login button
    @FindBy(how = How.XPATH, using="//a[@class='btn btn-tertiary-alt global-ceiling-bar-btn']")
    WebElement login_btn;

    //method to register if not already registered
    public void setReg_button() {
        reg_button.click();
    }

    //method to login to the registered account
    public void setLogin_btn() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        login_btn.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
