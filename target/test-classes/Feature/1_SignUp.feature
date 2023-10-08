@SignUpTest
Feature: This feature will be used to test the Flyaway website for sign up funcationality.

  Scenario: SignUp on Flyaway website
    Given I have launched the Flyaway application
    When I click on Login
    And I click on Signup
    And I enter email as "john2@doe.com"
    And I enter password and confirm password as "aaaaaa"
    And I enter name as "name"
    And I enter address as "address"
    And I enter city as "city"
    And I click on Signup button
    Then I should get the user successfully registered