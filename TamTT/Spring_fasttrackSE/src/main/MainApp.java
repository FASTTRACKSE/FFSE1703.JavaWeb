package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import FFSE.CongNghe;
import FFSE.GiangVienChinh;
import FFSE.HeDaoTaoDaiHan;
import FFSE.HeDaoTaoNganHan;
import FFSE.HocKi;
import FFSE.HocKi_1;
import FFSE.HocKi_2;
import FFSE.HocKi_3;
import FFSE.HocKi_4;
import FFSE.HocKi_JAVA;
import FFSE.HocKi_Web_Full_Stack;
import FFSE.LopHoc;
import FFSE.Mentor;
import FFSE.SinhVien;
import FFSE.ThucTap;
import FFSE.TiengAnh;
import FFSE.TroGiang;

public class MainApp {
	public static List<CongNghe> CongNghe;
	public static List<TiengAnh> TiengAnh;
	public static List<SinhVien> sinhVienLopHoc;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		List<LopHoc> lopHoc = new ArrayList<>();
		List<HocKi> hocKi = new ArrayList<>();
		GiangVienChinh giangVienChinhCN = new GiangVienChinh("Thầy Thành", "thanhcl@fasttrack.edu.vn");
		TroGiang troGiangCN =  new TroGiang("Thầy Lâm", "lamnt@fasttrack.edu.vn");
		Mentor mentor = new Mentor("Thầy Thắng", "thangtm@fasttrack.edu.vn"); 
		
		GiangVienChinh giangVienChinhTA = new GiangVienChinh("Cô Hồng", "hongltm@fasttrack.edu.vn"); 
		TroGiang troGiangTA = new TroGiang("Cô Hà", "hattd@fasttrack.edu.vn");
		
		CongNghe = new ArrayList<>();
		TiengAnh = new ArrayList<>();
		
		CongNghe.add(new CongNghe("HTML", giangVienChinhCN, troGiangCN, mentor));
		CongNghe.add(new CongNghe("CSS", giangVienChinhCN, troGiangCN, mentor));
		CongNghe.add(new CongNghe("PHP", giangVienChinhCN, troGiangCN, mentor));

		TiengAnh.add(new TiengAnh("Tiếng Anh cơ bản", "Level 1", giangVienChinhTA, troGiangTA));
		TiengAnh.add(new TiengAnh("E4IT1", "Level 1", giangVienChinhTA, troGiangTA));

		hocKi.add(new HocKi_1(CongNghe, TiengAnh));

		CongNghe = new ArrayList<>();
		TiengAnh = new ArrayList<>();
		
		
		CongNghe.add(new CongNghe("JavaCore", giangVienChinhCN, troGiangCN, mentor));
		CongNghe.add(new CongNghe("JavaWeb", giangVienChinhCN, troGiangCN, mentor));

		TiengAnh.add(new TiengAnh("Tiếng Anh cơ bản", "Level 2", giangVienChinhTA, troGiangTA));
		TiengAnh.add(new TiengAnh("E4IT2", "Level 2", giangVienChinhTA, troGiangTA));
		
		
		hocKi.add(new HocKi_2(CongNghe, TiengAnh));
		
		CongNghe = new ArrayList<>();
		TiengAnh = new ArrayList<>();

		CongNghe.add(new CongNghe("JavaCore", giangVienChinhCN, troGiangCN, mentor));
		CongNghe.add(new CongNghe("JavaWeb", giangVienChinhCN, troGiangCN, mentor));

		hocKi.add(new HocKi_3(CongNghe));

		CongNghe = new ArrayList<>();

		List<ThucTap> ThucTap = new ArrayList<>();
		ThucTap.add(new ThucTap("F-COMPLEX", new GiangVienChinh("Thầy Thành", "thanhcl@gmail.com")));
		ThucTap.add(new ThucTap("GAMELOFT", new GiangVienChinh("Thầy Thành", "thanhcl@gmail.com")));

		hocKi.add(new HocKi_4(ThucTap));

		CongNghe = new ArrayList<>();
		CongNghe.add(new CongNghe("JavaCore", giangVienChinhCN, troGiangCN, mentor));
		CongNghe.add(new CongNghe("JavaWeb", giangVienChinhCN, troGiangCN, mentor));

		HocKi_JAVA hocKiJava = new HocKi_JAVA(CongNghe);

		CongNghe = new ArrayList<>();
		CongNghe.add(new CongNghe("HTML", giangVienChinhCN, troGiangCN, mentor));
		CongNghe.add(new CongNghe("CSS", giangVienChinhCN, troGiangCN, mentor));
		CongNghe.add(new CongNghe("PHP", giangVienChinhCN, troGiangCN, mentor));

		HocKi_Web_Full_Stack hocKiWeb = new HocKi_Web_Full_Stack(CongNghe);

		List<SinhVien> sinhVien = new ArrayList<>();
		for (char i = 'A'; i <= 'Z'; i++) {
			sinhVien.add(new SinhVien("Nguyễn Văn " + i, "nguyenvan" + String.valueOf(i).toLowerCase() + "@gmail.com", "Tỉnh " + i, "0123456789"));
		}

		sinhVienLopHoc = new ArrayList<>();
		sinhVienLopHoc = sinhVien.subList(0, 4);

		lopHoc.add(new LopHoc("1703", new HeDaoTaoDaiHan(hocKi), sinhVienLopHoc));

		sinhVienLopHoc = new ArrayList<>();
		sinhVienLopHoc = sinhVien.subList(5, 9);
		
		lopHoc.add(new LopHoc("1704", new HeDaoTaoDaiHan(hocKi), sinhVienLopHoc));
		
		sinhVienLopHoc = new ArrayList<>();
		sinhVienLopHoc = sinhVien.subList(10, 14);
		
		lopHoc.add(new LopHoc("1801", new HeDaoTaoNganHan(hocKiJava), sinhVienLopHoc));
		
		sinhVienLopHoc = new ArrayList<>();
		sinhVienLopHoc = sinhVien.subList(15, 19);
		
		lopHoc.add(new LopHoc("1802", new HeDaoTaoNganHan(hocKiWeb), sinhVienLopHoc));

		for (LopHoc lH : lopHoc) {
			System.out.println(lH.thongTinLopHoc());
		}

	}
}
