package com.nt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.constant.PassportAppConstant;
import com.nt.domain.EducationaldetailsBean;
import com.nt.domain.PassportAppDetaisBean;
import com.nt.domain.PersionalDetailsBean;
import com.nt.service.PassportRegistrationMngtService;

@Controller
public class ApplicationReviewController {
	@Autowired
	private PassportRegistrationMngtService passportService;
		@RequestMapping("/showreViewForm")
		public String showAppReviewForm(Model model,HttpServletRequest req) {
			PassportAppDetaisBean pAppDetails=new PassportAppDetaisBean();
			pAppDetails.setPid(Integer.parseInt(req.getParameter("pid")));
			model.addAttribute("pAppDetails", pAppDetails);
			
			PersionalDetailsBean pDetails = passportService.fecthDetailsById(Integer.parseInt(req.getParameter("pid")));
			model.addAttribute("pDetails", pDetails);
			
			EducationaldetailsBean edDetails = passportService.fecthEDdetailsById(Integer.parseInt(req.getParameter("eid")));
			model.addAttribute("edDetails", edDetails);
			return PassportAppConstant.APP_REV_STR;
		}
		
		@RequestMapping("/handleConfirmBtn")
		public String handleConfirmBtn(@ModelAttribute("pAppDetails")PassportAppDetaisBean pDetailsBean,Model model) {
			PassportAppDetaisBean details = passportService.savePassPortDetails(pDetailsBean);
			System.out.println(details);
			if(details!=null) {
				if(details.getPassPortId()>0)
					model.addAttribute("appDetails", details);
				return "redirect:/sussPage?passPortNo="+details.getPassPortNo();
			}
			return "redirect:/errorPage";
		}
		
		
}
