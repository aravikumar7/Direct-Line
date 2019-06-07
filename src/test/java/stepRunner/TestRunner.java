package stepRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.openqa.selenium.WebDriver;
import DirectLine_Pages.BrowserFactory;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/"
        ,glue={"DirectLine_StepDef"},
        tags={"@Functional"},
        plugin = {"pretty", "html:target/cucumber-htmlreport","json:target/cucumber-report.json"}
        )
public class TestRunner {
    static WebDriver driver;
    @BeforeClass
    public static void beforeClassMethod(){
        driver = BrowserFactory.getBrowser();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void closeTheBrowser() {
        driver.quit();
    }
    }
