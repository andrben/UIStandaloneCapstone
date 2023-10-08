@FlightSearchTest
Feature: This feature will be used to test the flight search feature in the Flyaway website.

  Scenario: Flight search on Flyaway website
    Given I have launched the Flyaway application
    When I click on Login on the Home page
    And I enter email as "john2@doe.com" on the Login page
    And I enter password as "aaaaaa" on the Login page
    And I click on Login button on the Login page
    And I click on Home page link
    And I select "Bangalore" to "Hyderabad" as the source & desitnation
    And I click on Submit
    And I confirm that the flight exists for booking
    And I click on the Book Flight button
    Then I confirm whether the flight ID is the same in the Book Flight link and the database