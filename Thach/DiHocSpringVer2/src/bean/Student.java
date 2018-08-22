package bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")

public class Student {
	public String hoTen;

	public Student() {
		//
	}
	
	public Student(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	
	public void diHoc() {
		System.out.println("Bạn " + hoTen);
	}
}
