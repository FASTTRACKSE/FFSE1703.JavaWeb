package fasttrack.vn.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.DaoTaoNganHan;
import model.MonHoc;
import model.MonLy;
import model.MonToan;
import model.SinhVienVersion2;

public class MainAppSpringV1 {
	private static String name;
	public static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Nạp file config spring từ applicationContext.xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		// Tạo bean từ spring containner
		// SinhVienVersion2 sinhvien1 = (SinhVienVersion2) context.getBean("sinhvien1");
		// SinhVienVersion2 sinhvien2 = (SinhVienVersion2) context.getBean("sinhvien2");
		//
		// System.out.print("Nhập vào tên của bạn : ");
		// name = myScanner.nextLine();
		// sinhvien1.setHoTen(name);
		// System.out.println(sinhvien1.diHoc());
		//
		// System.out.print("Nhập vào tên của bạn : ");
		// name = myScanner.nextLine();
		// sinhvien2.setHoTen(name);
		// System.out.println(sinhvien2.diHoc());
		// context.close();
		// Tạo bean từ spring containner
		SinhVienVersion2 sinhVien1 = context.getBean("sinhVienVersion2", SinhVienVersion2.class);
		SinhVienVersion2 sinhVien2 = context.getBean("sinhVienVersion2", SinhVienVersion2.class);

		MonToan monToan = context.getBean("monToan", MonToan.class);
		MonLy monLy = context.getBean("monLy", MonLy.class);

		DaoTaoNganHan heDaoTaoNganHan = context.getBean("daoTaoNganHan", DaoTaoNganHan.class);

		List<MonHoc> monHoc1 = new ArrayList<MonHoc>();
		monHoc1.add(monToan);
		monHoc1.add(monLy);

		System.out.print("Nhập vào tên của bạn : ");
		name = myScanner.nextLine();
		sinhVien1.setHoTen(name);
		sinhVien1.setMonHoc(monHoc1);

		System.out.print("Nhập vào tên của bạn : ");
		name = myScanner.nextLine();
		sinhVien2.setHoTen(name);
		sinhVien2.setHeDaoTao(heDaoTaoNganHan);
		sinhVien2.setMonHoc(monHoc1);

		System.out.println(sinhVien1.mangSachDiHoc());
		System.out.println(sinhVien2.mangSachDiHoc());

		context.close();

	}

}