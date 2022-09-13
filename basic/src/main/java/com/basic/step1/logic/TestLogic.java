package com.basic.step1.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.step1.dao.TestDao;

@Service
public class TestLogic {
	Logger logger = LoggerFactory.getLogger(TestLogic.class);
	@Autowired(required = false)
	private TestDao testDao = null;

	public List<Map<String, Object>> testList(Map<String, Object> pmap) {
		logger.info("TestLogic : testList 호출 성공");
		List<Map<String, Object>> testList = null;
		testList = testDao.testList(pmap);
		return testList;
	}

	public void testDeleteAll(String[] atestnos) {
		testDao.testDeleteAll(atestnos);

	}

	public void testInsertAll() {
		testDao.testInsertAll();
		
	}
	
}