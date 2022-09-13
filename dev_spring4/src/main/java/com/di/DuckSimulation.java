package com.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DuckSimulation {

	public static void main(String[] args) {
		ApplicationContext context
						= new ClassPathXmlApplicationContext("com\\di\\duckBean.xml");
		Duck myDuck = (Duck) context.getBean("myDuck");
		System.out.println(myDuck);
		System.out.println("myDuckleg : "+myDuck.leg);
		System.out.println("myDuckname : "+myDuck.name);
		myDuck.display();
		myDuck = (Duck) context.getBean("myDuck");
		System.out.println(myDuck);
		myDuck.display();
		myDuck = new MallardDuck();
		System.out.println(myDuck);
		Duck himDuck = (Duck) context.getBean("himDuck");
		System.out.println(himDuck);
		System.out.println("himDuckleg : "+himDuck.leg);
		System.out.println("himDuckname : "+himDuck.name);
		himDuck.display();
		himDuck = (Duck) context.getBean("himDuck");
		System.out.println(himDuck);
	}

}
