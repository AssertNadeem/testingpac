package com.westpac.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;
import static westpacUtilities.westpacUtilities.*;

public class KiwiSaverRetirementCalculatorPage {

    WebDriver driver;

    //constructor to initialize driver passed by page Factory
    public KiwiSaverRetirementCalculatorPage(WebDriver ldriver) {
        this.driver = ldriver;
    }

    //Current age input box
    @FindBy(how = How.XPATH, using="(//input[contains(@type,'text')])[1]")
    @CacheLookup
    WebElement  current_age_in_box;

    //Current age help icon
    @FindBy(how = How.XPATH, using="(//i[contains(@class,'icon')])[1]")
    @CacheLookup
    WebElement  current_age_h_icon;

    //Employment status drop down
    @FindBy(how = How.XPATH, using="//div[@class='well-value ng-binding'][contains(.,'Select')]")
    WebElement  emp_select;

    //job type
    @FindBy(how = How.XPATH, using="//div[@class='label'][contains(.,'Employed')]")
    WebElement jobtype;

    //Employment help icon
    @FindBy(how = How.XPATH, using="(//i[contains(@class,'icon')])[2]")
    WebElement  emp_select_h_icon;

    //Salary input
    @FindBy(how = How.XPATH, using="(//input[contains(@type,'text')])[2]")
    WebElement  salary_in;

    //Salary help icon
    @FindBy(how = How.XPATH, using="(//i[contains(@class,'icon')])[3]")
    WebElement  salary_h_icon;

    //kiwisaver member contribution (4%)
    @FindBy(how = How.XPATH, using="//span[@class='ng-scope'][contains(.,'4%')]")
    WebElement  mem_cont;

    //kiwisaver member contribution (4%) help icon
    @FindBy(how = How.XPATH, using="(//i[contains(@class,'icon')])[4]")
    WebElement  mem_cont_h_icon;

    //Current Kiwisaver balance
    @FindBy(how = How.XPATH, using="(//input[contains(@type,'text')])[2]")
    WebElement ks_balance;

    //Current Kiwisaver balance help icon
    @FindBy(how = How.XPATH, using="(//i[contains(@class,'icon')])[3]")
    WebElement ks_balance_h_icon;

    //Voluntary contribution value
    @FindBy(how = How.XPATH, using="(//input[contains(@type,'text')])[3]")
    WebElement ks_vol_contr_val;

    //Voluntary contribution frequency selection
    @FindBy(how = How.XPATH, using="//div[@class='well-value ng-binding'][contains(.,'Frequency')]")
    WebElement ks_vol_contr_freq;

    //Voluntary contribution help icon
    @FindBy(how = How.XPATH, using="(//i[contains(@class,'icon')])[4]")
    WebElement ks_vol_h_icon;

    //Voluntary Risk profile - select Growth
    @FindBy(how = How.XPATH, using="(//span[contains(.,'Growth')])[2]")
    WebElement ks_risk_p;

    //Voluntary Risk profile - help icon
    @FindBy(how = How.XPATH, using="(//i[contains(@class,'icon')])[5]")
    WebElement ks_risk_h_icon;

    //Savings goal at retirement
    @FindBy(how = How.XPATH, using="(//input[contains(@type,'text')])[4]")
    WebElement ks_sav_goal;

    //Savings goal at retirement help icon
    @FindBy(how = How.XPATH, using="(//i[contains(@class,'icon')])[6]")
    WebElement ks_sav_h_icon;

    //All help text Xpaths
    //_Current age help text
    @FindBy(how = How.XPATH, using="//p[contains(.,'age limit of 18 to 64 years old.')]")
    WebElement ks_cur_age_h_text;

    //Employee status help text
    @FindBy(how = How.XPATH, using="//p[contains(.,'If you are earning a salary or wage')]")
    WebElement ks_emp_stat_h_text;

    //Current kiwisaver balance help text
    @FindBy(how = How.XPATH, using="//p[contains(.,'If you do not have a KiwiSaver account')]")
    WebElement ks_bal_h_text;

    //Voluntary contribution help text
    @FindBy(how = How.XPATH, using="//p[contains(.,'you can make voluntary contributions')]")
    WebElement ks_vol_h_text;

    //Risk profile help text
    @FindBy(how = How.XPATH, using="//p[contains(.,'The risk profile affects your potential')]")
    WebElement ks_risk_h_text;

    //Savings goal help text
    @FindBy(how = How.XPATH, using="//p[contains(.,'Enter the amount you would like')]")
    WebElement ks_sav_h_text;

    //Calculate Projections
    @FindBy(how = How.XPATH, using="//span[@class='label'][contains(.,'View your KiwiSaver')]")
    WebElement projection_btn;

    //validate projections
    @FindBy(how = How.XPATH, using="//span[@class='result-title ng-binding'][contains(.,'At age 65')]")
    WebElement projection_validation;

    //Fortnighty selection
    @FindBy(how = How.XPATH, using="//span[contains(.,'Fortnightly')]")
    WebElement fort_selection;

    //Annual selection
    @FindBy(how = How.XPATH, using="//span[@class='ng-binding ng-scope'][contains(.,'Annually')]")
    WebElement an_selection;


    //methods on Kiwisaver retirement calculate page
    public void setCurrent_age_h_icon(){
        current_age_h_icon.click(); // click the current age help icon
    }

    public void setEmp_select_h_icon() {
        emp_select_h_icon.click(); // click on employee selection help icon
    }

    public void setKs_balance_h_icon(){
        ks_balance_h_icon.click(); // clicking KiwiSaver balance help icon
    }

    public void setKs_vol_h_icon() {
        ks_vol_h_icon.click(); // clicking voluntary contribution help icon
    }

    public void setKs_risk_h_icon(){
        ks_risk_h_icon.click(); // clicking risk help icon
    }

    public void setKs_sav_h_icon(){
        ks_sav_h_icon.click(); // clicking the savings goal help icon
    }

    //Help text methods to return help text

    public String setKs_cur_age_h_text() {
        return ks_cur_age_h_text.getText();
    }

    public String setKs_emp_stat_h_text(){
        return ks_emp_stat_h_text.getText();
    }

    public String setKs_bal_h_text(){
        return ks_bal_h_text.getText();
    }

    public String setKs_vol_h_text(){
        return ks_vol_h_text.getText();
    }

    public String setKs_risk_h_text() {
        return ks_risk_h_text.getText();
    }

    public String setKs_sav_h_text(){
        return ks_sav_h_text.getText();
    }

    //Acceptance criteria one
    public void CompareTheHelpTextOfCustomerAge() throws Exception {
        //1 check if the help icon present on current age
        String t1 = null;

        if (current_age_h_icon.isDisplayed()){

            current_age_h_icon.click(); // click the help button
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // Assertion to check the text displayed below the input box
            assertTrue(ks_cur_age_h_text.isDisplayed(), "Help text appears on current age");

            //Call screenshot method
            String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
            takeSnapShot(driver, "target\\screenshots\\helptextimage " + timestamp + ".png");

            // get help text and compare with the property file
            String t = ks_cur_age_h_text.getText();
            try {
                t1 = fetchMyProperties("help_text_current_age");
            } catch (Exception e) {
                e.printStackTrace();
            }

            Assert.assertEquals(t, t1); // compares the text is exact

        }else{
            assertTrue(false, "Current age help icon not displayed");
        }
    }

    //Check the help icons in a loop
    public void checkHelpIconsPresent() throws Exception{
        WebElement elementhelp;

        //select Employed status to open all help icons
        emp_select.click();
        jobtype.click(); // select employed status.

        //loop to run thru all the help texts
        for(int i=1;i<=8;i++){
            elementhelp =  driver.findElement(By.xpath("(//i[contains(@class,'icon')])["+i+"]"));

            //check if the help icon is displayed
            if (elementhelp.isDisplayed()){
                elementhelp.click(); //click the icon
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                assertTrue(true);

            }else{
                //Test fails
                assertTrue(false,
                        "Help icon not present");
            }

        }

    }

    //Userstory 2 scenario 1
    public void employedKiwiSaverProjections() throws Exception {
        //Input valid data
        //current age
        current_age_in_box.sendKeys(getCellData(1,0));
        //employment status
        emp_select.click();
        jobtype.click(); // select employed status.

        //salary or wages
        salary_in.sendKeys(getCellData(1,3));
        //contribution of 4%
        mem_cont.click();

        //chooses defensive
        //xpath changes with selection
        WebElement profile;
        profile = driver.findElement(By.xpath("//label[contains(.,'Defensive')]"));
        profile.click();

        //view projections
        projection_btn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Call screenshot method
        String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
        takeSnapShot(driver, "target\\screenshots\\employed " + timestamp + ".png");

        //Assertion
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement proj;
        proj = driver.findElement(By.xpath("//span[@class='result-value result-currency ng-binding']"));
        String val1 = proj.getText();
        System.out.println(val1);
        Assert.assertEquals("$\n" +
                "436,365", val1);

    }

    //user story 2 scenario 2 - self employed
    public void SelfemployedKiwiSaverProjections() throws Exception {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //Input valid data
        //current age
        current_age_in_box.clear();
        current_age_in_box.sendKeys(getCellData(2,0));


        //employment status -self employed
        WebElement el;
        el = driver.findElement(By.xpath("(//div[@class='well-value ng-binding'])[1]"));
        el.click(); // click the dropdown

        WebElement self_job;
        self_job = driver.findElement(By.xpath("//div[@class='label'][contains(.,'Self')]"));
        self_job.click();

        //current kiwisaver balance
        ks_balance.clear();
        ks_balance.sendKeys(getCellData(2,2));

        //voluntary contribution
         ks_vol_contr_val.sendKeys(getCellData(2,5));

        //Frequency
        ks_vol_contr_freq.click();
        fort_selection.click();

        //Risk profile
        WebElement profile;
        profile = driver.findElement(By.xpath("//label[contains(.,'Conservative')]"));
        profile.click();

        //saving goal
        ks_sav_goal.clear();
        ks_sav_goal.sendKeys(getCellData(2,8));

        //Call screenshot method
        String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
        takeSnapShot(driver, "target\\screenshots\\self-employed " + timestamp + ".png");

        //Assertion
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement proj;
        proj = driver.findElement(By.xpath("//span[@class='result-value result-currency ng-binding']"));
        String val1 = proj.getText();
        Assert.assertEquals("$\n" +
                "406,442", val1);
    }

    //user story 2 scenario 3 - Not Employed
    public void NotemployedKiwiSaverProjections() throws Exception {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //Input valid data
        //current age
        current_age_in_box.clear();
        current_age_in_box.sendKeys(getCellData(3,0));

        //employment status -self employed
        WebElement el;
        el = driver.findElement(By.xpath("(//div[@class='well-value ng-binding'])[1]"));
        el.click(); // click the dropdown

        WebElement self_job;
        self_job = driver.findElement(By.xpath("//div[@class='label'][contains(.,'Not')]"));
        self_job.click();

        //current kiwisaver balance
        ks_balance.clear();
        ks_balance.sendKeys(getCellData(3,2));

        //voluntary contribution
        ks_vol_contr_val.clear();
        ks_vol_contr_val.sendKeys(getCellData(3,5));

        //Frequency - annually
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement f;
        f = driver.findElement(By.xpath("(//span[contains(.,'Fortnightly')])[1]"));
        f.click();
        an_selection.click();

        //Risk profile
        WebElement profile;
        profile = driver.findElement(By.xpath("//label[contains(.,'Balanced')]"));
        profile.click();

        //saving goal
        ks_sav_goal.clear();
        ks_sav_goal.sendKeys(getCellData(3,8));

        //Call screenshot method
        String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
        takeSnapShot(driver, "target\\screenshots\\Notemployed " + timestamp + ".png");

        //Assertion
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement proj;
        proj = driver.findElement(By.xpath("//span[@class='result-value result-currency ng-binding']"));
        String val1 = proj.getText();
        System.out.println(val1);
        Assert.assertEquals("$\n" +
                "260,734", val1);

    }
}
