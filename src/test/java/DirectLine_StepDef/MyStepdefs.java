package DirectLine_StepDef;

import DirectLine_Pages.BrowserFactory;
import DirectLine_Pages.DealerPortal;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    WebDriver driver;
    DealerPortal dealerportal;

    @Before
    public void beforeTest() {
        driver = BrowserFactory.getBrowser();
        driver.get("https://covercheck.vwfsinsuranceportal.co.uk/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void afterTest(Scenario scenario){
        if(scenario.isFailed()) {
            scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
        }
    }
    @Given("User is in Insurance Portal")
    public void userIsIn() {
        dealerportal=new DealerPortal(driver);
        Assert.assertTrue(dealerportal.checkURL());
    }

    @When("the user enters {string} and tries to Find vehicle")
    public void theUserEntersAndTriesToFindVehicle(String arg0) {
        dealerportal.vehicleSearch(arg0);
    }

    @Then("Results show the result for {string}")
    public void resultsShowTheResultFor(String arg0) {
        Assert.assertTrue(dealerportal.result(arg0));
    }

    @And("Cover end is greater than current date and time")
    public void coverEndIsGreaterThanCurrentDateAndTime() {
    Assert.assertTrue(dealerportal.endDateValidation());
    }

    @And("end date is greater than the start date")
    public void endDateIsGreaterThanTheStartDate() {
        Assert.assertTrue(dealerportal.startEndDateValidation());
    }

    @Then("Results show no coverage")
    public void resultsShowNoCoverage() {
        Assert.assertTrue(dealerportal.noCoverage());
    }


    @When("the user tries to Find vehicle without entering registration number")
    public void theUserTriesToFindVehicleWithoutEnteringRegistrationNumber() {
        dealerportal.checkRegistrationNumber();
    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String arg0) {
    Assert.assertTrue(dealerportal.validateRegNumber(arg0));
    }
}
