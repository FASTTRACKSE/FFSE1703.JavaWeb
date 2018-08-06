package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.*;

public class MainApp {
	public static List<MonCongNghe> monCongNghe;
	public static List<MonTiengAnh> monTiengAnh;
	public static List<SinhVien> sinhVienLopHoc;

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		List<LopHoc> lopHoc = new ArrayList<>();
		List<HocKy> hocKy = new ArrayList<>();
		GiangVien giangVienChinhCN = new GiangVien("Thầy Thành", "thanhcl@fasttrack.edu.vn");
		GiangVien troGiangCN =  new GiangVien("Thầy Lâm", "lamnt@fasttrack.edu.vn");
		GiangVien mentor = new GiangVien("Thầy Thắng", "thangtm@fasttrack.edu.vn"); 
		
		GiangVien giangVienChinhTA = new GiangVien("Cô Hồng", "hongltm@fasttrack.edu.vn"); 
		GiangVien troGiangTA = new GiangVien("Cô Hà", "hattd@fasttrack.edu.vn");
		
		monCongNghe = new ArrayList<>();
		monTiengAnh = new ArrayList<>();
		
		monCongNghe.add(new MonCongNghe("HTML", giangVienChinhCN, troGiangCN, mentor));
		monCongNghe.add(new MonCongNghe("CSS", giangVienChinhCN, troGiangCN, mentor));
		monCongNghe.add(new MonCongNghe("PHP", giangVienChinhCN, troGiangCN, mentor));

		monTiengAnh.add(new MonTiengAnh("Tiếng Anh cơ bản", "Level 1", giangVienChinhTA, troGiangTA));
		monTiengAnh.add(new MonTiengAnh("E4IT1", "Level 1", giangVienChinhTA, troGiangTA));

		hocKy.add(new HocKy1(monCongNghe, monTiengAnh));

		monCongNghe = new ArrayList<>();
		monTiengAnh = new ArrayList<>();
		
		
		monCongNghe.add(new MonCongNghe("JavaCore", giangVienChinhCN, troGiangCN, mentor));
		monCongNghe.add(new MonCongNghe("JavaWeb", giangVienChinhCN, troGiangCN, mentor));

		monTiengAnh.add(new MonTiengAnh("Tiếng Anh cơ bản", "Level 2", giangVienChinhTA, troGiangTA));
		monTiengAnh.add(new MonTiengAnh("E4IT2", "Level 2", giangVienChinhTA, troGiangTA));
		
		
		hocKy.add(new HocKy2(monCongNghe, monTiengAnh));
		
		monCongNghe = new ArrayList<>();
		monTiengAnh = new ArrayList<>();

		monCongNghe.add(new MonCongNghe("JavaCore", giangVienChinhCN, troGiangCN, mentor));
		monCongNghe.add(new MonCongNghe("JavaWeb", giangVienChinhCN, troGiangCN, mentor));

		hocKy.add(new HocKy3(monCongNghe));

		monCongNghe = new ArrayList<>();

		List<MonThucTap> monThucTap = new ArrayList<>();
		monThucTap.add(new MonThucTap("F-COMPLEX", new GiangVien("Thầy Thành", "thanhcl@gmail.com")));
		monThucTap.add(new MonThucTap("GAMELOFT", new GiangVien("Thầy Nghiêm", "nghiemfe@gmail.com")));

		hocKy.add(new HocKy4(monThucTap));

		monCongNghe = new ArrayList<>();
		monCongNghe.add(new MonCongNghe("JavaCore", giangVienChinhCN, troGiangCN, mentor));
		monCongNghe.add(new MonCongNghe("JavaWeb", giangVienChinhCN, troGiangCN, mentor));

		HocKyJava hocKyJava = new HocKyJava(monCongNghe);

		monCongNghe = new ArrayList<>();
		monCongNghe.add(new MonCongNghe("HTML", giangVienChinhCN, troGiangCN, mentor));
		monCongNghe.add(new MonCongNghe("CSS", giangVienChinhCN, troGiangCN, mentor));
		monCongNghe.add(new MonCongNghe("PHP", giangVienChinhCN, troGiangCN, mentor));

		HocKyWebFullStack hocKyWeb = new HocKyWebFullStack(monCongNghe);

		List<SinhVien> sinhVien = new ArrayList<>();
		for (char i = 'A'; i <= 'Z'; i++) {
			sinhVien.add(new SinhVien("Nguyễn Văn " + i, "nguyenvan" + String.valueOf(i).toLowerCase() + "@gmail.com", "Tỉnh " + i, "0123456789"));
		}

		sinhVienLopHoc = new ArrayList<>();
		sinhVienLopHoc = sinhVien.subList(0, 4);

		lopHoc.add(new LopHoc("1703", new DaoTaoDaiHanFTSE(hocKy), sinhVienLopHoc));

		sinhVienLopHoc = new ArrayList<>();
		sinhVienLopHoc = sinhVien.subList(5, 9);
		
		lopHoc.add(new LopHoc("1704", new DaoTaoDaiHanFTSE(hocKy), sinhVienLopHoc));
		
		sinhVienLopHoc = new ArrayList<>();
		sinhVienLopHoc = sinhVien.subList(10, 14);
		
		lopHoc.add(new LopHoc("1801", new DaoTaoNganHanFTSE(hocKyJava), sinhVienLopHoc));
		
		sinhVienLopHoc = new ArrayList<>();
		sinhVienLopHoc = sinhVien.subList(15, 19);
		
		lopHoc.add(new LopHoc("1802", new DaoTaoNganHanFTSE(hocKyWeb), sinhVienLopHoc));

		for (LopHoc lH : lopHoc) {
			System.out.println(lH.thongTinLopHoc());
		}

	}
}
