package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class GiangVien {
	private String hoTen;
	private String email;
	
	public GiangVien(String hoTen, String email) {
		
	}
	
	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGiangVien(){
		return " - "+ hoTen +" - "+ email;	
	}
	
}