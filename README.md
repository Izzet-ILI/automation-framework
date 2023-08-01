# automation-framework

# Overview 
This automation testing uses Selenium Webdriver 4, Java, Cucumber BDD, TestNG, and POM. Incorporate best practices when developing Cucumber Frameworks.

# Test Strategy 
* Page Object Model/Pattern for any UI Verification
* Combination of TestNG and the Cucumber framework
* TestNG framework for Integration Tests
* Cucumber Framework for the regression and smoke test

## Testing and other tools during the project:

* [Jira](https://www.atlassian.com/software/jira) - use it to create an epic task, feature and bug tickets
* [Confluence](https://www.atlassian.com/software/confluence) - for documentation, to create test plan and test cases.
* [Intellij](https://www.jetbrains.com/idea/) IDE - to create a test automation framework and execute our codes and tests.
* [Github](https://github.com/) - for managing code in git versions and code repository system.
* [Jenkins](https://www.jenkins.io/) - use it for CI/CD purpose.

# Manual test 

* For manual test I created a Test plan and Test cases using Confluence.
  
* when all the manual test passed, then I started for automation test.

# Developed automation test scripts using Selenium WebDriver with Java in Intellij IDE.
## Automation tests 
* ## **Front-End**  
1. A valid user should be able to login with valid data
2. A valid user should be able to login with invalid data
3. Validate Successful Submission - Unique Data
4. Validate Successful Submission - Specific Data

# POM.xml file.
* After I created the project, I manage all my dependencies in POM.xml file.
* I also used POM structure in order to keep my code organize and clean, So I basically created a separate Java Class for each page of my application where I store all elements of that page as well as related methods.

# main/java
* driver
* page objects
* properties
* utils

# Cucumber Feature Files
### I created Cucumber Feature Files where I used Gherkin language in order to describe my test scenario, by doing that my test cases are understandable  for each member of my team. 
# Login Feature File
``` Gherkin
@login @regression

Feature: Webdriver University - Login Page

  Background:
    Given I access the webdiver university login portal page

  Scenario:Login with valid data
    When I enter a username ********
    And I enter a password webdriver***
    And I click on the login button
    Then I should be presented with the successful login message

  Scenario: Login with invalid data
    When I enter a username *********
    And I enter a password password123
    And I click on the login button
    Then I should be presented with the unsuccessful login message

    @smoke @ignore
  Scenario Outline: Validate - Successful & Unsuccessful Login
    When I enter a username <username>
    And I enter a password <password>
    And I click on the login button
    Then I should be presented with the following login validation message <loginValidationMessage>

    Examples:
      | username  | password     | loginValidationMessage |
      | ********* | *********    | validation succeeded   |
      | webdriver | webdriver1   | validation failed      |
      | joe_blogs | password1    | validation failed      |
```
# Contact-Us Feature File
  ```
  @contact-us @regression

Feature: Webdriver University - Contact Us Page

  Background:
    Given I access the webdiver university contact us page

  Scenario: Validate Successful Submission - Unique Data
    When I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click on the submit button
    Then I should presented with a successful contact us submission message

  Scenario: Validate Successful Submission - Specific Data
    When I enter a specific first name uyghur
    And I enter a specific last name gul
    And I enter a specific email address ***********@gmail.com
    And I enter a specific comment "I am cool!"
    And I click on the submit button
    Then I should presented with a successful contact us submission message
  ```

# main/test
* Cucumber options, testng.xml file
* I created step definitions package. It contains seperate step definition class of each feature files. 
* Runner package for execute the test cases:
```
package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"classpath:features"},
                  glue = {"stepDefinitions"},
                  tags = "",
                  monochrome =true,
                  dryRun =false,
                  plugin={"pretty","html:target/cucumber","json:target/cucumber.json"})
public class MainRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }
}
```

