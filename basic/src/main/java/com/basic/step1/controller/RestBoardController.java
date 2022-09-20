package com.basic.step1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/board/*")
public class RestBoardController {
	@GetMapping(value = "dong.sp4", produces = "text/plain; charset=utf-8")
	public String dong() {
		return "한글처리";
	}
   @GetMapping(value="jsonNames.sp4", produces="application/json; charset=utf-8")
   public String jsonFormat() {
	   List<Map<String,Object>> names = new ArrayList<>();
	   Map<String,Object> rmap = new HashMap<>();
	   rmap.put("mem_id", "dongcarry");
	   rmap.put("mem_name", "동캐리");
	   names.add(rmap);
	   rmap = new HashMap<>();
	   rmap.put("mem_id", "end");
	   rmap.put("mem_name", "끝");
	   names.add(rmap);
	   Gson g = new Gson();
	   String temp = g.toJson(names);
	   return temp;
   }
}
