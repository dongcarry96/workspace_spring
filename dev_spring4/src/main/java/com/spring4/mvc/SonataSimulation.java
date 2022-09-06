package com.spring4.mvc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
/*
 * spring-core.jar -> xxx.class -> main()있나?
 * 스프링 컨테이너 종류 2가지
 * spring-context.jar - ApplicationContext
 * spring-beens.jar - BeanFactory
 * 생성해야 하는 클래스명 결정은 누가?
 */

// ApplicationContext 대 BeanFactory -> 컨테이너의 종류
// 빈을 관리해준다
// 이른 인스턴스화, 게으른 인스턴스화
// 빈의 정의는 xml문서에서 한다(클래스 이름을 선언한다)
public class SonataSimulation {
	// 게으른 인스턴스화 - 시점
//	Sonata myCar= null; //언제 초기화되나?
	// 이른 인스턴스화
//	Sonata herCar = new Sonata();
	void methodA() {
//		System.out.print(herCar.speed);
//		myCar = new Sonata();
//		System.out.print(myCar.speed);
	}
	public static void main(String[] args) {
		SonataSimulation ss = new SonataSimulation();
//		ss.methodA();
		// 스프링에서는 xml문서에 선언된 클래스 정보를 얻어와서 자바코드에 쓸 수 있도록
		// 제공하는 클래스가 있음
		ApplicationContext context
		= new ClassPathXmlApplicationContext("com\\spring4\\mvc\\sonataBean.xml");
		// 어 그런데 생성자가 여러개 이자나???
		// 이런 경우 그 중에 누가 호출되나요?
		
		//개발자가 라이프 사이클 관리하기 - 왜냐하면 직접 new를 사용해서 인스턴스화를 함
		// 스프링으로 부터 빈(been:클래스임)을 관리받지 않는 코드임
		// 스프링으로 객체의 라이프사이클을 관리 받으려면 xml문서에 등록하거나
		// 최근에는 어노테이션을 지원하고 있습니다. - spring boot
		// 어노테이션은 자바 코드에 작성하고
		// 그렇지 않은 경우이거나 이종간의 주입에 대해서는 xml로 처리할 수 있다.
		// 이종간 언어에는 myBatis와 오라클
		// 누가 연계에 필요한 자바 코드를 지원해야 하는 걸까요?
		// myBatis와 오라클 쪽에서 지원해야 하나?
		// 자신들의 속내용이나 코드가 노출되지 않도록...
		// myBatis는 프레임워크 인가? 아님 라이브러리인가?
		Sonata yourCar = new Sonata();// 여기의 주소번지와
		yourCar = null; //candidate상태로 전환되는 코드임. null로 초기화 한 후
		yourCar = new Sonata();//다시 인스턴스화 - 새로 주소번지 채번이 된다.
		// yourCar == yourCar => false
		
		//scope를 생략한 경우임
		Sonata myCar = (Sonata)context.getBean("myCar");
		Sonata myCar2 = (Sonata)context.getBean("myCar2");
		System.out.println(myCar == myCar2); // t:싱글톤
		
		// scope를 prototyp으로 한 경우임
		Sonata herCar = (Sonata)context.getBean("herCar");//인스턴스화
		Sonata herCar2 = (Sonata)context.getBean("herCar");//인스턴스화
		System.out.println(herCar.speed);//0
		System.out.println(herCar.carName);//null
		System.out.println(herCar.carColor);//null
		System.out.println(herCar == herCar2);//f:prototype
		
		System.out.println(myCar);
		System.out.println(myCar.speed);
		System.out.println(myCar.carName);
		System.out.println("객체관리 책임이 개발자에게 있는경우.");
		myCar = new Sonata();
		System.out.println(myCar);
		System.out.println(myCar.speed);
		System.out.println(myCar.carName);
		myCar = null; //30번에서 31번으로 갈때 Candidate상태에 빠진다.
		// 26번에 생성된 객체는 쓰레기 값으로 인식되어 자원을 회수 당함
		myCar = new Sonata();
		System.out.println("null초기화 후에 비교"+myCar);
		System.out.println(myCar.speed);
		System.out.println(myCar.carName);
		
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("com\\di\\sonataBean.xml"));
		Sonata meCar = (Sonata)factory.getBean("myCar");
		System.out.println(myCar == meCar);//f
	}
}
