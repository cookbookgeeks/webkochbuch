package org.cookbookgeeks.webkochbuch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/applicationContext.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-Context.xml"
})
@WebAppConfiguration
public class SearchControllerTest {

	
	@Test
    public void searchRecipesByTime() throws Exception{
//		throw new Exception("Not implementet");
	}
	
	@Test
    public void searchRecipesByName() throws Exception{
//		throw new Exception("Not implementet");
	}
	
}
