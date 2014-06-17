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
import org.springframework.http.MediaType;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/applicationContext.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-Context.xml"
})
public class CategoryControllerTest {

	@Autowired
	 private WebApplicationContext wac;
	 private MockMvc mockMvc;
	 
	 @Mock
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
	 public void getCategories() throws Exception
	 {
		 this.mockMvc.perform(get("/categories"))
		 	.andExpect(status().isOk())
		 	.andExpect(view().name("categories"));
	 }
	 
	 @Test
	 public void getCategoryById() throws Exception
	 {
		 this.mockMvc.perform(get("/category/1"))
		 	.andExpect(status().isOk())
		 	.andExpect(view().name("showList"));
	 }
}
