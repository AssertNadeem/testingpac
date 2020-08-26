package com.xero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

public class CompanyDetailsPage{

    /* https://go.xero.com/app/onboarding-ui */

    WebDriver driver;

    //Constructor
    public CompanyDetailsPage(WebDriver ldriver) {
        this.driver = ldriver;
    }

    // what is the name of your organisation.
    @FindBy(how = How.XPATH, using="//input[contains(@id,'-control')]")
    WebElement org_name;

    // where does your organisation pay tax.
    @FindBy(how = How.XPATH, using="//div[@id='organisation-country']//div//div//div//div//div//div//button//div")
    WebElement pay_tax;
    //where does your organisation pay tax - selection
    @FindBy(how = How.XPATH, using="//li[@id='CNTRY/NZ']//button//span//span//strong")
    WebElement pay_tax_c;

    //what is your time zone - drop down.
    @FindBy(how = How.XPATH, using="//div[@id='organisation-timezone']//div//div//div//div//div//div//button//div")
    WebElement time_zone;
    //what is your time zone - selection
    @FindBy(how = How.XPATH, using="//li[@id='TIMEZONE/NEWZEALANDSTANDARDTIME']//button//span//span")
    WebElement time_zone_sel;

    //what does your organisation do.
    @FindBy(how = How.XPATH, using="//input[@placeholder='e.g. plumbing, engineering, real estate']")
    WebElement  org_work;
    //what does your organisation do - selection.
    @FindBy(how = How.XPATH, using="//span[contains(text(),'Consultancy Services')]")
    WebElement  org_work_sel;

    //Are you registered for GST.
    @FindBy(how = How.XPATH, using="//div[@class='xui-styledcheckboxradio--checkbox xui-styledcheckboxradio--checkbox-small']")
    WebElement  gst_yes_no;

    //What was your previous accounting software.
    @FindBy(how = How.XPATH, using="//body/div[@id='shell-app-root']/div/div/div/div/div/form/div/div/div/div/div/div/button[1]")
    WebElement  previous_sw;
    //What was your previous accounting software - selection.
    @FindBy(how = How.XPATH, using="//li[@id='MYOB']//button//span")
    WebElement  previous_sw_sel;


    //Start trial button.
    @FindBy(how = How.XPATH, using="//body/div[@id='shell-app-root']/div/div/div/div/div/form/div/div/button[1]")
    WebElement  Start_trial_button;

    //Set organisation name
    public void setOrg_name(String oname) {
        org_name.sendKeys(oname);
    }

    //Set tax country
    public void setPay_tax() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //click the drop down
        pay_tax.click();

        //select New Zealand
        pay_tax_c.click();

    }

    //set time zone
    public void setTime_zone() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //click the drop down
        time_zone.click();

        //select New Zealand timezone
        time_zone_sel.click();
    }
    //set what the organisation does
    public void setOrg_work() {
        org_work.click();
        org_work.sendKeys("IT");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //selection from the list
        org_work_sel.click();

    }

    //set are you gst registered
    public void setGst_yes_no() {

        //select the option if it is only not already selected.
        System.out.println(gst_yes_no.isDisplayed());

        if (!gst_yes_no.isDisplayed()){
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            gst_yes_no.click();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
          }

    }

    //set previous accounting software
    public void setPrevious_sw() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //click the drop down
        previous_sw.click();

        //select the previous software
        previous_sw_sel.click();
    }

    //set button click
    public void setStart_trial_button() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Start_trial_button.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
