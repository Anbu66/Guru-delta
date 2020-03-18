#Author: greens
@US0004 @Regression @Sprint1 @Smoke @bookaflight
Feature: Book A flight oneway

  #AC1
  Scenario: Booking flight in OneWay trip
      Given The User is in Delta homepage
    When The user enters source and destination
      | ATL | MSP |
    And The user select oneway trip
    And The user select date from Web calendar "02/23/2020"
    And The user clicks submit button
    Then The user should be in search results page
