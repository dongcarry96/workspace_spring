package com.basic.step1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// 어노테이션 - 객체주입하는 방법에 사용
@Controller
public class AuthController {
	@RequestMapping(value = "/login.sp4", method = RequestMethod.GET)
	public String login(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("login 호출 성공");
		String path = "redirect:index.jsp";
		return path;
	}
}
