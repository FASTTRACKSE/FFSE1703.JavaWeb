package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.*;

public class MainApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LopHoc lopHoc1 = context.getBean("lopHoc", LopHoc.class);
		List<MonHoc> monHoc = new ArrayList<>();
		monHoc.add(new MangSachMonHoc("Java Core"));
		monHoc.add(new MangSachMonHoc("Java Web"));
		monHoc.add(new MangSachMonHoc("Nhập môn lập trình"));
		
		List<GiangVien> giangVien = new ArrayList<>();
		giangVien.add(new GiangVienFE("Thầy Thành"));
		giangVien.add(new GiangVienFE("Thầy Lâm"));
		giangVien.add(new GiangVienFE("Thầy Thắng"));
		
		List<SinhVien> sinhVien = new ArrayList<>();
		sinhVien.add(new SinhVien("Võ Phi Tuấn"));
		sinhVien.add(new SinhVien("Hồ Thanh Nhân"));
		sinhVien.add(new SinhVien("Phạm Văn Quý"));

		lopHoc1.setLopHoc("Lớp 1703");
		lopHoc1.setHocKi(new HocKiFS("Học kì 1"));
		lopHoc1.setGiangVien(giangVien);
		lopHoc1.setMonHoc(monHoc);
		lopHoc1.setSinhVien(sinhVien);
		lopHoc1.setHeDaoTao(new DaoTaoDaiHan());
		System.out.println(lopHoc1.thongTinLopHoc());
	}

}
