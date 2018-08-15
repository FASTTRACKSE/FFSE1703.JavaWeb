package fasttrackse.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fasttrackse.entity.*;

public class MainApp {
		public static List<MonHoc> monCongNghe;
		public static List<MonHoc> monTiengAnh;
		public static List<SinhVien> sinhVienLopHoc;
		
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		
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
		monCongNghe.add(new MonCongNghe("Web Front-End", giangVienThanh, giangVienLam, giangVienThang));
		monCongNghe.add(new MonCongNghe("Web FullStack", giangVienLam, giangVienThang, giangVienThanh));

		HocKyFullStack hocKyWeb = new HocKyFullStack(monCongNghe);
		
		sinhVienLopHoc =new ArrayList<>();
		sinhVienLopHoc.add(new SinhVien("Hồ Quang Minh","FFSE1702063@st.fasttrack.edu","01693600547"));
		sinhVienLopHoc.add(new SinhVien("Hồ Viết Tú","FFSE1702045@st.fasttrack.edu","01692313241"));
		sinhVienLopHoc.add(new SinhVien("Lê Thanh Danh","FFSE1702003@st.fasttrack.edu","01699798686"));
		sinhVienLopHoc.add(new SinhVien("Lê Phước Hiếu","FFSE1702032@st.fasttrack.edu","01693001357"));

		LopHoc lopHoc1 = new LopHoc("1703", new DaoTaoDaiHan(hocKy), sinhVienLopHoc);
		LopHoc lopHoc2 = new LopHoc("1802", new DaoTaoNganHan(hocKyJava), sinhVienLopHoc);
		LopHoc lopHoc3 = new LopHoc("1801", new DaoTaoNganHan(hocKyWeb), sinhVienLopHoc);
		System.out.println( lopHoc1.thongTinLopHoc());
		System.out.println( lopHoc2.thongTinLopHoc());
		System.out.println( lopHoc3.thongTinLopHoc());
		context.close();
	}
}
