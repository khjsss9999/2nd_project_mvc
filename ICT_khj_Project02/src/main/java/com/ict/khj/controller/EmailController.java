package com.ict.khj.controller;

import java.util.Random;

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
	
	@PostMapping("find_user_pw")
	public ModelAndView findUserPW(String user_id, String email_pwd, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("id_pw_find");
		try {
			FindUserVO fuvo = logInService.normalFindPW(user_id);
			if(fuvo != null && (email_pwd.equals(fuvo.getUser_f_email()+ "@" + fuvo.getUser_b_email()))) {
				Random random = new Random();
				String randomNumber = String.valueOf(random.nextInt(1000000) % 1000000);
				if(randomNumber.length() < 6) {
					int substract = 6 - randomNumber.length();
					StringBuffer sb = new StringBuffer();
					for(int i=0; i<substract; i++) {
						sb.append("0");
					}
					sb.append(randomNumber);
					randomNumber = sb.toString();
				}
				String pwd = passwordEncoder.encode(randomNumber);
				fuvo.setUser_pwd(pwd);
				System.out.println(fuvo.getUser_idx());
				int result = logInService.npwdUpdate(fuvo);
				if(result > 0) {
					mailService.sendEmail(randomNumber, email_pwd);
					return new ModelAndView("pwdconfirm");
				}
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		mv.addObject(email_pwd, mv);
		return mv;
	}

}






















