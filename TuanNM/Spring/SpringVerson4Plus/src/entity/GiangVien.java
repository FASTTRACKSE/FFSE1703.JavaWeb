package entity;

import org.springframework.stereotype.Component;

@Component
public class GiangVien {
	private String hoTen;
	private String email;
	
	public GiangVien() {
		
	}
	public GiangVien(String hoTen, String email) {
		super();
		this.hoTen = hoTen;
		this.email = email;
	}
	public String getGiangVien(){
		return " - "+ hoTen +" - "+ email;	
	}
	
}
