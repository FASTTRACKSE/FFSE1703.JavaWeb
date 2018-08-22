package entity;

public class MonTiengAnh implements MonHoc {
	
	private String tenMon;
	private GiangVien giangVienChinh;
	private GiangVien troGiang;
	
	public MonTiengAnh() {
		//
	}
	
	public MonTiengAnh(String tenMon, GiangVien giangVienChinh, GiangVien troGiang) {
		this.tenMon = tenMon;
		this.giangVienChinh = giangVienChinh;
		this.troGiang = troGiang;
	}

	@Override
	public String monHoc() {
		// TODO Auto-generated method stub
		return "+" + tenMon + "\n \t " 
		+ "Giảng viên chính: " + giangVienChinh.giangVien() 
		+ "\n \t " + "Mentor: " + troGiang.giangVien();
	}

}
