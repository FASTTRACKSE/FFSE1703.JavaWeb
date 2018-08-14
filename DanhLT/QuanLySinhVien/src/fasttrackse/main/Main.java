package fasttrackse.main;

import fasttrackse.entity.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// Nạp file config spring từ applicationContext.xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		LopHoc lopHoc = context.getBean("lopHoc", LopHoc.class);
		LopHoc lopHoc1 = context.getBean("lopHoc", LopHoc.class);

		MonJavacore monJavacore = context.getBean("monJavacore", MonJavacore.class);
		MonJavaWed monJavaWeb = context.getBean("monJavaWed", MonJavaWed.class);
		MonHTML monHTML5 = context.getBean("monHTML", MonHTML.class);
		MonPHP php = context.getBean("monPHP", MonPHP.class);

		HocKy1 hocKy1 = context.getBean("hocKy1", HocKy1.class);
		HocKy2 hocKy2 = context.getBean("hocKy2", HocKy2.class);

		HeDaoTaoDai daoTaoDaiHan = context.getBean("heDaoTaoDai", HeDaoTaoDai.class);
		HeDaoTaoNgan daoTaoNganHan = context.getBean("heDaoTaoNgan", HeDaoTaoNgan.class);

		// SV1
		List<SinhVien> sinhvien = new ArrayList<SinhVien>();
		sinhvien.add(new SinhVien("Hồ Viết Tú"));
		sinhvien.add(new SinhVien("Lê Thanh Danh"));
		sinhvien.add(new SinhVien("Lê phước Hiếu"));
		sinhvien.add(new SinhVien(" Hồ Quang Minh"));
		sinhvien.add(new SinhVien("Châu Ngọc Kí"));

		List<MonHoc> monhoc = new ArrayList<MonHoc>();
		monhoc.add(monJavacore);
		monhoc.add(monJavaWeb);
		monhoc.add(php);
		monhoc.add(monHTML5);

		lopHoc.setLopHoc("FFSE1701");
		lopHoc.setHeDaoTao(daoTaoDaiHan);
		lopHoc.setHocKy(hocKy1);
		lopHoc.setMonHoc(monhoc);
		lopHoc.setSinhVien(sinhvien);

		System.out.println(lopHoc.getLayDanhSach());

		context.close();

	}
}