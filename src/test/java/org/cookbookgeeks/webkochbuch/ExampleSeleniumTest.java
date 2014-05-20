package org.cookbookgeeks.webkochbuch;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@Category(IntegrationTest.class)^
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/applicationContext.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-Context.xml"
})
public class ExampleSeleniumTest {
	
	String recipelink;
	
	@Test
	public void createTestRecipe() throws Exception{
		String startpage = "http://localhost:81/";
		BrowserDriver.loadPage(startpage);
		if(startpage.equals(BrowserDriver.getPageLoaded())==false){
			throw new Exception("Seite nicht verfügbar!");
		}
		BrowserDriver.clickLink("Rezept erstellen");
		
		BrowserDriver.fillTextfield("title", "Testrezept");
		BrowserDriver.fillTextfield("description", "Beschreibung blah fasel");
		BrowserDriver.fillTextfield("preparationEndurance", "20");
		BrowserDriver.fillTextfield("totalEndurance", "30");
		BrowserDriver.fillTextfield("content_ifr", "Blah falsel Zutaten usw");
		
		//Submit
		BrowserDriver.submitFormular();
		
		//check if the site of the recipe is shown
		recipelink = BrowserDriver.getPageLoaded();
		if(!recipelink.startsWith("http://localhost:81/recipe/"))
			throw new Exception("Recipe Creation Error!");
	}

	
	@Test
	public void deleteTestRecipe(){
		BrowserDriver.loadPage("http://localhost:81/list");
		BrowserDriver.clickLink("Testrezept");
		BrowserDriver.clickLinkByID("editdelete");
	}
}
