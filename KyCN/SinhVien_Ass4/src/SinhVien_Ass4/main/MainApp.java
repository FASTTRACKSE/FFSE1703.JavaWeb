package SinhVien_Ass4.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import SinhVienAss4.entity.*;



public class MainApp {
	public static List<MonHoc> monCongNghe;
	public static List<MonHoc> monTiengAnh;
	public static List<SinhVienAss4> sinhVien;
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		List<LopHoc> lopHoc = new ArrayList<>();
		List<HocKy> hocKy = new ArrayList<>();
		
		//Giảng Viên Công Nghệ
		GiangVien giangVienThanh = new GiangVien("Thầy Thành", "thanhcl@fasttrack.edu.vn");
		GiangVien giangVienLam =  new GiangVien("Thầy Lâm", "lamnt@fasttrack.edu.vn");
		GiangVien giangVienThang = new GiangVien("Thầy Thắng", "thangtm@fasttrack.edu.vn"); 
		
		//Giảng Viên Tiếng Anh
		GiangVien giangVienHong = new GiangVien("Cô Hồng", "hongltm@fasttrack.edu.vn"); 
		GiangVien giangVienHa = new GiangVien("Cô Hà", "hattd@fasttrack.edu.vn");

		//Khởi Tạo Môn Học Học Kỳ 1
		monCongNghe = new ArrayList<>();
		monTiengAnh = new ArrayList<>();
		
		monCongNghe.add(new MonCongNghe("HTML", giangVienThanh, giangVienLam));
		monCongNghe.add(new MonCongNghe("CSS", giangVienLam, giangVienThang));
		monCongNghe.add(new MonCongNghe("PHP", giangVienThang, giangVienThanh));
		
		monTiengAnh.add(new MonTiengAnh("Tiếng Anh cơ bản", "Level 1", giangVienHong, giangVienHa));
		monTiengAnh.add(new MonTiengAnh("E4IT1", "Level 1", giangVienHong, giangVienHa));
		
		hocKy.add(new HocKy1(monCongNghe, monTiengAnh));
		
		//Khởi Tạo Môn Học Học Kỳ 2
		monCongNghe = new ArrayList<>();
		monTiengAnh = new ArrayList<>();
		
		monCongNghe.add(new MonCongNghe("JavaCore", giangVienThanh, giangVienLam));
		monCongNghe.add(new MonCongNghe("JavaWeb", giangVienLam, giangVienThang));

		monTiengAnh.add(new MonTiengAnh("Tiếng Anh cơ bản", "Level 2", giangVienHong, giangVienHa));
		monTiengAnh.add(new MonTiengAnh("E4IT2", "Level 2", giangVienHong, giangVienHa));
		
		//Khởi Tạo Môn Học Học Kỳ 3
		monCongNghe = new ArrayList<>();
		monTiengAnh = new ArrayList<>();

		monCongNghe.add(new MonCongNghe("Android Application", giangVienThanh, giangVienLam));
		monCongNghe.add(new MonCongNghe("IOT", giangVienLam, giangVienThang));

		hocKy.add(new HocKy3(monCongNghe));
		
		
		List<SinhVienAss4> sinhVien = new ArrayList<>();
		for (char i = 'A'; i <= 'Z'; i++) {
			sinhVien.add(new SinhVienAss4("Nguyễn Văn " + i, "nguyenvan_" + String.valueOf(i).toLowerCase() + "@fasttrack.edu.vn"));
		}

		sinhVien = new ArrayList<>();
		sinhVien = sinhVien.subList(0, 4);

		lopHoc.add(new LopHoc("1703", new HeDaoTaoDaiHan(hocKy), sinhVien));
	
		

		for (LopHoc lh : lopHoc) {
			System.out.println(lh.getLop());
		}
		
		
		
		
		context.close();
	}
}
