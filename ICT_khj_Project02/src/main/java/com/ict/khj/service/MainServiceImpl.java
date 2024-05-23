package com.ict.khj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.khj.dao.EventVO;
import com.ict.khj.dao.MainDAO;
import com.ict.khj.dao.UserVO;

@Service
public class MainServiceImpl implements MainService{
	@Autowired
	private MainDAO mainDAO;
	
	@Override
	public int getEventRefresh(EventVO evo) {

		return mainDAO.getEventRefresh(evo);
	}
	
	@Override
	public int getTotalCount() {
		return mainDAO.getTotalCount();
	}
	
	@Override
	public List<EventVO> getEventList(int offset, int limit) {
		return mainDAO.getEventList(offset, limit);
	}
	
	@Override
	public UserVO getUserDetail(String user_idx) {

		return mainDAO.getUserDetail(user_idx);
	}
}
