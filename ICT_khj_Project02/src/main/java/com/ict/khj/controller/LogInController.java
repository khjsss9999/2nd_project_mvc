package com.ict.khj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.khj.dao.UserVO;
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
	
	@PostMapping("join_ok")
	public ModelAndView joinOK(HttpServletRequest request, UserVO uvo) {
		ModelAndView mv = new ModelAndView("redirect:/");
		uvo.setUser_pwd(passwordEncoder.encode(uvo.getUser_pwd()));
		uvo.setUser_register("1");
		uvo.setUser_type("0");
		try {
			int res1 = logInService.userJoin(uvo);
			if(res1 > 0) {
				mv.addObject("join_ok", "true");
				return mv;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("error");
	}
}
