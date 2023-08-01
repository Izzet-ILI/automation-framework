package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Base_PO {
    public Base_PO() {  // constructor
        PageFactory.initElements(getDriver(),this);
    }

    public WebDriver getDriver()
    {
        return DriverFactory.getDriver();
    }

    // url navigation method
    public void navigateTo_URL(String url)
    {
        getDriver().get(url);
    }

    // generate random number method
    public String generateRandomNumber(int length)
    {
        return RandomStringUtils.randomNumeric(length);
    }
    public String generateRandomString(int length)
    {
        return RandomStringUtils.randomAlphabetic(length);
    }

    // wait & sendKeys
    public void sendKeys(By by, String testToType)
    {
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(testToType);
    }

    public void sendKeys(WebElement element, String testToType)
    {
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(testToType);
    }
    // wait & visible
    public void waitFor(By by)
    {
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void waitFor(WebElement element)
    {
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // wait & click
    public void waitForWebElementAndClick(By by)
    {
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }
    public void waitForWebElementAndClick(WebElement element)
    {
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForAlert_And_ValidateText(String text)
    {
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));// wait logic
        wait.until(ExpectedConditions.alertIsPresent());//wait alert present
        String alert_Message_Text=getDriver().switchTo().alert().getText();//
        Assert.assertEquals(alert_Message_Text,text);
    }



}
