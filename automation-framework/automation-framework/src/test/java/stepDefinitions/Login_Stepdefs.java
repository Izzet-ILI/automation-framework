package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Base_PO;
import pageObjects.Login_PO;

public class Login_Stepdefs extends Base_PO {
    private Login_PO login_po;

    public Login_Stepdefs(Login_PO login_po) {
        this.login_po = login_po;
    }

    @Given("I access the webdiver university login portal page")
    public void iAccessTheWebdiverUniversityLoginPortalPage() {
        login_po.navigateTo_WebDriverUniversity_Login_Page();
    }
    @When("I enter a username {}")
    public void i_enter_a_username(String username) {
        login_po.setUsername(username);
    }
    @And("I enter a password {}")
    public void i_enter_a_password(String password) {
        login_po.setPassword(password);
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        login_po.clickOn_Login_button();
    }

    @Then("I should be presented with the successful login message")
    public void i_should_be_presented_with_the_successful_login_message() {
        login_po.validate_SuccessfulLogin_Message();
    }

    @Then("I should be presented with the unsuccessful login message")
    public void i_should_be_presented_with_the_unsuccessful_login_message() {
        login_po.validate_UnsuccessfulLogin_Message();
    }

    @Then("I should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message(String expectedMessage) {
        waitForAlert_And_ValidateText(expectedMessage);
    }


}
