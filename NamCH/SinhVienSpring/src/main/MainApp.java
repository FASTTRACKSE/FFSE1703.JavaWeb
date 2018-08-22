package main;

import java.util.ArrayList;
import java.util.List;

import entity.GiangVien;
import entity.GiangVienFE;
import entity.HeDaoTaoFE;
import entity.HocKy;
import entity.HocKyFE;
import entity.LopHoc;
import entity.MonHoc;
import entity.MonHocFE;
import entity.SinhVien;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LopHoc lop1703 = new LopHoc();
		lop1703.setHeDaoTao(new HeDaoTaoFE("Hệ Đào Tạo Dài Hạn"));
		
		List<GiangVien> arrGVJava = new ArrayList<GiangVien>();
		arrGVJava.add(new GiangVienFE("Thầy Thành"));
		arrGVJava.add(new GiangVienFE("Mentor Lâm"));
		
		List<GiangVien> arrGVPhp = new ArrayList<GiangVien>();
		arrGVPhp.add(new GiangVienFE("Thầy Thắng"));
		arrGVPhp.add(new GiangVienFE("Mentor Hương"));
		
		List<MonHoc> arrMon = new ArrayList<MonHoc>();
		arrMon.add(new MonHocFE("Môn Java", arrGVJava));
		arrMon.add(new MonHocFE("Môn Php", arrGVPhp));
		
		List<SinhVien> arrSV = new ArrayList<SinhVien>();
		arrSV.add(new SinhVien("Nam"));
		arrSV.add(new SinhVien("Quý"));
		arrSV.add(new SinhVien("Nhân"));
		
		lop1703.setSinhVien(arrSV);
		lop1703.setHocKy(new HocKyFE("Học Kỳ 1", arrMon));
		
		lop1703.inThong();
		
	}

}
