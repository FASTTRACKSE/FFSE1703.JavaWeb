package main;

import java.util.Scanner;

import bean.HeDaiHan;
import bean.HeNganHan;
import bean.MonHoa;
import bean.MonLy;
import bean.MonToan;
import bean.SinhVien2;

public class MainApp {
	static SinhVien2 sinhVien2 = new SinhVien2();
	public static String name;
	public static Scanner myInput = new Scanner(System.in);
	public static void main(String[] args) {
		nhapTen();
	}

	public static void nhapTen() {
		System.out.println("Nhập Tên : ");
		name = myInput.nextLine();
		sinhVien2.setHoTen(name);
		menuHeDaoTao();
	}
	public static void menuHeDaoTao() {
		while (true) {
			System.out.println("<===LUA CHON HE DAO TAO===>");
			System.out.println("|| 	1.HE NGAN HAN       ||");
			System.out.println("|| 	2.HE DAI HAN  		||");
			System.out.println("    LUA CHON CUA BAN      ");
			int option = myInput.nextInt();
			if (option == 1) {
				sinhVien2.setHeDaoTao(new HeNganHan());
				menuMonHoc();
				break;
			}else if (option == 2) {
				sinhVien2.setHeDaoTao(new HeDaiHan());
				menuMonHoc();
				break;
			}
		}
	}
	public static void menuMonHoc() {
		while (true) {
			System.out.println("<=LUA CHON MON HOC=>");
			System.out.println("|| 	1.Toan      ||");
			System.out.println("|| 	2.Ly  		||");
			System.out.println("|| 	3.Hoa       ||");
			System.out.println("|| 	4.In        ||");
			System.out.println(" LUA CHON CUA BAN");
			int option = myInput.nextInt();
			if (option == 1) {
				sinhVien2.setMonHoc(new MonToan());
				//sinhVien2.mangSachDiHoc();
			}else if (option == 2) {
				sinhVien2.setMonHoc(new MonLy());
				//sinhVien2.mangSachDiHoc();
			}else if (option == 3) {
				sinhVien2.setMonHoc(new MonHoa());
				//sinhVien2.mangSachDiHoc();
			}else if (option == 4) {
				in();
				break;
			} else if (option == 0) {
				ketthuc();
			}
		}
	}
	
	public static void ketthuc() {
		System.exit(0);
	}
	public static void in() {
		myInput.nextLine();
		sinhVien2.heDaoTao();
		sinhVien2.mangSachDiHoc();
	}
}
