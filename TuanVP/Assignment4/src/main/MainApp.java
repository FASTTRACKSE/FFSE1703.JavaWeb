package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.*;

public class MainApp {
	public static List<MonHoc> monCongNghe;
	public static List<MonHoc> monTiengAnh;
	public static List<SinhVien> sinhVienLopHoc;

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		List<LopHoc> lopHoc = new ArrayList<>();
		List<HocKy> hocKy = new ArrayList<>();
		GiangVien giangVienThanh = new GiangVien("Thầy Thành", "thanhcl@fasttrack.edu.vn");
		GiangVien giangVienLam =  new GiangVien("Thầy Lâm", "lamnt@fasttrack.edu.vn");
		GiangVien giangVienThang = new GiangVien("Thầy Thắng", "thangtm@fasttrack.edu.vn"); 
		
		GiangVien giangVienHong = new GiangVien("Cô Hồng", "hongltm@fasttrack.edu.vn"); 
		GiangVien giangVienHa = new GiangVien("Cô Hà", "hattd@fasttrack.edu.vn");
		
		monCongNghe = new ArrayList<>();
		monTiengAnh = new ArrayList<>();
		
		monCongNghe.add(new MonCongNghe("HTML", giangVienThanh, giangVienLam, giangVienThang));
		monCongNghe.add(new MonCongNghe("CSS", giangVienLam, giangVienThang, giangVienThanh));
		monCongNghe.add(new MonCongNghe("PHP", giangVienThang, giangVienThanh, giangVienLam));

		monTiengAnh.add(new MonTiengAnh("Tiếng Anh cơ bản", "Level 1", giangVienHong, giangVienHa));
		monTiengAnh.add(new MonTiengAnh("E4IT1", "Level 1", giangVienHong, giangVienHa));

		hocKy.add(new HocKy1(monCongNghe, monTiengAnh));

		monCongNghe = new ArrayList<>();
		monTiengAnh = new ArrayList<>();
		
		
		monCongNghe.add(new MonCongNghe("JavaCore", giangVienThanh, giangVienLam, giangVienThang));
		monCongNghe.add(new MonCongNghe("JavaWeb", giangVienLam, giangVienThang, giangVienThanh));

		monTiengAnh.add(new MonTiengAnh("Tiếng Anh cơ bản", "Level 2", giangVienHong, giangVienHa));
		monTiengAnh.add(new MonTiengAnh("E4IT2", "Level 2", giangVienHong, giangVienHa));
		
		
		hocKy.add(new HocKy2(monCongNghe, monTiengAnh));
		
		monCongNghe = new ArrayList<>();
		monTiengAnh = new ArrayList<>();

		monCongNghe.add(new MonCongNghe("Android Application", giangVienThanh, giangVienLam, giangVienThang));
		monCongNghe.add(new MonCongNghe("IOT", giangVienLam, giangVienThang, giangVienThanh));

		hocKy.add(new HocKy3(monCongNghe));

		monCongNghe = new ArrayList<>();

		List<MonHoc> monThucTap = new ArrayList<>();
		monThucTap.add(new MonThucTap("F-COMPLEX", new GiangVien("Thầy Thành", "thanhcl@fasttrack.edu.vn")));
		monThucTap.add(new MonThucTap("GAMELOFT", new GiangVien("Thầy Nghiêm", "nghiemfe@fasttrack.edu.vn")));

		hocKy.add(new HocKy4(monThucTap));

		monCongNghe = new ArrayList<>();
		monCongNghe.add(new MonCongNghe("JavaCore", giangVienThanh, giangVienLam, giangVienThang));
		monCongNghe.add(new MonCongNghe("JavaWeb", giangVienLam, giangVienThang, giangVienThanh));

		HocKyJava hocKyJava = new HocKyJava(monCongNghe);

		monCongNghe = new ArrayList<>();
		monCongNghe.add(new MonCongNghe("HTML", giangVienThanh, giangVienLam, giangVienThang));
		monCongNghe.add(new MonCongNghe("CSS", giangVienLam, giangVienThang, giangVienThanh));
		monCongNghe.add(new MonCongNghe("PHP", giangVienThang, giangVienThanh, giangVienLam));

		HocKyWebFullStack hocKyWeb = new HocKyWebFullStack(monCongNghe);

		List<SinhVien> sinhVien = new ArrayList<>();
		for (char i = 'A'; i <= 'Z'; i++) {
			sinhVien.add(new SinhVien("Nguyễn Văn " + i, "nguyenvan_" + String.valueOf(i).toLowerCase() + "@fasttrack.edu.vn", "Tỉnh " + i, "0123456789"));
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

		System.out.println("\n ================================================== \n");
		for (LopHoc lH : lopHoc) {
			System.out.println(lH.thongTinLopHoc());
		}
		context.close();
	}
}
