package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.Controller.TestController;
import com.example.demo.logic.TestLogic;

@Configuration
public class ControllerConfig {
	Logger logger = LoggerFactory.getLogger(TestController.class);
	@Bean
	public TestController testController() {
		TestController testController = new TestController();
		TestLogic testLogic = new TestLogic();
		// setter객체 주입법 코드로 처리함
		// 만일 생성지 객체 주입법 코드로 처리하려면 어떡하지?
		// 다른 이종간에 연계에 있어서 필요한 조립기 역할필요
		testController.setTestLogic(testLogic);
		return testController;
	}
}
