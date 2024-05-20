package com.ict.khj.service;

import com.ict.khj.dao.UserVO;

public interface LogInService {
	public String idChk(String user_id);
	public int userJoin(UserVO uvo);
}
