package vn.model;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private String hoTen;

	public Student() {
		super();
	}

	public Student(String hoTen) {
		// TODO Auto-generated constructor stub
		this.hoTen = hoTen;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
}
