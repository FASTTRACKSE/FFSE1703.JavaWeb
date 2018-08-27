package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.*;

public class MainApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LopHoc lopHoc1 = context.getBean("lopHoc", LopHoc.class);
		LopHoc lopHoc2 = context.getBean("lopHoc", LopHoc.class);

		List<MonHoc> monHoc2 = new ArrayList<>();
		monHoc2.add(new MangSachMonHoc("Nhập môn lập trình", new GiangVienFE("Thầy Lâm")));
		monHoc2.add(new MangSachMonHoc("Java Core", new GiangVienFE("Thầy Thành")));
		monHoc2.add(new MangSachMonHoc("Java Web", new GiangVienFE("Thầy Thắng")));

		List<MonHoc> monHoc1 = new ArrayList<>();
		monHoc1.add(new MangSachMonHoc("HTML", new GiangVienFE("Thầy Thành")));
		monHoc1.add(new MangSachMonHoc("CSS", new GiangVienFE("Thầy Thắng")));
		monHoc1.add(new MangSachMonHoc("PHP", new GiangVienFE("Thầy Lâm")));

		List<SinhVien> sinhVien = new ArrayList<>();
		sinhVien.add(new SinhVien("Nguyễn Văn A"));
		sinhVien.add(new SinhVien("Nguyễn Văn B"));
		sinhVien.add(new SinhVien("Nguyễn Văn C"));

		List<SinhVien> sinhVien1 = new ArrayList<>();
		sinhVien1.add(new SinhVien("Nguyễn Văn D"));
		sinhVien1.add(new SinhVien("Nguyễn Văn E"));
		sinhVien1.add(new SinhVien("Nguyễn Văn G"));

		List<HocKi> hocKiNganHan = new ArrayList<>(2);
		List<HocKi> hocKiDaiHan = new ArrayList<>(4);
		hocKiDaiHan.add(new HocKiFS("Học kì 1", monHoc1));
		hocKiDaiHan.add(new HocKiFS("Học kì 2", monHoc2));
		hocKiNganHan.add(new HocKiFS("Học kì 1", monHoc1));
		hocKiNganHan.add(new HocKiFS("Học kì 2", monHoc2));

		lopHoc1.setLopHoc("Lớp 1703");
		lopHoc1.setSinhVien(sinhVien);
		lopHoc1.setHeDaoTao(new DaoTaoDaiHan(hocKiDaiHan));

		lopHoc2.setLopHoc("Lớp 1704");
		lopHoc2.setSinhVien(sinhVien1);
		lopHoc2.setHeDaoTao(new DaoTaoDaiHan(hocKiDaiHan));

		System.out.println(lopHoc1.thongTinLopHoc());
		System.out.println(lopHoc2.thongTinLopHoc());
		
		context.close();
	}

}
