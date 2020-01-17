package com.nt.controller;

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
import com.nt.domain.UserUnlockDetailsBean;
import com.nt.service.UserMngtService;
/**
 * Controller for handle UserRegistartionForm page
 * @author Shekhar
 *
 */
@Controller
public class UserRegistrationFormController {
	@Autowired
	private UserMngtService userService;
	
	/**
	 * 	This method for launching registration from page
	 * @param model
	 * @return
	 */
	@RequestMapping("/reg")
	public String showRegistrationForm(Model model) {
		model.addAttribute("details",new UserDetails());
		return RegistrationConstant.REGSTRATIONFORM;
	}
	
	/**
	 *  This method for handle register button
	 * @param userBean
	 * @param model
	 * @return
	 */
	@RequestMapping("/registerUserDetails")
	public String handleRegisterBtn(@ModelAttribute("details") UserDetails userBean,Model model) throws Exception {
	boolean saveUserDetails = userService.saveUserDetails(userBean);
	if(saveUserDetails) {
	model.addAttribute("succMsg","Succesfully details registered,further process check your Email");
	}
	else {
		model.addAttribute("succMsg"," Details are not registered");
	}
		return RegistrationConstant.REGSTRATIONFORM;
	}
	
	/**
	 * This method for handle unlock button
	 * @param req
	 * @param model
	 * @return
	 */	
	@RequestMapping("/unlockForm")
	public String unlockRegForm(HttpServletRequest req,Model model) {
		UserUnlockDetailsBean userUnlockDetailsBean = new UserUnlockDetailsBean();
		userUnlockDetailsBean.setEmail(req.getParameter("email"));
		model.addAttribute("unlockDetails",userUnlockDetailsBean);
		return RegistrationConstant.UNLOCKFORMSTR;
	}
	
	/**
	 * This mathod for fetching record by email id
	 * @return
	 */
	@GetMapping("/validate")
	public @ResponseBody  String fetchRecoredByEmailId(HttpServletRequest req) {
		String email=req.getParameter("emailId");
		 	return userService.getRecoredByEmailId(email);
	}
}
