package FFSE1702.autowrite;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		 AbstractApplicationContext context;
         
	        //autowire="no"
	        context = new ClassPathXmlApplicationContext("SinhVienBean.xml");
	        Student student = (Student) context.getBean("student");
	        System.out.println(student);  
	}

}
