package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nt.constant.RegistrationConstant;
import com.nt.domain.UserDetails;
import com.nt.domain.UserLoginDetails;
import com.nt.entity.UserRegistrationDetailsEntity;
import com.nt.service.UserMngtService;

@Controller
public class loginFormController {
	@Autowired
	private UserMngtService userService;
/**
 * 	This method for launching login page
 * @param model
 * @return
 */
	
	@RequestMapping("/")
	public String getLoginForm(Model model) {
		UserLoginDetails loginDetails = new UserLoginDetails();
		model.addAttribute("loginBean", loginDetails);
		return RegistrationConstant.LOGINSTR;
	}
	
	/**
	 *  This methodn for handling login submition
	 * @param details
	 * @param model
	 * @return
	 */
	@RequestMapping("/userLogin")
	public String handleloginBtn(@ModelAttribute("loginBean") UserLoginDetails details, Model model) {
		UserRegistrationDetailsEntity entity = userService.checkCredintials(details);
		if (entity != null) {
			if ("lock".equals(entity.getStatus())) {
				model.addAttribute("errMsg", "Account is Locked");
			} else {
					return "redirect:/dashBoared";
			}
		} else {
			model.addAttribute("errMsg", "Enter valid credintials");
		}

		return RegistrationConstant.LOGINSTR;
	}
	 
	/**
	 *  This method for redireting to dashBoard page
	 * @return
	 */
	
	@RequestMapping("/dashBoared")
	public String showdashBoared() {
		return RegistrationConstant.DASHSTR;
				
	}
	
	/**
	 * This method for get all User details
	 */
	@RequestMapping("/displayAllRecords")
	public String displayAllRecord(Model model) {
		System.out.println("loginFormController.displayAllRecord()");
		List<UserDetails> fetchAllUserRecords = userService.fetchAllUserRecords();
		model.addAttribute("listDetails", fetchAllUserRecords);
		return RegistrationConstant.DPYALLRCDSTR;
	}
	
	

}
