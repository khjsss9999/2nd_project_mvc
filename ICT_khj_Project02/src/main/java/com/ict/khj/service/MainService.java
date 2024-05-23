package com.ict.khj.service;

import java.util.List;

import com.ict.khj.dao.EventVO;
import com.ict.khj.dao.UserVO;

public interface MainService {
	public int getEventRefresh(EventVO evo);
	public int getTotalCount();
	public List<EventVO> getEventList(int offset, int limit);
	public UserVO getUserDetail(String user_idx);
}
