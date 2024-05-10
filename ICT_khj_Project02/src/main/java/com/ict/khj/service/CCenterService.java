package com.ict.khj.service;

import java.util.List;

import com.ict.khj.dao.CCenterVO;

public interface CCenterService {
	public int getTotalCount();
	public List<CCenterVO> CCenterList(int offset, int limit);
	public int getFaqInsert(CCenterVO ccvo);
}
