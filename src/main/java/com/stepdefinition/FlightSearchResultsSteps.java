package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.ObjectRepository.FlightSearchResultsPage;
import com.resources.FunctionalLibrary;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

public class FlightSearchResultsSteps extends FunctionalLibrary {

	 @Then("^The user should be in search results page$")
	 public void the_user_should_be_in_search_results_page() throws Throwable
	 {
		
	 Assert.assertEquals("Airline Tickets & Flights: Book Direct with Delta Air Lines - Official Site", driver.getTitle());
	 }

	@Then("^The user should see the list of flights$")
	public void the_user_should_see_the_list_of_flights(DataTable flightList) throws Throwable {

		List<String> flightLists = flightList.asList(String.class);
		FlightSearchResultsPage searchRs = new FlightSearchResultsPage();
		waitForElementClickable(searchRs.getLnk_FlightNum().get(0));
		List<WebElement> actualFlightListElements = searchRs.getLnk_FlightNum();
		List<String> actualFlightLists = new ArrayList<>();
		for (int i = 0; i < actualFlightListElements.size(); i++) {
			actualFlightLists.add(actualFlightListElements.get(i).getText());
		}System.out.println(actualFlightLists);

		Assert.assertEquals(flightLists, actualFlightLists);
	}
	@Then("^The user verifies the search results details$")
	public void the_user_verifies_the_search_results_details() {
		FlightSearchResultsPage flightse = new FlightSearchResultsPage();
		
		 Assert.assertEquals("ATL - MSP",flightse.getFlightsearchresult().getText());
		 
			

		
	}
	
}
