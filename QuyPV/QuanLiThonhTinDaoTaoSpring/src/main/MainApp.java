package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.GiangVien;

import entity.HeDaiHan;
import entity.HeNganHan;
import entity.HocKi;
import entity.HocKi1;
import entity.HocKi2;
import entity.HocKi3;
import entity.HocKi4;
import entity.HocKiJava;
import entity.HocKiWebFullStack;
import entity.LopHoc;
import entity.GiangVien;
import entity.MonCongNghe;
import entity.MonHoc;
import entity.MonThucTap;
import entity.MonTiengAnh;
import entity.SinhVien;
import entity.GiangVien;

public class MainApp {
	static List<MonHoc> monCongNgheList;
	static List<HocKi> hocKiList;
	static List<MonHoc> monThucTapList;
	static List<SinhVien> sinhVienList;
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		LopHoc lopHoc1703 = (LopHoc) context.getBean("lopHoc");
		// khởi tạo danh sách học kì
		hocKiList = new ArrayList<>();
		
		// khởi tạo danh sách môn công nghệ
		monCongNgheList = new ArrayList<>();
		monCongNgheList
				.add(new MonCongNghe("Scratch", new GiangVien("Nguyễn Duy Nghiêm", "nghiem@fasttrack.edu.vn"),
						new GiangVien("Nguyễn Đức Nghĩa", "nghia@fasttrack.edu.vn")));
		monCongNgheList
				.add(new MonCongNghe("HTML/CSS", new GiangVien("Nguyễn Duy Nghiêm", "nghiem@fasttrack.edu.vn"),
						new GiangVien("Nguyễn Đức Nghĩa", "nghia@fasttrack.edu.vn")));
		// inject môn học cho Học kì 1
		hocKiList.add(new HocKi1(monCongNgheList,
				new MonTiengAnh("Tiếng anh cơ sở-lv1", new GiangVien("Lê Thị Mỹ Hồng", "hong@fasttrack.edu.vn"),
						new GiangVien("Hồ Ngọc Hà", "ha@fasttrack.edu.vn"))));
		
		// khởi tạo danh sách môn công nghệ
		monCongNgheList = new ArrayList<>();
		monCongNgheList
				.add(new MonCongNghe("Scratch", new GiangVien("Cao Lê Thành", "thanh@fasttrack.edu.vn"),
						new GiangVien("Nguyễn Thanh Lâm", "lam@fasttrack.edu.vn")));
		monCongNgheList
				.add(new MonCongNghe("HTML/CSS", new GiangVien("Cao Lê Thành", "thanh@fasttrack.edu.vn"),
						new GiangVien("Nguyễn Thanh Lâm", "lam@fasttrack.edu.vn")));
		// inject môn học cho Học kì 2
		hocKiList.add(new HocKi2(monCongNgheList,
				new MonTiengAnh("Tiếng anh cơ sở-lv1", new GiangVien("Lê Thị Mỹ Hồng", "hong@fasttrack.edu.vn"),
						new GiangVien("Hồ Ngọc Hà", "ha@fasttrack.edu.vn"))));
		
		// khởi tạo danh sách môn công nghệ
		monCongNgheList = new ArrayList<>();
		monCongNgheList
		.add(new MonCongNghe("Java Core", new GiangVien("Cao Lê Thành", "thanh@fasttrack.edu.vn"),
				new GiangVien("Lê Văn Thắng", "thang@fasttrack.edu.vn")));
		monCongNgheList
				.add(new MonCongNghe("Java Web", new GiangVien("Cao Lê Thành", "thanh@fasttrack.edu.vn"),
						new GiangVien("Lê Văn Thắng", "thang@fasttrack.edu.vn")));
		// inject môn học cho Học kì 3
		hocKiList.add(new HocKi3(monCongNgheList));
		
		// khởi tạo danh sách môn Thực tập
		monThucTapList = new ArrayList<>();
		monThucTapList.add(new MonThucTap("FPT Software",new GiangVien("Nguyễn Văn A", "a@gmail.com")) );
		// inject môn học cho Học kì 4
		hocKiList.add(new HocKi4(monThucTapList));
		// khởi tạo danh sách sinh viên
		sinhVienList = new ArrayList<>();
		sinhVienList.add(new SinhVien("Nguyễn Văn B", "b@fastrack.com", "điachi", "0123456789"));
		sinhVienList.add(new SinhVien("Nguyễn Văn C", "c@fastrack.com", "điachi", "0123456789"));
		sinhVienList.add(new SinhVien("Nguyễn Văn D", "d@fastrack.com", "điachi", "0123456789"));
		lopHoc1703.setSinhVienList(sinhVienList);
		lopHoc1703.setTenLop("FFSE1703");
		lopHoc1703.setHedaotao(new HeDaiHan(hocKiList));
		lopHoc1703.inDanhSach();
		
		// lớp 1801
		LopHoc lopHoc1801 = (LopHoc) context.getBean("lopHoc");
		
		// khởi tạo danh sách môn công nghệ
		monCongNgheList = new ArrayList<>();
		monCongNgheList
				.add(new MonCongNghe("Java Core", new GiangVien("Cao Lê Thành", "thanh@fasttrack.edu.vn"),
						new GiangVien("Lê Văn Thắng", "thang@fasttrack.edu.vn")));
		monCongNgheList
				.add(new MonCongNghe("Java Web", new GiangVien("Cao Lê Thành", "thanh@fasttrack.edu.vn"),
								new GiangVien("Lê Văn Thắng", "thang@fasttrack.edu.vn")));
		
		// khởi tạo danh sách sinh viên
		sinhVienList = new ArrayList<>();
		sinhVienList.add(new SinhVien("Nguyễn Văn B", "b@fastrack.com", "điachi", "0123456789"));
		sinhVienList.add(new SinhVien("Nguyễn Văn C", "c@fastrack.com", "điachi", "0123456789"));
		sinhVienList.add(new SinhVien("Nguyễn Văn D", "d@fastrack.com", "điachi", "0123456789"));
		lopHoc1801.setSinhVienList(sinhVienList);
		lopHoc1801.setTenLop("FFSE1801");
		lopHoc1801.setHedaotao(new HeNganHan(new HocKiJava(monCongNgheList)));
		lopHoc1801.inDanhSach();
		
		// lớp 1801
		LopHoc lopHoc1802 = (LopHoc) context.getBean("lopHoc");
		
		// khởi tạo danh sách môn công nghệ
		monCongNgheList = new ArrayList<>();
		monCongNgheList
				.add(new MonCongNghe("Java Core", new GiangVien("Cao Lê Thành", "thanh@fasttrack.edu.vn"),
						new GiangVien("Lê Văn Thắng", "thang@fasttrack.edu.vn")));
		monCongNgheList
				.add(new MonCongNghe("Java Web", new GiangVien("Cao Lê Thành", "thanh@fasttrack.edu.vn"),
								new GiangVien("Lê Văn Thắng", "thang@fasttrack.edu.vn")));
		
		// khởi tạo danh sách sinh viên
		sinhVienList = new ArrayList<>();
		sinhVienList.add(new SinhVien("Nguyễn Văn B", "b@fastrack.com", "điachi", "0123456789"));
		sinhVienList.add(new SinhVien("Nguyễn Văn C", "c@fastrack.com", "điachi", "0123456789"));
		sinhVienList.add(new SinhVien("Nguyễn Văn D", "d@fastrack.com", "điachi", "0123456789"));
		lopHoc1802.setSinhVienList(sinhVienList);
		lopHoc1802.setTenLop("FFSE1802");
		lopHoc1802.setHedaotao(new HeNganHan(new HocKiWebFullStack(monCongNgheList)));
		lopHoc1802.inDanhSach();
		
		
		
		
//		sinhVienList = new ArrayList<>();
//		for(char y = 'c'; y <= 'h'; y++){
//		    sinhVienList.add(new SinhVien("Nguyễn văn " + y, "", "",""));
//		}
//		
//		for (SinhVien x : sinhVienList) {
//			System.out.println(x.getHoTen());
//		}

	}

}
