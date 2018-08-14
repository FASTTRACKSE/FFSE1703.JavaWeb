package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext
				("bean/Xinchaobean.xml");
		Xinchao obj = (Xinchao) appContext.getBean("123");
		obj.getMessage();
	}
}
