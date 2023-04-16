@js_executor
Feature: js executor
  Scenario: TC01 js executor
    Given  I navigate to "https://www.amazon.com"
    And I wait for 5 seconds
    And I scroll down to footer section
    And I wait for 3 seconds
    And I capture the screenshot of the page
    And I wait for 5 seconds
    And I click on "Amazon Subscription Boxes" by js on amazon table
    And I wait for 5 seconds
    And I capture the screenshot of the page

