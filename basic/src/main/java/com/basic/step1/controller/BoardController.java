package com.basic.step1.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.basic.step1.logic.BoardLogic;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired(required = false)
	private BoardLogic boardLogic = null;
	/*
	 * dev_web과 basic 비용 계산 해보기 Map선언만함 - @RequestParam HashMapBinder가 필요없어짐
	 * ModelAndView도 필요없음 - Model 리턴타입 : ModelAndView -> String
	 */

	@GetMapping("boardDelete.sp4")
	public Object boardDelete(@RequestParam Map<String, Object> pMap) {
		logger.info("boardDelete 호출 성공");
		int result = 0;
		result = boardLogic.boardDelete(pMap);
		String path = "redirect:boardList.pj";
		return path;
	}

	@GetMapping("boardUpdate.sp4")
	public Object boardUpdate(@RequestParam Map<String, Object> pMap) {
		logger.info("boardUpdate 호출 성공");
		int result = 0;
		result = boardLogic.boardUpdate(pMap);
		// jsp -> action(update) -> action(select) ---유지(forward)---> boardList.jsp
		// 밑에 방법은 redirect이므로 유지가 되지 않는다
		String path = "redirect:boardList.sp4"; // 페이지를 리턴해야함
		// forward로 전송해야 할 때 쓰는 방법!!
		return path;
	}

	@GetMapping("boardDetail.sp4")
	public Object boardDetail(Model model, @RequestParam Map<String, Object> pMap) {
		logger.info("boardDetail 호출 성공");
		List<Map<String, Object>> boardList = null;
		boardList = boardLogic.boardDetail(pMap);
		model.addAttribute("boardList", boardList);
		return "forward:read.jsp";
	}

	@GetMapping("boardList.sp4")
	public String boardList(Model model, @RequestParam Map<String, Object> pMap) {
		logger.info("boardList 호출 성공");
		List<Map<String, Object>> boardList = null;
		boardList = boardLogic.boardList(pMap);
		model.addAttribute("boardList", boardList);
		return "forward:boardList.jsp";
	}

	@GetMapping("boardInsert.sp4")
	public String boardInsert(@RequestParam Map<String, Object> pMap) {
		logger.info("boardInsert 호출 성공");
		int result = 0;
		result = boardLogic.boardInsert(pMap);
		return "redirect:boardList.sp4"; // 페이지를 리턴해야함
	}
}
