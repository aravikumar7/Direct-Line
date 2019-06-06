package DirectLine_Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class DealerPortal extends BasePage{
     public DealerPortal(WebDriver driver)
     {
        super(driver);
    }
    String dateCompare;
    LocalDateTime formattedEndDate,formattedStartDate;

    @FindBy(how = How.ID,using = "vehicleReg" )
    public WebElement reg;

    @FindBy(how = How.XPATH,using = "//*[@id='page-container']/div[3]/form/button/span")
    public WebElement findVehicle;

    @FindBy(how=How.XPATH,using="//*[@id='page-container']/div[4]/div[1]")
    public WebElement result;

    @FindBy(how=How.XPATH,using="//*[@id='page-container']/div[4]/div[2]/span")
    public WebElement starttDate;

    @FindBy(how=How.XPATH,using="//*[@id='page-container']/div[4]/div[3]/span")
    public WebElement endDate;

    @FindBy(how=How.XPATH,using="//*[@id='page-container']/div[4]")
    public WebElement errorMessage;

    @FindBy(how=How.XPATH,using="//*[@id='page-container']/div[3]/form/div")
    public WebElement errorEmptyRegNumber;

    public Boolean checkURL(){
        return driver.getCurrentUrl().equalsIgnoreCase("https://covercheck.vwfsinsuranceportal.co.uk/");
    }
    public void checkRegistrationNumber(){
        findVehicle.click();
    }

    public Boolean validateRegNumber(String arg0){
    return errorEmptyRegNumber.getAttribute("innerText").contains(arg0);
    }

    public void vehicleSearch(String arg0){
      reg.sendKeys(arg0);
      findVehicle.click();
    }

    public Boolean result(String arg0){
        return result.getAttribute("innerText").contains(arg0);
    }

    public Boolean endDateValidation() {
        String enddate=endDate.getAttribute("innerText");
        LocalDateTime now = LocalDateTime.now();
        //DateTimeFormatter f = DateTimeFormatter.ofPattern( "dd MMM yyHH : mm : ss" ) ;
        DateTimeFormatter formatter= new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd MMM yyHH : mm : ss").toFormatter();
        formattedEndDate = LocalDateTime.parse(enddate.trim(), formatter);

        if (formattedEndDate.isAfter(now)) {
            dateCompare="End date is after today";
        }
        if (formattedEndDate.isBefore(now)) {
            dateCompare="End date is before today";
        }
        if (formattedEndDate.isEqual(now)) {
            dateCompare="End date is equal to today";
        }
        return dateCompare.equalsIgnoreCase("End date is after today");
    }

    public Boolean startEndDateValidation() {
        String stDate=starttDate.getAttribute("innerText");
       // DateTimeFormatter f = DateTimeFormatter.ofPattern( "dd MMM yyHH : mm : ss" ) ;
        DateTimeFormatter formatter= new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd MMM yyHH : mm : ss").toFormatter();
        formattedStartDate = LocalDateTime.parse(stDate.trim(), formatter);

        if (formattedEndDate.isAfter(formattedStartDate)) {
            dateCompare="End date is after Start Date";
        }
        if (formattedEndDate.isBefore(formattedStartDate)) {
            dateCompare="End date is before Start Date";
        }
        if (formattedEndDate.isEqual(formattedStartDate)) {
            dateCompare="End date is equal to Start Date";
        }
        return dateCompare.equalsIgnoreCase("End date is after Start Date");
    }
public Boolean noCoverage(){
        return errorMessage.getAttribute("innerText").contains("Sorry record not found");
}
}
