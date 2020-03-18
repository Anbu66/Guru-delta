package com.stepdefinition;

import com.resources.FunctionalLibrary;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseClass {

	@Before
	public static void beforeScenario() {

		FunctionalLibrary.driverInit("chrome");
	}

	@After
	public static void afterScenario() {
		FunctionalLibrary.closeBrowser();
	}

}
