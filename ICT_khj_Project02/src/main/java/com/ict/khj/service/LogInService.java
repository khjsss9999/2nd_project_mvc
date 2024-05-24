package com.ict.khj.service;

import com.ict.khj.dao.FindUserVO;
import com.ict.khj.dao.UserVO;

public interface LogInService {
	public String idChk(String user_id);
	public int userJoin(UserVO uvo);
	public UserVO nomalLogin(String user_id);
	public FindUserVO normalFindPW(String user_id);
	public int npwdUpdate(FindUserVO fuvo);
	public int expwdUpdate(FindUserVO fuvo);
	public FindUserVO nomalFindID(String user_name);
}
