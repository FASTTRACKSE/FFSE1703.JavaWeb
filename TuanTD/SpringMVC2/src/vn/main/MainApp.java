package vn.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import vn.model.DaoTaoNganHan;
import vn.model.HocKy1;
import vn.model.HocKy2;
import vn.model.JavaCore;
import vn.model.MonHoc;
import vn.model.MonLy;
import vn.model.Student;
import vn.model.LopHoc;

public class MainApp {
	public static void main(String[] args) {
		// Nạp file config spring từ applicationContext.xml
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		LopHoc FFSE1703 = context.getBean("lopHoc", LopHoc.class);
		LopHoc FFSE1704 = context.getBean("lopHoc", LopHoc.class);

		HocKy1 hocKy1 = context.getBean("hocKy1", HocKy1.class);
		HocKy2 hocKy2 = context.getBean("hocKy2", HocKy2.class);

		JavaCore javaCore = context.getBean("javaCore", JavaCore.class);
		MonLy monLy = context.getBean("monLy", MonLy.class);

		DaoTaoNganHan heDaoTaoNganHan = context.getBean("daoTaoNganHan", DaoTaoNganHan.class);

		List<MonHoc> monHoc1 = new ArrayList<MonHoc>();
		monHoc1.add(javaCore);
		monHoc1.add(monLy);
		List<MonHoc> monHoc2 = new ArrayList<MonHoc>();
		monHoc2.add(monLy);

		List<Student> sV = new ArrayList<Student>();
		sV.add(new Student("Trần Đình Tuấn"));
		sV.add(new Student("Trần Đình Tuấn"));
		sV.add(new Student("Trần Đình Tuấn"));
		sV.add(new Student("Trần Đình Tuấn"));
		sV.add(new Student("Trần Đình Tuấn"));
		List<Student> sV2 = new ArrayList<Student>();
		sV2.add(new Student("Trần Công Quang"));
		sV2.add(new Student("Trần Đình Tuấn"));
		sV2.add(new Student("Trần Đình Tuấn"));
		sV2.add(new Student("Trần Đình Tuấn"));
		sV2.add(new Student("Trần Đình Tuấn"));

		FFSE1703.setStudent(sV);
		FFSE1703.setTenLop("FFSE1703");
		FFSE1703.setHeDaoTao(heDaoTaoNganHan);
		FFSE1703.setHocKy(hocKy1);
		FFSE1703.setMonHoc(monHoc1);

		FFSE1704.setStudent(sV2);
		FFSE1704.setTenLop("FFSE1704");
		FFSE1704.setHocKy(hocKy2);
		FFSE1704.setMonHoc(monHoc2);

		System.out.println(FFSE1703.inSinhVien());
		System.out.println(FFSE1704.inSinhVien());

	}

}
