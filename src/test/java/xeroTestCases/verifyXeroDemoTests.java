package xeroTestCases;

import com.xero.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import xeroUtilities.browserSelectionUtility;

import java.util.concurrent.TimeUnit;

public class verifyXeroDemoTests {

    WebDriver driver;

    XeroLoginPage loginPageobj;
    XeroHomePage homePageobj;
    CompanyDetailsPage compDetailsobj;
    AccountingPage accPageObj;

    @BeforeSuite
    public void prepareSetupForTesting(){
        //Start the browser
        driver = browserSelectionUtility.StartBrowser("chrome", "https://www.xero.com/nz/");
        //Initialize page objects using page Factory
        loginPageobj = PageFactory.initElements(driver, XeroLoginPage.class);
        homePageobj = PageFactory.initElements(driver, XeroHomePage.class);
        compDetailsobj = PageFactory.initElements(driver, CompanyDetailsPage.class);
        accPageObj = PageFactory.initElements(driver, AccountingPage.class);
    }

    @Test
    //Test to check the user lands on the homepage
    public void checkUserlandsOnHomePage(){
        //Get the title of the home page
        String tTitle = driver.getTitle();
        String curTitle = "Accounting Software – Do Beautiful Business | Xero NZ";
        Assert.assertEquals(tTitle,curTitle);
    }

    @Test
    //Test to login to Xero
    public void CheckLoginButtonOnHomePage(){
        //Login button click
        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
        homePageobj.setLogin_btn();

        //Asserting the title of the displayed page
        String cTitle = "Login | Xero Accounting Software";
        String hpTitle = driver.getTitle();
        Assert.assertEquals(hpTitle,cTitle);
    }

    @Test
    //Test with parameters passed from testng.xml as username and password
    @Parameters({"email","pwd"})
    public void VerifyValidLoginToXero(String usermail, String passwd){
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Input email id as user name
        loginPageobj.setLogin_email(usermail);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Input email id as password
        loginPageobj.getLogin_pwd(passwd);

        String pbanner = loginPageobj.setWin_banner();
        Assert.assertEquals(pbanner, "Welcome to Xero");

        //Click login button
        loginPageobj.setLogin_btn_hp();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    //Registration test is disabled
    @Test(enabled=false)
    public void VerifyCompanyRegistration(){
        compDetailsobj.setOrg_name("ABCXYZ Company");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        compDetailsobj.setPay_tax();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        compDetailsobj.setTime_zone();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        compDetailsobj.setOrg_work();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        compDetailsobj.setGst_yes_no();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        compDetailsobj.setPrevious_sw();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        compDetailsobj.setStart_trial_button();
    }

    //Tests the account setup
    @Test
    public void VerifyAccountSetup(){
        //Clicks the main accounts button
        accPageObj.setAcc_button();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //clicks the menu item
        accPageObj.setBank_acc_button();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //clicks add account button
        accPageObj.setAdd_bank_btn();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        accPageObj.setSearch_bar("ANZ");
        //method to input all accounts details
        accPageObj.setAcc_details();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String fTitle = accPageObj.setConnect_title();

        //Application lands on Connect with bank page
        Assert.assertEquals(fTitle, "Connect with bank");
    }

    @AfterSuite
    public void TearDown(){
        //Quit driver if not null
        if (driver != null) {
            driver.quit();
        }
    }
}
