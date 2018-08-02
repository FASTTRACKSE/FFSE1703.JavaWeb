package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.*;

public class MainApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SinhVien sv1 = context.getBean("sinhVien", SinhVien.class);
		SinhVien sv2 = context.getBean("sinhVien", SinhVien.class);
		List<MonHoc> monHoc = new ArrayList<>();
		monHoc.add(new MonHoa());
		monHoc.add(new MonToan());
		sv1.setHoTen("Thành");
		sv2.setHoTen("Tuấn");
		sv1.setMonHoc(monHoc);
		sv2.setMonHoc(monHoc);
		System.out.println(sv1.mangSachDiHoc());
		System.out.println(sv2.mangSachDiHoc());
	}

}
