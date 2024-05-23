package com.ict.khj.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LogInDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public String idChk(String user_id) {
		try {
			int result = sqlSessionTemplate.selectOne("login.idchk", user_id);
			if(result > 0) {
				return "0";
			}
			return "1";
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	public int userJoin(UserVO uvo) {
		
		return sqlSessionTemplate.insert("login.join", uvo);
	}
	
	public UserVO nomalLogin(String user_id) {

		return sqlSessionTemplate.selectOne("login.loginok", user_id);
	}
	
	public FindUserVO normalFindPW(String user_id) {

		return sqlSessionTemplate.selectOne("login.n_findpwd", user_id);
	}
	
	public int npwdUpdate(FindUserVO fuvo) {

		return sqlSessionTemplate.update("login.npwd", fuvo);
	}
}
