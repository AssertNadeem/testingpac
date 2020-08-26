package xeroTestCases;

import com.xero.pages.FreeTrialPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import xeroUtilities.browserSelectionUtility;

import java.util.concurrent.TimeUnit;

public class verifyXeroFreeRegistrationTests {
    WebDriver driver;
    FreeTrialPage ftPageobj;

    @BeforeTest
    public void prepareSetupForTesting(){
        //Start the browser
        driver = browserSelectionUtility.StartBrowser("Chrome", "https://www.xero.com/nz/");
        //Initialize login page using page Factory
        ftPageobj  = PageFactory.initElements(driver, FreeTrialPage.class);
    }
    @Test
    public void VerifyXeroFreeRegistration(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ftPageobj.setFirst_name("Abdul Nadeem");
        ftPageobj.setLast_name("Mohammad");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ftPageobj.setEmail_id("nadeem.shine@gmail.com");
        ftPageobj.setPhone_number("0222222222");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //ftPageobj.setSelect_country("NZ");
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Disabled recaptcha as it need google keys or we need to disable for our automation
        //ftPageobj.setRecaptcha_checkbox();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ftPageobj.setTconditions();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //ftPageobj.setRegisterbtn();
    }

    @AfterTest
    public void TearDown(){
        //Quit driver
        driver.quit();
    }
}
