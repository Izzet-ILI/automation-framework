@login @regression

Feature: Webdriver University - Login Page

  Background:
    Given I access the webdiver university login portal page

  Scenario:Login with valid data
    When I enter a username webdriver
    And I enter a password webdriver123
    And I click on the login button
    Then I should be presented with the successful login message

  Scenario: Login with invalid data
    When I enter a username webdriver
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
      | webdriver | webdriver123 | validation succeeded   |
      | webdriver | webdriver1   | validation failed      |
      | joe_blogs | password1    | validation failed      |

