package main;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.GiangVien;
import bean.HeDaiHan;
import bean.HeNganHan;
import bean.HocKy;
import bean.LopHoc;
import bean.MonHoc;
import bean.SinhVien;

public class MainAppV1 {
	private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	public static void main(String[] args) {

		// lớp 1703
		LopHoc lop1703 = (LopHoc) context.getBean("lopHoc");
		lop1703.setTenLop("FFSE1703");
		lop1703.setHeDaoTao(new HeDaiHan());

		ArrayList<SinhVien> arrSv = new ArrayList<>();
		arrSv.add(new SinhVien("Hồ Thanh Nhân"));
		arrSv.add(new SinhVien("Hồ Thanh Nhân"));
		arrSv.add(new SinhVien("Hồ Thanh Nhân"));
		lop1703.setSinhVien(arrSv);
		ArrayList<MonHoc> arrMH = new ArrayList<>();
		arrMH.add(new MonHoc("JAVA",new GiangVien("ACB")));
		arrMH.add(new MonHoc("PHP",new GiangVien("ACB")));
		arrMH.add(new MonHoc("CSS",new GiangVien("ACB")));
		lop1703.setHocKy(new HocKy("HK1", arrMH));
		lop1703.setMonHoc(arrMH);
		lop1703.in();
		//
		arrMH.clear();
		arrSv.clear();

		// lớp 1801
		LopHoc lop1801 = (LopHoc) context.getBean("lopHoc");
		lop1801.setTenLop("FFSE1801");
		lop1801.setHeDaoTao(new HeNganHan());
		lop1801.setHocKy(new HocKy("HK2",arrMH));
		//
		arrSv.add(new SinhVien("Nguyễn Thanh Nhân"));
		arrSv.add(new SinhVien("Nguyễn Thanh Nhân"));
		arrSv.add(new SinhVien("Nguyễn Thanh Nhân"));
		lop1801.setSinhVien(arrSv);
		//
		arrMH.add(new MonHoc("HTML",new GiangVien("abc")));
		arrMH.add(new MonHoc("PHP",new GiangVien("abc")));
		arrMH.add(new MonHoc("CSS",new GiangVien("abc")));
		lop1801.setMonHoc(arrMH);
		//
		lop1801.in();
		arrMH.clear();
		arrSv.clear();
		// lớp 1802
		LopHoc lop1802 = (LopHoc) context.getBean("lopHoc");
		lop1802.setTenLop("FFSE1801");
		lop1802.setHeDaoTao(new HeNganHan());
		lop1802.setHocKy(new HocKy("HK3",arrMH));
		//
		arrSv.add(new SinhVien("Phạm Thanh Nhân"));
		arrSv.add(new SinhVien("Phạm Thanh Nhân"));
		arrSv.add(new SinhVien("Phạm Thanh Nhân"));
		lop1802.setSinhVien(arrSv);
		//
		arrMH.add(new MonHoc("HTML",new GiangVien("xyz")));
		arrMH.add(new MonHoc("PHP",new GiangVien("xyz")));
		arrMH.add(new MonHoc("CSS",new GiangVien("xyz")));
		lop1802.setMonHoc(arrMH);
		//
		lop1802.in();
		arrMH.clear();
		arrSv.clear();
	}

}
