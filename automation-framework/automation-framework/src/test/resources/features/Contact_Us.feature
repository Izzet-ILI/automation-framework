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
    And I enter a specific email address uyghur_gul@gmail.com
    And I enter a specific comment "I am cool!"
    And I click on the submit button
    Then I should presented with a successful contact us submission message


