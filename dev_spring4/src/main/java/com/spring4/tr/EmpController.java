package com.spring4.tr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class EmpController extends MultiActionController {
	Logger logger = Logger.getLogger(EmpController.class);
	private EmpLogic empLogic = null;
	public void setEmpLogic(EmpLogic empLogic) {
		this.empLogic = empLogic;
	}

	public String doEmp(HttpServletRequest req, HttpServletResponse res) {
		logger.info("dev_spring : empController 호출 성공");
		int result = 0;
		result = empLogic.cudEmp();
		return "redirect:empList.sp";
	}
}
