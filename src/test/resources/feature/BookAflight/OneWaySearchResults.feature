#Author: your.email@your.domain.com
@tag
Feature: To verify flight details in search results

  @tag1
  Scenario: To verify flight details in one way search results
    Given The User is in Delta homepage
    And The user selects book menu option
    When The user fill in the details
      | ATL | MSP | One Way | 02/23/2020 | 1 Passenger|
    And The user clicks the submit button
    Then The user verifies the search results details
      
