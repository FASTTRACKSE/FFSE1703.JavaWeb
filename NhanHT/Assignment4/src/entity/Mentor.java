package entity;

import org.springframework.stereotype.Component;

@Component
public class Mentor implements GiangVien{
	private String hoTen,email;
	public Mentor() {
		// TODO Auto-generated constructor stub
	}

	public Mentor(String hoTen, String email) {
		super();
		this.hoTen = hoTen;
		this.email = email;
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

	@Override
	public String giangVien() {
		// TODO Auto-generated method stub
		return "\n"+"\t"+" * Mentor: "+" "+hoTen+" " + email;
	}

}
