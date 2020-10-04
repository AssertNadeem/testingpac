package westpacTestCases;

import com.westpac.pages.KiwiSaverRetirementCalculatorPage;
import com.westpac.pages.WestpacHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import westpacUtilities.browserSelectionUtility;

import java.util.concurrent.TimeUnit;

import static westpacUtilities.westpacUtilities.fetchMyProperties;

public class westpacUserStoryTwoTests {

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
    public void VerifyUserStoryTwoAcceptCriteriaOne() throws Exception {
        //Navigate to kiwisaver calculate
        homePageobj.setCalculateKiwiSaverPage();
        homePageobj.setGetStarted_ks_btn();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //As the elements are present in an iframe, we have to switch to the frame
        driver.switchTo().frame(driver.findElement(By.cssSelector("#calculator-embed > iframe")));

        KiwiSaverPageobj.employedKiwiSaverProjections();
    }
    @Test
    public void VerifyUserStoryTwoAcceptCriteriaTwo() throws Exception {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        KiwiSaverPageobj.SelfemployedKiwiSaverProjections();
    }

    @Test
    public void VerifyUserStoryTwoAcceptCriteriaThree() throws Exception {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        KiwiSaverPageobj.NotemployedKiwiSaverProjections();
    }

    @AfterTest
    public void TearDown(){
        //Quit driver if not null
        if (driver != null) {
            driver.quit();
        }
    }

}
