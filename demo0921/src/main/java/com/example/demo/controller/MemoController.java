package com.example.demo.controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.logic.MemoLogic;


@Controller
public class MemoController {
Logger logger = LogManager.getLogger(MemoController.class);
	
	@Autowired(required=false)
	private MemoLogic memoLogic = null;
	
	@GetMapping("memoInsert")
	public String memoInsert(@RequestParam Map<String,Object> pMap) {
		logger.info("컨트롤러의 memoInsert호출 성공! 넘어온 pMap: "+pMap);
		int result = 0;
		result = memoLogic.memoInsert(pMap);
		return "redirect:/auth/index.jsp";
	}
}
