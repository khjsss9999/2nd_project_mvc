package com.ict.khj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.khj.service.LogInService;

@Controller
public class LogInController {
	@Autowired
	private LogInService logInService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("login_join.do")
	public ModelAndView getLogInJoin() {
		ModelAndView mv = new ModelAndView("login_join");
		return mv;
	}
	
	@GetMapping("join.do")
	public ModelAndView getJoin() {
		ModelAndView mv = new ModelAndView("ajax/join");
		return mv;
	}
	
}
