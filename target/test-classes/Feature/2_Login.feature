@LoginTest
Feature: This feature will be used to test the login feature in the Flyaway website.

  Scenario: Login on Flyaway website
    Given I have launched the Flyaway application
    When I click on Login on the Home page
    And I enter email as "john2@doe.com" on the Login page
    And I enter password as "aaaaaa" on the Login page
    And I click on Login button on the Login page
    Then I should be able to login successfully