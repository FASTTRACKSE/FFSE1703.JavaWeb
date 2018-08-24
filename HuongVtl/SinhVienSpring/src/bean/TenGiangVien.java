package bean;

public class TenGiangVien implements GiangVien{
	private String tenGiangVien;
	public TenGiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
	}
	@Override
	public String giangVien() {
		// TODO Auto-generated method stub
		return tenGiangVien;
	}

}
