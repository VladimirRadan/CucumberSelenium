Feature: Login into account

  Background:
    Given I'm on login page of herokuapp website

  Scenario: Login into account with valid credentials
    #Given I'm on login page of herokuapp website
    And I entered valid username "tomsmith" and password "SuperSecretPassword!"
    When I click teh login button
    Then I should be taken to the login welcome page

  Scenario Outline: Login into account with invalid credentials
    #Given I'm on login page of herokuapp website
    And I entered invalid username "<username>" and password "<password>"
    When I click teh login button
    Then I should see error message
    Examples:
      | username  | password  |
      | ''        | ''        |
      | username1 | password1 |
      | username2 | password2 |


  Scenario: Login with valid credentials
    #iven I'm on login page of herokuapp website
    When I try to login with the following credentials:
      | username | password             |
      | tomsmith | SuperSecretPassword! |
    Then I should be taken to the login welcome page
