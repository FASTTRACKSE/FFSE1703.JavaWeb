package bean;

public class MonCNNho implements MonHoc{
	private String tenMon;
	private GiangVien giangVien;
	public MonCNNho(String tenMon, GiangVien giangVien) {
		this.tenMon = tenMon;
		this.giangVien = giangVien;
	}
	@Override
	public String monHoc() {
		// TODO Auto-generated method stub
		return tenMon+" - " + giangVien.tenGiangVien();
	}

}
