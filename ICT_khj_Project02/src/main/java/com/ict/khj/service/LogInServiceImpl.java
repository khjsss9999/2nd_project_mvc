package com.ict.khj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.khj.dao.LogInDAO;

@Service
public class LogInServiceImpl implements LogInService{
	@Autowired
	private LogInDAO logInDAO;
	
}
