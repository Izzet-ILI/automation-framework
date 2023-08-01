package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.Global_Vars;

public class Contact_Us_PO extends Base_PO {

    private @FindBy(how = How.XPATH, using = "//input[@name='first_name']")
    WebElement firstName_TextField;
    private @FindBy(xpath="//input[@name='last_name']")
    WebElement lastName_TextField;
    private @FindBy(xpath="//input[@name='email']")
    WebElement emailAddress_TextField;
    private @FindBy(xpath="//textarea[@name='message']")
    WebElement comment_TextField;
    private @FindBy(xpath="//input[@value='SUBMIT']")
    WebElement submit_Button;
    private @FindBy(xpath="//div[@id='contact_reply']/h1")
    WebElement successfulSubmission_Message_Text;


    public Contact_Us_PO() {
        super();
    }

    public void navigateTo_WebDriverUniversity_Contact_Us_Page()
    {
        navigateTo_URL(Global_Vars.WEBDRIVER_UNIVERSITY_HOMEPAGE_URL+"/Contact-Us/contactus.html");
    }

    public void setUnique_FirstName()
    {
        sendKeys(firstName_TextField,"AutoFN"+generateRandomNumber(6));
    }
    public void setUnique_LastName()
    {
        sendKeys(lastName_TextField,"AutoLN"+generateRandomNumber(6));
    }
    public void setUnique_EmailAddress()
    {
        sendKeys(emailAddress_TextField,"AutoEmail"+generateRandomNumber(10)+"@gmail.com");
    }
    public void setUnique_Comment()
    {
        sendKeys(comment_TextField,"Automation is fun."+generateRandomString(20));
    }

    // specific data
    public void setSpecific_FirstName(String firstName)
    {
        sendKeys(firstName_TextField,firstName);
    }

    public void setSpecific_LastName(String password)
    {
        sendKeys(lastName_TextField,password);
    }

    public void setSpecific_EmailAddress(String emailAddress)
    {
        sendKeys(emailAddress_TextField,emailAddress);
    }

    public void setSpecific_Comment(String comment)
    {
        sendKeys(comment_TextField,comment);
    }

    // submission
    public void clickOn_Submit_Button()
    {
        waitForWebElementAndClick(submit_Button);
    }

    public void validate_Successful_SubmissionMessage_Text()
    {
        waitFor(successfulSubmission_Message_Text);
        Assert.assertEquals(successfulSubmission_Message_Text.getText(),"Thank You for your Message!");
    }

}
