package asm.entity;

public class MonThucTap implements MonHoc{
	public String noithucTap;
	public GiangVien gvPhuTrach;
	public MonThucTap() {
		
	}
	public MonThucTap(String noithucTap,GiangVien gvPhuTrach) {
		super();
		this.noithucTap=noithucTap;
		this.gvPhuTrach=gvPhuTrach;
	}
	@Override
	public String tenMonHoc() {
		String thucTap=" - Nơi Thực Tập: "+noithucTap;
		thucTap += " + Giảng Viên Phụ Trách: "+gvPhuTrach.thongtinGiangVien()+"\n";
		return thucTap;
	}
}
