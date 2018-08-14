package Test.Hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	ApplicationContext context = new ClassPathXmlApplicationContext("BeanHello.xml");
    	HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
    	obj.getMessage();
    }
}
