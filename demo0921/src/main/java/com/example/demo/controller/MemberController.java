package com.example.demo.controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.logic.MemberLogic;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	Logger logger = LogManager.getLogger(MemberController.class);
	
	@Autowired(required=false)
	private MemberLogic memberLogic = null;
	
	@GetMapping("memberInsert")
	public String memberInsert(@RequestParam Map<String,Object> pMap) {
		logger.info("컨트롤러의 memberInsert호출 성공! 넘어온 pMap: "+pMap);
		int result = 0;
		result = memberLogic.memberInsert(pMap);
		return "redirect:/auth/index.jsp";
	}
}
