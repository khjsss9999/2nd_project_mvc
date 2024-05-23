package com.ict.khj.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MainDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int getEventRefresh(EventVO evo) {

		return sqlSessionTemplate.insert("event.insert", evo);
	}
	
	public int getTotalCount() {
		try {
			
			return sqlSessionTemplate.selectOne("event.count");
		} catch (Exception e) {
			System.out.println(e);
		}
		return -1;
	}
	
	public List<EventVO> getEventList(int offset, int limit) {
		try {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("offset", offset);
			map.put("limit", limit);
			return sqlSessionTemplate.selectList("event.list", map);
		} catch (Exception e) {
			System.out.println(e);
		}
			return null;
	}
	
	public UserVO getUserDetail(String user_idx) {

		return sqlSessionTemplate.selectOne("login.detail", user_idx);
	}
	
}
