package org.cookbookgeeks.webkochbuch;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ReadRecipeStepDefinition {
	private String link;
	
	  
	@Given("^I have a hyperlink to an existing recipe$")
	public void I_have_a_hyperlink_to_an_existing_recipe() throws Throwable {
	   link = "http://localhost:8080/webkochbuch/recipe/0";
	}

	@When("^I open a hyperlink to a recipe$")
	public void I_open_a_hyperlink_to_a_recipe() throws Throwable {
		BrowserDriver.loadPage(link);
	}

	@Then("^the Website with the requested recipe appears$")
	public void the_Website_with_the_requested_recipe_appears() throws Throwable {
//		BrowserDriver.clickPage("Auflauf");
	}


}
