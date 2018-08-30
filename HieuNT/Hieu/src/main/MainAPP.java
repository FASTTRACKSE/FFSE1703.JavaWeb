package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.CongNghe;
import entity.DaoTaoDaiHan;
import entity.HocKi;
import entity.HocKy1;
import entity.HocKy2;
import entity.LopHoc;
import entity.MonHoc;
import entity.SinhVien;
import entity.TiengAnh;

public class MainAPP {
	static List<HocKi> hocKiList;
	static List<MonHoc> congNghe;
	static List<SinhVien> sinhVienList;


	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext1.xml");
		// Tạo bean từ spring containner
		LopHoc lop1 = context.getBean("lopHoc", LopHoc.class);

		/*
		 * List<ListSinhVien> sv = new ArrayList<ListSinhVien>(); sv.add(new
		 * ListSinhVien("cine")); sv.add(new ListSinhVien("nike"));
		 */
		// khởi tạo danh sách môn công nghệ
		congNghe = new ArrayList<>();
		congNghe.add(new CongNghe("JAVA", "THẦY THÀNH"));


		hocKiList = new ArrayList<>();
		hocKiList.add(new HocKy1(congNghe, new TiengAnh("GIAO TIẾP", "CÔ HÀ")));
		hocKiList.add(new HocKy2(congNghe, new TiengAnh("GIAO TIẾP", "CÔ HÀ")));
		
		sinhVienList = new ArrayList<>();
		sinhVienList.add(new SinhVien("Nguyễn Văn B", "b@fastrack.com", "điachi", "0123456789"));
		sinhVienList.add(new SinhVien("Nguyễn Văn C", "c@fastrack.com", "điachi", "0123456789"));
		sinhVienList.add(new SinhVien("Nguyễn Văn D", "d@fastrack.com", "điachi", "0123456789"));

		lop1.setTenLopHoc("FFSE1702");
		lop1.setHeDaoTao(new DaoTaoDaiHan(hocKiList));
		lop1.setSinhVien(sinhVienList);
		System.out.println(lop1.thongTinLopHoc());
	}

}
