package westpacUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class browserSelectionUtility {

    static WebDriver driver;

    //method to start browser based on selection

    public static WebDriver StartBrowser(String browser_name, String url){

        if(browser_name.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup(); //Driver setup
            //WebDriverManager.chromedriver().version(85.0.4183.83); // If we need specific version of driver
            driver = new ChromeDriver();

        }else if(browser_name.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup(); //firefox driver setup
            driver = new FirefoxDriver();

        }

        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
        try {
            driver.manage().window().maximize();
            driver.get(url);

        } catch (TimeoutException e) {
            System.out.println("Page: " + url + " did not load within 35 seconds!");
        }

    return driver;

    }
}
