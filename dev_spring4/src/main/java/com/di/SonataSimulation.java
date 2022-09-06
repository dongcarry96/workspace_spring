package com.di;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
// ApplicationContext vs BeanFactory -> 컨테이너의 종류
// 빈을 관리해준다
// 이른 인스턴스화, 게으른 인스턴스화로 나뉘어짐
// 빈의 정의는 xml문서에서 (클래스 이름을 선언)한다
import org.springframework.core.io.ClassPathResource;

/*
 * spring-core.jar -> XXX.class -> main() 있나?
 * spring-context.jar - ApplicationContext
 * spring-beans.jar - BeanFactory
 * 
 * 생성해야하는 클래스명 결정은 누가? - 개발자가
 * 어디에서 결정해야함?? - xml문서에서 설정할 수 있다
 * 
 * 
 */
//직접 인스턴스화 하는 것은 실습 목표에 맞지 않으므로 주석처리
public class SonataSimulation {
	// 게으른 인스턴스화 - 시점
//	Sonata myCar = null; // 언제 초기화가 되나?
	/** <220906 수업설명>
	 * 이른 인스턴스화 - 개발자가 라이프 사이클 관리하기 - 왜냐면 직접 new를 사용해서 인스턴스화를 했다.
	 * 스프링으로부터 빈(Bean)을 관리받지 않는 코드임
	 * 스프링으로 객체의 라이프사이클을 관리 받으려면 xml문서에 등록하거나 
	 * 최근에는 어노테이션을 지원하고 있습니다. - spring boot
	 * 어노테이션은 자바 코드에 작성하고 
	 * 그렇지 않은 경우이거나 이종간의 주입에 대해서는 xml로 처리할 수 있다.
	 * 이종간 언어에는 myBatis와 오라클
	 * 누가 연계에 필요한 자바코드를 지원해야 하는 걸까요?
	 * myBatis와 오라클 쪽에서 지원해야 한다
	 * 자신들의 속내용이나 코드가 노출되지 않도록..
	 * 
	 * myBatis는 프레임워크인가? 아님 라이브러리인가? 
	 * 라이브러리이다!!
	 * 
	 */
//	Sonata herCar = new Sonata();
	void methodA() {
//		System.out.println(herCar.speed);
//		myCar = new Sonata();
//		System.out.println(myCar.speed);
	}
	public static void main(String[] args) {
		SonataSimulation ss = new SonataSimulation();
//		ss.methodA();
		// 스프링에서는 xml문서에 선언된 클래스 정보를 얻어와서 자바코드에 쓸 수 있도록 제공하는 클래스가 있음
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com\\spring4\\mvc\\sonataBean.xml");
		// scope를 생략한 경우임
		//<bean id="myCar" class="com.spring4.mvc.Sonata" />
		Sonata myCar = (Sonata)context.getBean("myCar");
		Sonata myCar2 = (Sonata)context.getBean("myCar");
		Sonata herCar = (Sonata)context.getBean("herCar");// 인스턴스화 대신
		System.out.println(myCar == myCar2); // t:싱글톤 , f:prototype
		// scope를 prototype으로 한 경우임
		Sonata himCar = (Sonata)context.getBean("himCar");
		Sonata himCar2 = (Sonata)context.getBean("himCar");
		System.out.println(himCar ==himCar2); //f -> prototype이므로
		
		BeanFactory factory = 
				new XmlBeanFactory(new ClassPathResource("com\\spring4\\mvc\\sonataBean.xml"));
		Sonata meCar = (Sonata)factory.getBean("myCar");
		System.out.println(myCar == meCar); //f
		
		System.out.println("================================================================");
		// 어 그런데 생성자가 여러개 이자나??
		// 이런 경우 그 중에 누가 호출 되나요???
		System.out.println(herCar.speed); 	 //0
		System.out.println(herCar.carName);  // null
		System.out.println(herCar.carColor); // null
		
		System.out.println(myCar);
		System.out.println(myCar.speed);
		System.out.println(myCar.carName);
		System.out.println("객체관리 책임이 개발자에게 있는 경우");
		myCar = new Sonata();
		System.out.println(myCar);
		System.out.println(myCar.speed);
		System.out.println(myCar.carName);
		System.out.println(myCar.carName);
		// 객체 소멸
		myCar = null; // 현재 줄에서 다음 줄로 갈 때Candidate 상태에 빠진다.
		// 7번윗 번에 생성된 객체는 쓰레기값으로 인식되어 자원을 회수 당함 - 그 시점은 null할당과 재할당 사이이므로 지금 이부분!!
		myCar = new Sonata(); // 다시 인스턴스화 - 새로 주소번지 채번이 된다
		// (41번줄)myCar == (75번줄)myCar => false
		System.out.println("null 초기화 후 비교, "+myCar);
		System.out.println(myCar.speed);
		System.out.println(myCar.carName);
	}
}
