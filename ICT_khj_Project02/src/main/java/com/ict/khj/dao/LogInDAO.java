package com.ict.khj.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LogInDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
}
