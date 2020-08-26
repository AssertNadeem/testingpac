package com.xero.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static xeroUtilities.numberUtilities.*;

public class AccountingPage{

    WebDriver driver;

    public AccountingPage(WebDriver ldriver) {
        this.driver = ldriver;
    }

    // Accounting button in main ribbon.
    @FindBy(how = How.XPATH, using="//button[@name='navigation-menu/accounting']")
    WebElement acc_button;

    // Main ribbon button Bank Account.
    @FindBy(how = How.XPATH, using="//a[contains(text(),'Bank accounts')]")
    WebElement bank_acc_button;

    // Add bank account button.
    @FindBy(how = How.XPATH, using="//div[contains(@class,'button')]//a")
    WebElement add_bank_btn;

    // Select Bank from search.
    @FindBy(how = How.XPATH, using="//input[@placeholder='Search for your bank...']")
    WebElement search_bar;

    // Select Bank from search.
    @FindBy(how = How.XPATH, using="//ul[@id='dataview-1025']//li[contains(text(),'ANZ (NZ)')]")
    WebElement acc_list_sel;

    //Account Details
    //Account name.
    @FindBy(how = How.XPATH, using="//input[contains(@name,'accountname')]")
    WebElement acc_name;

    //Account type.
    @FindBy(how = How.XPATH, using="//input[@placeholder='Please select one']")
    WebElement acc_type;

    //Account Number.
    @FindBy(how = How.XPATH, using="//div[4]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//input[1]")
    WebElement acc_number;

    //Continue button.
    @FindBy(how = How.XPATH, using="//span[contains(text(),'Continue')]")
    WebElement continue_button;

    //Connect with bank title
    @FindBy(how = How.XPATH, using="//h1[@class='xui-pageheading--title']")
    WebElement connect_title;

    //methods to add account
    //Accounting button on the main ribbon
    public void setAcc_button() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        acc_button.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //Bank accounts button
    public void setBank_acc_button() {
        bank_acc_button.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //Add bank account button
    public void setAdd_bank_btn() {
        add_bank_btn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //Search bar
    public void setSearch_bar(String b) {
        search_bar.click();
        search_bar.sendKeys(b);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        acc_list_sel.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void setAcc_details(){
       //set account name - it has to be unique
        //Insert randomly generated strings
        String op = generateRandomAccountNames();
        acc_name.sendKeys(op);

        //set account type
        acc_type.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        acc_type.sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        acc_type.sendKeys(Keys.TAB);
        //Account number
        // Generate a random 15 digit number for account


        String nAcc = generateRandomAccountNumbers();
        acc_number.sendKeys(nAcc);

        //press continue button
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        continue_button.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public String setConnect_title() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String ds = connect_title.getText();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return ds;
    }


}
