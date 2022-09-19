package com.spring4.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.google.gson.Gson;

//여기선 어노테이션 사용하지 않는다.
//@RestController
public class BoardController extends MultiActionController {
	Logger logger = Logger.getLogger("BoardController.class");
	private BoardLogic boardLogic = null;
	public void setBoardLogic(BoardLogic boardLogic) {
		this.boardLogic = boardLogic;
	}
	public String jsonBoardList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardList호출 성공");
		Map<String,Object> pMap = new HashMap<>(); // RequestParam Map<String,Object> pMap
		List<Map<String,Object>> boardList = null;
		boardList = boardLogic.boardList(pMap);
		req.setAttribute("boardList", boardList); // scope:request
		Gson g = new Gson();
		String temp = g.toJson(boardList);
		// let doc = JSON.stringify(temp); let array = doc.parse(doc) 
		logger.info(boardList);
		return "forward:jsonBoardList.jsp";
	}

	public String boardList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardList호출 성공");
		Map<String,Object> pMap = new HashMap<>(); // RequestParam Map<String,Object> pMap
		List<Map<String,Object>> boardList = null;
		boardList = boardLogic.boardList(pMap);
		req.setAttribute("boardList", boardList); // scope:request
		logger.info(boardList);
		return "forward:list.jsp";
	}

	public String boardDetail(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardDetail호출 성공");
		Map<String,Object> pMap = new HashMap<>();
		boardLogic.boardDetail(pMap);
		return "forward:read.jsp";
	}

	public String boardInsert(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardInsert 호출 성공");
		Map<String,Object> pMap = new HashMap<>();
		boardLogic.boardInsert(pMap);
		// redirect-forward, forward->forward(에러)
		return "redirect:boardList.jsp";
	}

	public String boardUpdate(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardUpdate 호출 성공");
		Map<String,Object> pMap = new HashMap<>();
		boardLogic.boardUpdate(pMap);
		// redirect-forward, forward->forward(에러)
		return "redirect:boardList.jsp";
	}

	public String boardDelete(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardDelete  호출 성공");
		Map<String,Object> pMap = new HashMap<>();
		boardLogic.boardDelete(pMap);
		// redirect-forward, forward->forward(에러)
		return "redirect:boardList.jsp";
	}
}
