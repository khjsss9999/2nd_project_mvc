package com.ict.khj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.khj.dao.LogInDAO;
import com.ict.khj.dao.UserVO;

@Service
public class LogInServiceImpl implements LogInService{
	@Autowired
	private LogInDAO logInDAO;
	@Override
	public String idChk(String user_id) {
		
		return logInDAO.idChk(user_id);
	}
	
	@Override
	public int userJoin(UserVO uvo) {
		
		return logInDAO.userJoin(uvo);
	}
}
