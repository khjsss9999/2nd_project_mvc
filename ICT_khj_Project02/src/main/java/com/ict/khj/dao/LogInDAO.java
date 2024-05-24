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
		try {
			
			return sqlSessionTemplate.insert("login.join", uvo);
		} catch (Exception e) {
			System.out.println(e);
		}
		return -1;
	}
	
	public UserVO nomalLogin(String user_id) {
		try {
			
			return sqlSessionTemplate.selectOne("login.loginok", user_id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public FindUserVO normalFindPW(String user_id) {
		try {
			
			return sqlSessionTemplate.selectOne("login.n_findpwd", user_id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public int npwdUpdate(FindUserVO fuvo) {
		try {
			
			return sqlSessionTemplate.update("login.npwd", fuvo);
		} catch (Exception e) {
			System.out.println(e);
		}
		return -1;
	}
	
	public int expwdUpdate(FindUserVO fuvo) {
		try {
			return sqlSessionTemplate.update("login.expwd", fuvo);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return -1;
	}
	
	public FindUserVO nomalFindID(String user_name) {
		try {
			return sqlSessionTemplate.selectOne("login.n_findid", user_name);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
