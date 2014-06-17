package org.cookbookgeeks.webkochbuch;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RateRecipeStepDefinitions {

	
	
	@Given("^I am logged in$")
	public void I_am_logged_in() throws Throwable {
		BrowserDriver.loadPage("http://localhost:8080/list");
		BrowserDriver.clickLink("Testrezept");
	}

	@When("^I choose my rating by clicking on the amount of stars I want to give$")
	public void I_choose_my_rating_by_clicking_on_the_amount_of_stars_I_want_to_give() throws Throwable {
	    BrowserDriver.clickFourStars();
	}

	@Then("^the website should say \"([^\"]*)\"$")
	public void the_website_should_say(String arg1) throws Throwable {

	}
}
