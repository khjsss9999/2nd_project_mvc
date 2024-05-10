package com.ict.khj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.khj.dao.CCenterDAO;
import com.ict.khj.dao.CCenterVO;

@Service
public class CCenterServiceImpl implements CCenterService{
	@Autowired
	private CCenterDAO cCenterDAO;

	@Override
	public int getTotalCount() {
		return cCenterDAO.getTotalCount();
	}
	
	@Override
	public List<CCenterVO> CCenterList(int offset, int limit) {
		
		return cCenterDAO.CCenterList(offset, limit);
	}

	@Override
	public int getFaqInsert(CCenterVO ccvo) {

		return cCenterDAO.getFaqInsert(ccvo);
	}
}
