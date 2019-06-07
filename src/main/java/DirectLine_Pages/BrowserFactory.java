package DirectLine_Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {

    static final String USERNAME = "lakshmi.jeevi";
    static final String ACCESS_KEY = "1d4ba44b-6087-4d74-adb9-92607120875e";
    static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com/wd/hub";

    static WebDriver driver = null;

    public static WebDriver getBrowser() {
        if (driver != null) {
            return driver;
        }
        else
        {
            //String browserName = System.getProperty("BROWSER");
            String browserName = "firefox";
            DesiredCapabilities capabilities;

            /*if (browserName.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-features=VizDisplayCompositor");
                capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability(ChromeOptions.CAPABILITY,options);
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                capabilities = DesiredCapabilities.firefox();
            } else if (browserName.equalsIgnoreCase("edge")) {
                capabilities = DesiredCapabilities.edge();
            } else {
                capabilities = DesiredCapabilities.chrome();
            }*/
            /*try {
                capabilities.setCapability("InPrivate", "true");
               capabilities.setCapability("platform", "Windows 10");
                capabilities.setCapability("version","latest");
                capabilities.setCapability("name", "Add to Basket Feature");
            //   driver = new RemoteWebDriver(new URL(URL), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                System.out.println("Cause is : "+e.getCause());
                System.out.println("Message is :"+e.getMessage());
            }*/
     //   System.setProperty("webdriver.chrome.driver", "G:/driver/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
        }
    }
}
