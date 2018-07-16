package stackjava.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import stackjava.service.HelloService;

@ManagedBean
@SessionScoped
public class HelloBean {
	@ManagedProperty(value = "#{helloService}")
	HelloService helloService;
	private String name;
	private String age;
	private String email;
	private String address;
	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String sayHello() {
		this.name = helloService.convert(this.name);
		this.age = helloService.convert(this.age);
		this.email = helloService.convert(this.email);
		this.address = helloService.convert(this.address);
		return "hello";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HelloService getHelloService() {
		return helloService;
	}

	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}
}
