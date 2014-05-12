package org.cookbookgeeks.webkochbuch;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Arrays;
import java.util.Date;

import javax.annotation.Resource;

import org.cookbookgeeks.webkochbuch.service.RecipeService;
import org.cookbookgeeks.webkochbuch.domain.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/applicationContext.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-Context.xml"
})
public class RecipeControllerTest {

	 @Autowired
	 private WebApplicationContext wac;
	 private MockMvc mockMvc;
	 
	 @Mock
	 @Resource(name="recipeService")
	 private RecipeService recipeServiceMock;
	 
//	 @Autowired
//	 private RecipeService recipeServiceMock;
	 
	 Recipe first, second;
	 
	 @Before
	 public void setup() 
	 {
		 this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		 MockitoAnnotations.initMocks(this);
	 }
	 
	 @Test
	 public void getRecipe() throws Exception
	 {
		 this.mockMvc.perform(get("/recipe/0"))
		 	.andExpect(status().isOk())
		 	.andExpect(view().name("recipe"));
	 }
	 

 
	 @Test
	 public void findAllRecipes() throws Exception {
 	
       first = new Recipe();
       first.setId(1);
       first.setTitle("Rezept 1");
       first.setDescription("Beschreibung 1");
       first.setContent("Beschreibung 1");
       first.setDescription("Blah fasel");
       first.setPreparationEndurance(20);
       first.setTotalEndurance(30);
       first.setCreation(new Date());
       
       second = new Recipe();
       second.setId(1);
       second.setTitle("Rezept 2");
       second.setDescription("Beschreibung 2");
       second.setContent("Beschreibung 2");
       second.setDescription("Blah fasel 2");
       second.setPreparationEndurance(41);
       second.setTotalEndurance(50);
       second.setCreation(new Date());
       
       when(recipeServiceMock.getAll()).thenReturn(Arrays.asList(first, second));
       
       mockMvc.perform(get("/list"))
       	.andExpect(status().isOk())
       	.andExpect(view().name("showList"));
       
       
	 }    
 
	 
	 @Test
	 public void createRecipes(){
	    		
	 }
	 
	 @Test
	 public void deleteTestRecipes(){
		 
	 }
	
//	private MockMvc mockMvc;
//
//	Recipe first, second;
//	
////    @Autowired
////    private RecipeService recipeServiceMock;
//	
//	
////	@Resource(name="recipeService")
////	private RecipeService recipeServiceMock;
//	
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//
//    @Before
//    public void setUp() {
//        //We have to reset our mock between tests because the mock objects
//        //are managed by the Spring container. If we would not reset them,
//        //stubbing and verified behavior would "leak" from one test to another.
////        Mockito.reset(recipeServiceMock);
//
////        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//        


		
}
