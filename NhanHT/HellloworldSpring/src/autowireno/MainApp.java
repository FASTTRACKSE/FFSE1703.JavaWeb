package autowireno;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		AbstractApplicationContext context;
        
        //autowire="no"
        context = new ClassPathXmlApplicationContext("student-bean.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);  
	}

}
