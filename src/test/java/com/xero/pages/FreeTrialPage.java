package com.xero.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

//FreeTrialPage is a class that holds all the page objects of the FreeTrialPage form
public class FreeTrialPage{

    WebDriver driver;

    //Constructor to initialise driver
    public FreeTrialPage(WebDriver ldriver) {
        this.driver = ldriver;
    }

    //Xpath to identify Register button element from the form
    @FindBy(how = How.XPATH, using="//span[@class='g-recaptcha-submit']")
    WebElement  registerbtn;

    //Xpath to identify first name input element from the form
    @FindBy(how = How.XPATH, using="//input[@name='FirstName']")
    WebElement first_name;

    //Xpath to identify last name input element from the form
    @FindBy(how = How.XPATH, using="//input[@name='LastName']")
    WebElement last_name;

    //Xpath to identify email input element from the form
    @FindBy(how = How.XPATH, using="//input[@name='EmailAddress']")
    WebElement  email_id;

    //Xpath to identify phone number input element from the form
    @FindBy(how = How.XPATH, using="//input[@name='PhoneNumber']")
    WebElement  phone_number;

    //Xpath to identify country input element from the form
    @FindBy(how = How.XPATH, using="//select[@name='LocationCode']")
    WebElement  select_country;

    //Xpath to identify recaptcha checkbox input element from the form
    @FindBy(how = How.XPATH, using="//*[@id=\"recaptcha-anchor\"]/div[4]")
    WebElement  recaptcha_checkbox;

    //Xpath to identify terms and conditions element from the form
    @FindBy(how = How.XPATH, using="//input[@name='TermsAccepted']")
    WebElement  tconditions;

   // method to run all the elements
    public void setFirst_name(String firstname) {
        first_name.sendKeys(firstname);
    }

    public void setLast_name(String lastname) {
        last_name.sendKeys(lastname);
    }

    public void setEmail_id(String emailid) {
        email_id.sendKeys(emailid);
    }

    public void setPhone_number(String pnumber) {
        phone_number.sendKeys(pnumber);
    }

    public void setSelect_country(String c){
        //Select the country
        select_country.click();
        Select dropdowns = new Select(select_country);
        dropdowns.selectByValue(c);
    }

    public void setRecaptcha_checkbox() {
        //select the recaptcha checkbox
        recaptcha_checkbox.click();
    }

    public void setTconditions() {
        //Accept terms and conditions
        tconditions.click();
    }

    public void setRegisterbtn() {
        //click the register button
        driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
        registerbtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

}
