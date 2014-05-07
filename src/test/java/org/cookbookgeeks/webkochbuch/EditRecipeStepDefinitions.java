package org.cookbookgeeks.webkochbuch;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditRecipeStepDefinitions {

	private String testrecipe = "Testrezept";
	private String changes = "Ergänzungen blah fasel";
	
	@Given("^I am on the Page of a recipe$")
	public void I_am_on_the_Page_of_a_recipe() throws Throwable {
	    //look for the test recipe
		BrowserDriver.loadPage("http://localhost:8080/list");
		BrowserDriver.clickLink(testrecipe);
	}

	@When("^I press the edit-recipe-button$")
	public void I_press_the_edit_recipe_button() throws Throwable {
		BrowserDriver.clickLinkByID("editdelete");
	}

	@Then("^I should be forwarded to a formular site in which I can edit my recipe$")
	public void I_should_be_forwarded_to_a_formular_site_in_which_I_can_edit_my_recipe() throws Throwable {
		String page = BrowserDriver.getPageLoaded();
		if(!page.startsWith("http://localhost:8080/recipe/edit/"))
			throw new Exception("Recipe Edit Error!");
	}

	@Given("^I am on the edit-recipe-formular$")
	public void I_am_on_the_edit_recipe_formular() throws Throwable {
		String page = BrowserDriver.getPageLoaded();
		if(!page.startsWith("http://localhost:8080/recipe/edit/"))
			throw new Exception("Recipe Edit Error!");
	}

	@When("^I press the save-button$")
	public void I_press_the_save_button() throws Throwable {
		BrowserDriver.fillTextfield("content_ifr", changes);
		BrowserDriver.submitFormular();
	}

	@Then("^the changes should be saved and the recipe should be shown$")
	public void the_changes_should_be_saved_and_the_recipe_should_be_shown() throws Throwable {
		String page = BrowserDriver.getPageLoaded();
		if(!page.startsWith("http://localhost:8080/recipe/"))
			throw new Exception("Recipe Edit Error!");
		
		//Überprüfen ob Änderungen übernommen wurden
//		if(BrowserDriver.findText(changes)==false){
//			throw new Exception("Recipe Edit Error!");
//		}
	}
}
