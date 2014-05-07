package org.cookbookgeeks.webkochbuch;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateRecipeStepDefinitions {

	private String startpage;
	private String createpage;
	
	@When("^I click \"([^\"]*)\" in the menu bar.$")
	public void I_click_in_the_menu_bar(String arg1) throws Throwable {
		startpage = "http://localhost:8080/";
		BrowserDriver.loadPage(startpage);
		if(startpage.equals(BrowserDriver.getPageLoaded())==false){
			throw new Exception("Seite nicht verfügbar!");
		}
		BrowserDriver.clickLink("Rezept erstellen");
	}

	@Then("^the application should show an input formular.$")
	public void the_application_should_show_an_input_formular() throws Throwable {
		createpage = "http://localhost:8080/recipe/add";
		if(createpage.equals(BrowserDriver.getPageLoaded())==false){
			throw new Exception("Seite nicht verfügbar!");
		}
	}

	@Then("^save the recipe after the formular is filled in.$")
	public void save_the_recipe_after_the_formular_is_filled_in() throws Throwable {
	    
		//fill in formular
		BrowserDriver.fillTextfield("title", "Testrezept");
		BrowserDriver.fillTextfield("description", "Beschreibung blah fasel");
		BrowserDriver.fillTextfield("preparationEndurance", "20");
		BrowserDriver.fillTextfield("totalEndurance", "30");
		BrowserDriver.fillTextfield("content_ifr", "Blah falsel Zutaten usw");
		
		//Submit
		BrowserDriver.submitFormular();
		
		//check if the site of the recipe is shown
		String page = BrowserDriver.getPageLoaded();
		if(!page.startsWith("http://localhost:8080/recipe/"))
			throw new Exception("Recipe Creation Error!");
	}
	
	
}
