package org.cookbookgeeks.webkochbuch;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchRecipeStepDefinitions {

	public String sw;
	
	@Given("^I have a search word$")
	public void I_have_a_search_word() throws Throwable {
	    sw = "Testrezept";
	}

	@When("^I type in a search word into the search panel and press ENTER$")
	public void I_type_in_a_search_word_into_the_search_panel_and_press_ENTER() throws Throwable {
		String startpage = "http://localhost:8080/";
		BrowserDriver.loadPage(startpage);
		
		BrowserDriver.searchfor(sw);
	}

	@Then("^a list with all corresponding recipes should appear$")
	public void a_list_with_all_corresponding_recipes_should_appear() throws Throwable {
		String page = BrowserDriver.getPageLoaded();
		if(!page.startsWith("http://localhost:8080/search?s="))
			throw new Exception("Recipe Search Error!");
	}
}
