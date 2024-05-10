package com.ict.khj.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CCenterDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int getTotalCount() {
		try {
			return sqlSessionTemplate.selectOne("ccenter.count");
		} catch (Exception e) {
			System.out.println(e);
		}
		return -1;
	}
	
	public List<CCenterVO> CCenterList(int offset, int limit) {
		try {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("offset", offset);
			map.put("limit", limit);
			return sqlSessionTemplate.selectList("ccenter.list", map); 
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	public int getFaqInsert(CCenterVO ccvo) {
		try {
			return sqlSessionTemplate.insert("ccenter.insert", ccvo);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return -1;
	}
}
