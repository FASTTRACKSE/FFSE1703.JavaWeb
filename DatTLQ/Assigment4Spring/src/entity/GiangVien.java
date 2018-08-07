package entity;

public class GiangVien {
	private String tenGV;
	private String email;
	
	public GiangVien(String tenGV, String email) {
		super();
		this.tenGV = tenGV;
		this.email = email;
	}
	public GiangVien() {
		
	}
	public String getGiangVien() {
		return "-" + tenGV + " - " + email;
	}
}
