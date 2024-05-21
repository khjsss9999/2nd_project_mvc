package com.ict.khj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.khj.common.SessionUserVO;
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
				HttpSession session = request.getSession();
				SessionUserVO suvo = new SessionUserVO();
				suvo.setJoin("1");
				session.setAttribute("suvo", suvo);
				return mv;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("error");
	}
	
	@GetMapping("normal_login.do")
	public ModelAndView nomalLogIn() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
// 2024-05-21 여기까지 한거	
//	@PostMapping("normal_login_ok")
//	public ModelAndView nomalLogInOK(HttpServletRequest request, UserVO uvo) {
//		ModelAndView mv = new ModelAndView("redirect:/");
//		UserVO uvo2 = logInService.nomalLogin(uvo.getUser_id());
//		if(uvo2 != null && passwordEncoder.matches(uvo.getUser_pwd(), uvo2.getUser_pwd())) {
//			
//		}
//		return null;
//	}
}



















