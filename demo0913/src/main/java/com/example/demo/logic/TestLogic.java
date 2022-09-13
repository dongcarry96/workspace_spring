package com.example.demo.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

//@Service
public class TestLogic {
	Logger logger = LoggerFactory.getLogger(TestLogic.class);
	public void testList() {
		logger.info("testList 호출 성공");
	}
}
