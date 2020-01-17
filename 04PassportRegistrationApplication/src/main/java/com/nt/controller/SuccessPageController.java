package com.nt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.constant.PassportAppConstant;

@Controller
public class SuccessPageController {
		@RequestMapping("/sussPage")
		public String showSuccPage(HttpServletRequest req,Model model) {
				model.addAttribute("passPortNo", req.getParameter("passPortNo"));
			return PassportAppConstant.SUCC_PAGE_STR;
		}
}
