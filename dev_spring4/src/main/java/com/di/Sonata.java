package com.di;

import org.apache.log4j.Logger;

public class Sonata {
	Logger logger = Logger.getLogger(Sonata.class);
	int speed = 10;
	String carName = "2023년형 소나타";
	String carColor = "흰색";
	public Sonata() {
		logger.info("Sonata 디폴트 생성자 호출");
	}
	public Sonata(int speed) {
		this.speed = speed;
	}
	public Sonata(int speed, String carName) { // 속도, 자동차 색상
		this.speed = speed;
		this.carName = carName;
	}
	public Sonata(int speed, String carName, String carColor) {
		this.speed = speed;
		this.carName = carName;
		this.carColor = carColor;
	}
}
