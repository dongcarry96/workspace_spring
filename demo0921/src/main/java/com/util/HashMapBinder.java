package com.util;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartHttpServletRequest;
/*
 * 텍스트 파일 처리(문자열 처리)- 숫자도 문자열 처리 -  숫자도 문자열로 처리 후 변경해서 출력
 * 바이너리 파일 처리(문자+숫자 파일) - 첨부파일은 바이너리 코드
 * 사용자가 화면에 입력하는 값을 받아오기 위해서 공통 코드를 만듦
 * 오라클 테이블의 컬럼의 수가 50개이면 req.getParameter()를 50번 써야 하는 것임
 * 산업과 관련된 테이블의 컬럼 수는 100개 이상 200개 인 것도 다반사 임
 * 따라서 스프링과 같은 프레임워크에서는 반복되는 코드를 줄이기 위한 유틸 기능의 클래스도 지원함
 */
public class HashMapBinder {
	Logger logger = LogManager.getLogger(HashMapBinder.class);
	HttpServletRequest req = null;
	MultipartHttpServletRequest mreq = null;
	public HashMapBinder(MultipartHttpServletRequest mreq) {
		this.mreq = mreq;
	}
	public void mbind(Map<String,Object> pMap) {
		pMap.clear();//  초기화를 해줌
		Enumeration<String> em = mreq.getParameterNames();
		while(em.hasMoreElements()) {
			//key값 꺼내기
			String key = em.nextElement();//b_title, b_writer, b_content, b_pw 등
			pMap.put(key, HangulConversion.toUTF(mreq.getParameter(key)));
		}
		logger.info(pMap);
	}//////////end of bind
}
