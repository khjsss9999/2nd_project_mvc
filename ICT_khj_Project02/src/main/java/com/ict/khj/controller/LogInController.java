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
import com.ict.khj.dao.FindUserVO;
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
	
	@PostMapping("normal_login_ok")
	public ModelAndView nomalLogInOK(HttpServletRequest request, UserVO uvo) {
		ModelAndView mv = new ModelAndView("redirect:/");
		UserVO uvo2 = logInService.nomalLogin(uvo.getUser_id());
		if(uvo2 != null && passwordEncoder.matches(uvo.getUser_pwd(), uvo2.getUser_pwd())) {
			HttpSession session = request.getSession();
			SessionUserVO suvo = new SessionUserVO();
			suvo.setUser_idx(uvo2.getUser_idx());
			suvo.setUser_name(uvo2.getUser_name());
			suvo.setUser_type(uvo2.getUser_type());
			suvo.setLogin("1");
			session.setAttribute("suvo", suvo);
			return mv;
		}
		return null;
	}
	
	@GetMapping("id_pw_find.do")
	public ModelAndView nomalIPFind() {
		ModelAndView mv = new ModelAndView("id_pw_find");
		return mv;
	}
	
	@GetMapping("update_pwd.do")
	public ModelAndView updatePwd() {
		return new ModelAndView("pwdupdate");
	}
	
	@PostMapping("update_pwd_ok")
	public ModelAndView updatePwdOK(HttpSession session,FindUserVO fuvo ) {
		ModelAndView mv = new ModelAndView("redirect:/");
		SessionUserVO suvo = (SessionUserVO) session.getAttribute("suvo");
		fuvo.setUser_idx(suvo.getUser_idx());
		fuvo.setUser_pwd(passwordEncoder.encode(fuvo.getUser_pwd()));
		int res = logInService.expwdUpdate(fuvo);
		session.removeAttribute("suvo");
		return mv;
	}
}



















