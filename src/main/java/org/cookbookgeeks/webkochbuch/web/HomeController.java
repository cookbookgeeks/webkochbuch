/*
 * Copyright (C) 2014  Cookbookgeeks
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package org.cookbookgeeks.webkochbuch.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String home(Model model) {
		logger.info("Returning home view");
		return "home";
	}
	
	/**
	 * Shows the contact form.
	 * 
	 * @return the view contact.jsp
	 */
	@RequestMapping(method=RequestMethod.GET, value="/contact")
	public String contactForm() {
		logger.info("Returning view with contact form");
		return "contact";
	}
	
	/**
	 * Shows the category-overview.
	 * 
	 * @return the view categories.jsp
	 */
	@RequestMapping(method=RequestMethod.GET, value="/categories")
	public String categoryView() {
		logger.info("Returning view with overview of categories");
		return "categories";
	}
	
	/**
	 * Shows the admin-backend.
	 * 
	 * @return the view admin.jsp
	 */
	@RequestMapping(method=RequestMethod.GET, value="/admin")
	public String adminBackend() {
		logger.info("Returning view with contact form");
		return "admin";
	}

	/**
	 * Shows the log-out view after logging out.
	 * 
	 * @return the view logout.jsp
	 
	@RequestMapping(method=RequestMethod.GET, value="/logout")
	public String logOut() {
		logger.info("Returning logout-view ");
		return "logout";
	}
	*/
	/** 
	 * Shows the access-denied view.
	 * 
	 * @return the view denied.jsp
	 */
	@RequestMapping(method=RequestMethod.GET, value="/denied")
	public String denied() {
		logger.info("Returning denied-view ");
		return "denied";
	}
	
	/** 
	 * Shows the home view with parameter for login-error
	 * 
	 * @return the view home.jsp
	 */
	@RequestMapping(value="/login", method = RequestMethod.GET)
    public String getLogin(@RequestParam(value="error", required=false) boolean error, 
            Model model){

        if (error == true) {
            // Assign an error message
            model.addAttribute("error", "You have entered an invalid username or password!");
        } else {
        	model.addAttribute("error", "");
        }
        return "home";
    }
	
	/** 
	 * Shows the home view with parameter for log-out
	 * 
	 * @return the view home.jsp
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
    public String getLogout(@RequestParam(value="logout", required=false) boolean logout, 
            Model model){

        if (logout == true) {
            // Assign an error message
            model.addAttribute("logout", "You have been logged out successfull!");
        } else {
        	model.addAttribute("logout", "");
        }
        return "home";
    }
		
}
