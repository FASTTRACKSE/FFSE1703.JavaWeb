package FFSE;

public class CongNghe implements MonHoc{
	public String tenMonHoc;
	public GiangVienChinh giangVienChinh;
	public TroGiang troGiang;
	public Mentor mentor;

	public CongNghe() {
		super();
	}

	public CongNghe(String tenMonHoc, GiangVienChinh giangVienChinh, TroGiang troGiang, Mentor mentor) {
		super();
		this.tenMonHoc = tenMonHoc;
		this.giangVienChinh = giangVienChinh;
		this.troGiang = troGiang;
		this.mentor = mentor;
	}

	@Override
	public String getMonHoc() {
		String st = "  - Tên môn học: " + tenMonHoc + "\n";
		st += "   + " + giangVienChinh.thongTinGiangVien();
		st += "   + " + troGiang.thongTinGiangVien();
		st += "   + " + mentor.thongTinGiangVien();
		return st;
	}

}
