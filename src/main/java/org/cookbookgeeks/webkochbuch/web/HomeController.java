package org.cookbookgeeks.webkochbuch.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page which are not directly about recipes,
 * such as start page, login/register page etc.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/**
	 * Shows the contact form.
	 * 
	 * @return the view contact.jsp
	 */
	@RequestMapping(method=RequestMethod.GET, value="/contact")
	public String contactForm() {
		logger.debug("Returning view with contact form");
		
		return "contact";
	}
	
	/**
	 * Shows the category-overview.
	 * 
	 * @return the view categories.jsp
	 */
	@RequestMapping(method=RequestMethod.GET, value="/categories")
	public String categoryView() {
		logger.debug("Returning view with overview of categories");
		
		return "categories";
	}
	
}
