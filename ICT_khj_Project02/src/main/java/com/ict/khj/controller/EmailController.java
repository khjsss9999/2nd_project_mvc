package com.ict.khj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.khj.dao.FindUserVO;
import com.ict.khj.service.LogInService;
import com.ict.khj.service.MailService;

@Controller
public class EmailController {
	@Autowired
	private MailService mailService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired 
	private LogInService logInService;
	
//	@PostMapping("find_user_pw")
//	public ModelAndView findUserPW(String user_id, String email_pwd, HttpServletRequest request) {
//		ModelAndView mv = new ModelAndView("id_pw_find");
//		try {
//			FindUserVO fuvo = logInService.normalFindPW(user_id);
//			if(fuvo != null && (email_pwd.equals(fuvo.getUser_f_email()+ "@" + fuvo.getUser_b_email()))) {
//				
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
// 2024-05-22 여기까지	
}
