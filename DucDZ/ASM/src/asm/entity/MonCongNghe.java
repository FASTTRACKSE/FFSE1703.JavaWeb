package asm.entity;

public class MonCongNghe implements MonHoc{
	public String tenMonHoc;
	public GiangVien giangVienChinh;
	public GiangVien troGiang;
	public GiangVien mentor;
	public MonCongNghe() {
		
	}
	public MonCongNghe(String tenMonHoc,GiangVien giangVienChinh,
			GiangVien troGiang,GiangVien mentor) {
		this.tenMonHoc=tenMonHoc;
		this.giangVienChinh=giangVienChinh;
		this.troGiang=troGiang;
		this.mentor=mentor;
	}
	@Override
	public String tenMonHoc() {
		String monCN = "Tên Môn Học: "+tenMonHoc+"\n";
		monCN +=" + Giảng Viên Chính: "+giangVienChinh.thongtinGiangVien()+"\n";
		monCN +=" + Trợ Giảng: "+troGiang.thongtinGiangVien()+"\n";
		monCN +=" + Mentor: "+mentor.thongtinGiangVien()+"\n";
		return monCN;
	}
}
