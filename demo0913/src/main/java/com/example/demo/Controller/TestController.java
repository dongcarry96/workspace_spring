package com.example.demo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.logic.TestLogic;

//@Controller
public class TestController {
	Logger logger = LoggerFactory.getLogger(TestController.class);
	//@Autowired
	private TestLogic testLogic = null;
	//setter객체주입법 코드
	public void setTestLogic(TestLogic testLogic) {
		this.testLogic = testLogic;
	}
	public String testList() {
		logger.info("testList호출 성공 : " + testLogic);
		testLogic.testList();
		return "test/testList";
	}
}
