package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.domain.UserDetailsBean;
/**
 * Controller for handle UserRegistartionForm page
 * @author Shekhar
 *
 */
@Controller
public class UserRegistrationFormController {
	
	
	
	/**
	 * 	This method for launching registration from page
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String showRegistrationForm(Model model) {
		return null;
	}
	
	/**
	 *  This method for handle register button
	 * @param userBean
	 * @param model
	 * @return
	 */
	@RequestMapping("/registerUserDetails")
	public String handleRegisterBtn(UserDetailsBean userBean,Model model) {
		
		return null;
	}
}
