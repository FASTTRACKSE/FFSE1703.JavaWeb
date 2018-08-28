package entity;

import java.util.List;

public class MonHocFE implements MonHoc{
	private String tenMH;
	private List<GiangVien> giangVien;
	public MonHocFE(String monHoc,List<GiangVien> giangVien) {
		this.tenMH=monHoc;
		this.giangVien=giangVien;
	}
	@Override
	public String getTenMonHoc() {
		// TODO Auto-generated method stub
		String a ="";
		for (GiangVien x : giangVien) {
			a = a+ x.getTenGiangVien()+" ";
		}
		return tenMH + " "+a +"\n\t\t ";
	}	
}
