package com.westpac.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    WebDriver driver;


    //constructor to initialize driver passed by page Factory
    public LoginPage(WebDriver ldriver) {
        this.driver = ldriver;
    }

    //Login page object - email
    @FindBy(how = How.XPATH, using="//input[@id='email']")
    @CacheLookup
    WebElement  login_email;

    //Login page object - password
    @FindBy(how = How.XPATH, using="//input[@id='password']")
    WebElement  login_pwd;

    //Login page object - log in button
    @FindBy(how = How.XPATH, using="//*[@id=\"submitButton\"]")
    WebElement  login_btn_hp;

    //Page title
    @FindBy(how = How.XPATH, using="//*[@id=\"contentTop\"]/div[2]/div[1]/h2")
    WebElement win_banner;

    //set values thru methods

    public void setLogin_email(String l_email){
        login_email.sendKeys(l_email);
    }

    public void getLogin_pwd(String passw) {
        login_pwd.sendKeys(passw);
    }

    public String setWin_banner() {
        String gt = win_banner.getText();
        return gt;
    }

    public void setLogin_btn_hp() {
        driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
        login_btn_hp.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
