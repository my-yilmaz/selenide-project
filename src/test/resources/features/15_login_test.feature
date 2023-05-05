Feature: login test

  @positive_login_test
  Scenario: TC01 positive login test
    Given I navigate to "https://www.saucedemo.com/"
    Then Verify login_logo
    Then Verify the username box are enabled
    Then Verify the password box are enabled
    Then I enter username "standard_user"
    Then I enter password "secret_sauce"
    Then I click on login button
    Then Verify app_logo