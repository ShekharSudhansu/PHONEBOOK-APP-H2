package com.hix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hix.constants.SSAContstants;
import com.hix.domain.CitizenDetailsDomain;
import com.hix.exception.SSNoNotFound;
import com.hix.service.SsaMngtService;

@Controller
public class CitizenDetailsController {
	@Autowired
	private SsaMngtService sService;
	
		/**
		 * This method for launching form page
		 * @param model
		 * @return
		 */
	
		@RequestMapping("/")
		public String showForm(Model model) {
			CitizenDetailsDomain ctDomain=new CitizenDetailsDomain();
			model.addAttribute("domain", ctDomain);
			List<String> allStates = sService.getAllStates();
			model.addAttribute("allState", allStates);
			return SSAContstants.REG_FORM_STR;
			
		}
		
		/**
		 * This method for handle the citizen_form page subnitions
		 * @return
		 */
		
		
		@RequestMapping("/handleSubmitBtn")
		public String submitCitizenDetails(@ModelAttribute("domain")CitizenDetailsDomain cdDomain,Model model) {
		CitizenDetailsDomain saveCitizenDetails = sService.saveCitizenDetails(cdDomain);
			if(saveCitizenDetails!=null) {
				 model.addAttribute("succMsg","Citizen details successfully submited."
				 		+ " your ssNumber:"+saveCitizenDetails.getSsNo());
		
			}
			else {
				 model.addAttribute("failMsg","Citizen details  submition fail.");
			}
			return SSAContstants.REG_FORM_STR;
		}
	/*
	 * @GetMapping("/doublePosting") private String forDoublePosting() { return
	 * SSAContstants.REG_FORM_STR; }
	 */
		
		
		
		
}
