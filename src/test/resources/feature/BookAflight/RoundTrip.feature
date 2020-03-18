#Author: Greens tech
@tag
Feature: Verify round trip functionality

  Scenario: 
    Given The User is in Delta homepage
    When The user selects source and destination
      | ATL | MSP |
    And The user selects trip type, dates and number of passengers
      | Round Trip | 02/23/2020 | 02/25/2020 | 2 Passengers |
    Then The user should see the list of flights
    			|Sun, Feb 23, 2020 |