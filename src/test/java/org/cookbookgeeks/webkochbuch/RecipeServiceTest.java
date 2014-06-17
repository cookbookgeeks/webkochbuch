package org.cookbookgeeks.webkochbuch;

import java.util.Date;

import org.cookbookgeeks.webkochbuch.domain.Recipe;
import org.cookbookgeeks.webkochbuch.service.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/applicationContext.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-Context.xml"
})
public class RecipeServiceTest {

	 @Autowired
	 private WebApplicationContext wac;
	 private MockMvc mockMvc;
	 
//	 @Mock
//	 private RecipeService recipeServiceMock;
	 
	 @Mock
	 @Autowired
	 private RecipeService recipeServiceMock;
	 
	 Recipe first, second;
	 
	 @Before
	 public void setup() 
	 {
		 this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		 MockitoAnnotations.initMocks(this);
	 }
	 
	 @Test
	 public void updateRecipe(){
		 Recipe first = new Recipe();
	     first = new Recipe();
	     first.setTitle("Rezept 1");
	     first.setDescription("Beschreibung 1");
	     first.setContent("Beschreibung 1");
	     first.setDescription("Blah fasel");
	     first.setPreparationEndurance(20);
	     first.setTotalEndurance(30);
	     first.setCreation(new Date());
	     first.setUser(null);
	     
		 recipeServiceMock.update(first);
		 
	 }
	 
	  
}
