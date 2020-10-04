package westpacTestCases;

import com.westpac.pages.WestpacHomePage;
import com.westpac.pages.KiwiSaverRetirementCalculatorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import westpacUtilities.browserSelectionUtility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static westpacUtilities.westpacUtilities.*;

//Tests all the scenarios of user story one
public class westpacUserStoryOneTests {

    WebDriver driver;

    KiwiSaverRetirementCalculatorPage KiwiSaverPageobj;
    WestpacHomePage homePageobj;


    @BeforeTest
    @Parameters("browser")
    public void prepareSetupForTesting(String browser) throws Exception {
        String url = fetchMyProperties("BaseUrl"); // fetching url from properties file.
        //Start the browser
        driver = browserSelectionUtility.StartBrowser(browser, url);
        //Initialize page objects using page Factory
        KiwiSaverPageobj = PageFactory.initElements(driver, KiwiSaverRetirementCalculatorPage.class);
        homePageobj = PageFactory.initElements(driver, WestpacHomePage.class);

    }

    @Test
    //Test to check the user lands on the westpac homepage
    public void checkUserlandsOnHomePage(){
        //Get the title of the home page
        String tTitle = driver.getTitle();
        String curTitle = "Bank | Westpac New Zealand - Helping Kiwis with their personal banking";
        Assert.assertEquals(tTitle,curTitle); // check the titles match
    }

    @Test
    //Test to check the user reaches and lands on KiwiSaver calculator page
    public void checkUserNavigationToKiwiSaverCalculator(){
       //Navigate to KiwiSaver Calculator
        homePageobj.setCalculateKiwiSaverPage();

        //Optional code to hover over kiwisaver link and navigate
        /*homePageobj.setKiwisaver_main_link();
        homePageobj.setCalc_ks_btn();*/
        homePageobj.setGetStarted_ks_btn();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Asserting the title of the displayed page
        String cTitle = "KiwiSaver Retirement Calculator - Westpac NZ";
        String hpTitle = driver.getTitle();
        Assert.assertEquals(hpTitle,cTitle);
    }

        @Test
        //Check all help icons present
        public void VerifyAllHelpIconsPresent() throws Exception {
            //As the elements are present in an iframe, we have to switch to the frame
            driver.switchTo().frame(driver.findElement(By.cssSelector("#calculator-embed > iframe")));

            //method to check the icons present.
            KiwiSaverPageobj.checkHelpIconsPresent();

            //switch back to default
            //driver.switchTo().defaultContent();
        }

        //Test can be enabled and disabled
        @Test(enabled=true)
        public void CheckAcceptanceCriteriaUserStory1() throws Exception {
        //check the help text is as expected.
            KiwiSaverPageobj.CompareTheHelpTextOfCustomerAge();
        }

    @AfterTest
    public void TearDown() throws IOException {

        //Quit driver if not null
        if (driver != null) {
            driver.quit();
        }
    }
}
