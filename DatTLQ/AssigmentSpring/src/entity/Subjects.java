package entity;

import org.springframework.stereotype.Component;

@Component
public class Subjects implements MonHoc {
	private String  monHoc;
	public Subjects() {
		
	}
	
	public Subjects(String monHoc) {
		this.monHoc = monHoc;
	}

	public String diHoc() {
		
		return "Mang sách "+ monHoc + "đi học";
	}

}
