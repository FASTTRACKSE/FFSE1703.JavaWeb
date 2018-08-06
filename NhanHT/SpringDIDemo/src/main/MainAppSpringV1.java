package main;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.HocKi2;
import bean.HocKi1;
import bean.MonHoa;
import bean.MonHoc;
import bean.MonLy;
import bean.MonToan;
import bean.SinhVien2;

public class MainAppSpringV1 {
	public static String name;
	public static Scanner myInput = new Scanner(System.in);
	private static ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");;
	static SinhVien2 sinhVien2  = (SinhVien2)context.getBean("sinhVien2");

	public static void main(String[] args) {
		nhapTen();
	}

	public static void nhapTen() {
		System.out.println("Nhập Tên : ");
		name = myInput.nextLine();
		sinhVien2.setHoTen(name);
		
		menuHocKi();
	}
	public static void menuHocKi() {
		while (true) {
			System.out.println("<===LUA CHON HE DAO TAO===>");
			System.out.println("|| 	1.HK1       ||");
			System.out.println("|| 	2.HK2  		||");
			System.out.println("    LUA CHON CUA BAN      ");
			int option = myInput.nextInt();
			if (option == 1) {
				sinhVien2.setHocKi(new HocKi1());
				menuMonHoc();
				break;
			}else if (option == 2) {
				sinhVien2.setHocKi(new HocKi2());
				menuMonHoc();
				break;
			}
		}
	}
	public static void menuMonHoc() {
		ArrayList<MonHoc> arrMonHoc = new ArrayList<>();
		while (true) {
			System.out.println("<=LUA CHON MON HOC=>");
			System.out.println("|| 	1.Toan      ||");
			System.out.println("|| 	2.Ly  		||");
			System.out.println("|| 	3.Hoa       ||");
			System.out.println("|| 	4.In        ||");
			System.out.println(" LUA CHON CUA BAN");
			int option = myInput.nextInt();
			if (option == 1) {
				arrMonHoc.add(new MonToan());
				sinhVien2.setMonHoc(arrMonHoc);
				//sinhVien2.mangSachDiHoc();
			}else if (option == 2) {
				arrMonHoc.add(new MonLy());
				sinhVien2.setMonHoc(arrMonHoc);
				//sinhVien2.mangSachDiHoc();
			}else if (option == 3) {
				arrMonHoc.add(new MonHoa());
				sinhVien2.setMonHoc(arrMonHoc);
				//sinhVien2.mangSachDiHoc();
			}else if (option == 4) {
				in();
				break;
			}
		}
	}
	public static void in() {
		myInput.nextLine();
		System.out.print(name);
		sinhVien2.heDaoTao();
		sinhVien2.mangSachDiHoc();
	}
}
