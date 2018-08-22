package fasttrackse.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fasttrackse.entity.*;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		HocKy1 hocKy1 = context.getBean("hocKy1", HocKy1.class);
		HocKy2 hocKy2 = context.getBean("hocKy2", HocKy2.class);

		KhoaDaiHan khoaDaiHan = context.getBean("khoaDaiHan", KhoaDaiHan.class);
		KhoaNganHan khoaNganHan = context.getBean("khoaNganHan", KhoaNganHan.class);

		JavaWed javaWed = context.getBean("javaWed", JavaWed.class);
		JavaCore javacore = context.getBean("javaCore", JavaCore.class);
		English english = context.getBean("english", English.class);
		FontEndBackEnd fontEndBackEnd = context.getBean("fontEndBackEnd", FontEndBackEnd.class);
		NhapMonLapTrinh nhapMonLapTrinh = context.getBean("nhapMonLapTrinh", NhapMonLapTrinh.class);

		LopHocNam lopHoc1 = context.getBean("lopHocNam", LopHocNam.class);
		List<SinhVien> sv = new ArrayList<SinhVien>();
		sv.add(new SinhVien("Hồ Quang Minh"));
		sv.add(new SinhVien("Lê Phước Hiếu"));
		sv.add(new SinhVien("Lê Thanh Danh"));
		sv.add(new SinhVien("Phạm Trần Đức"));
		List<MonHoc> monHoc = new ArrayList<MonHoc>();
		monHoc.add(fontEndBackEnd);
		monHoc.add(english);
		monHoc.add(javaWed);
		monHoc.add(javacore);
		lopHoc1.setLopHoc("Lớp FFSE1702");
		lopHoc1.setSinhVien(sv);
		lopHoc1.setMonHoc(monHoc);
		lopHoc1.setDaoTao(khoaDaiHan);
		lopHoc1.setHocKy(hocKy1);

		LopHocNam lopHoc2 = context.getBean("lopHocNam", LopHocNam.class);
		List<SinhVien> sv2 = new ArrayList<SinhVien>();
		sv2.add(new SinhVien("Hồ Quang Minh"));
		sv2.add(new SinhVien("Lê Phước Hiếu"));
		sv2.add(new SinhVien("Lê Thanh Danh"));
		sv2.add(new SinhVien("Phạm Trần Đức"));
		List<MonHoc> monHoc2 = new ArrayList<MonHoc>();
		monHoc2.add(fontEndBackEnd);
		monHoc2.add(nhapMonLapTrinh);
		monHoc2.add(english);
		lopHoc2.setLopHoc("Lớp FFSE1703");
		lopHoc2.setSinhVien(sv2);
		lopHoc2.setMonHoc(monHoc2);
		lopHoc2.setDaoTao(khoaDaiHan);
		lopHoc2.setHocKy(hocKy2);
		
		
		LopHocNam lopHoc3 = context.getBean("lopHocNam", LopHocNam.class);
		List<SinhVien> sv3 = new ArrayList<SinhVien>();
		sv3.add(new SinhVien("Hồ Quang Minh"));
		sv3.add(new SinhVien("Lê Phước Hiếu"));
		sv3.add(new SinhVien("Lê Thanh Danh"));
		sv3.add(new SinhVien("Phạm Trần Đức"));
		List<MonHoc> monHoc3 = new ArrayList<MonHoc>();
		monHoc3.add(fontEndBackEnd);
		monHoc3.add(nhapMonLapTrinh);
		monHoc3.add(english);
		lopHoc3.setLopHoc("Lớp FFSE1801");
		lopHoc3.setSinhVien(sv3);
		lopHoc3.setMonHoc(monHoc3);
		lopHoc3.setDaoTao(khoaNganHan);
		lopHoc3.setHocKy(hocKy2);

		System.out.println(lopHoc1.getLop());
		System.out.println(lopHoc2.getLop());
		System.out.println(lopHoc3.getLop());
		context.close();
	}

}
