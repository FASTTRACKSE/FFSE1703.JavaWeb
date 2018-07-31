package Ass1.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Ass1.Monhoc.*;

public class MainApp2 {
	public static Scanner input = new Scanner(System.in);
	static SinhVien2 a = new SinhVien2();
	public String x;

	public static void main(String[] args) {
		a = new SinhVien2();
		System.out.println("Nhập Tên Sinh Vien :");
		String ten = input.nextLine();
		a.setHoTen(ten);
		MeNu();
	}

	public static void MeNu() {
		for (;;) {
			System.out.println(">>               Menu           <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. Hệ đào tạo dài hạn                   |");
			System.out.println("|2. Hệ đào tạo ngắn hạn                  |");
			System.out.println("|3. Chọn môn học                         |");
			System.out.println("|4. Kết Thúc                             |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            chọn chức năng.         <<");
			int myOption = input.nextInt();
			if (myOption == 1) {
				daiHan();
			} else if (myOption == 2) {
				nganHan();
			} else if (myOption == 3) {
				ChonMon();
			} else if (myOption == 4) {
				ketThuc();
			}
		}
	}

	public static void daiHan() {
		a.setHeDaoTao(new DaoTaoDaiHan());
		System.out.println(a.heDaoTao());
		a.setMonHoc(new MonToan());
		System.out.println(a.mangSachDiHoc());
		a.setMonHoc(new MonLy());
		System.out.println(a.mangSachDiHoc());

	}

	public static void nganHan() {
		a.setHeDaoTao(new DaoTaoNganHan());
		System.out.println(a.heDaoTao());
		a.setMonHoc(new MonHoa());
		System.out.println(a.mangSachDiHoc());

	}

	public static void ChonMon() {
		// TODO Auto-generated method stub
		for (;;) {
			System.out.println(">>               Chọn Môn Học           <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. Toán                                 |");
			System.out.println("|2. Lý                                   |");
			System.out.println("|3. Hóa                                  |");
			System.out.println("|4. Kết Thúc                             |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            chọn chức năng.         <<");
			int myOption = input.nextInt();
			if (myOption == 1) {
				Toan();
			} else if (myOption == 2) {
				Ly();
			} else if (myOption == 3) {
				Hoa();
			} else if (myOption == 4) {
				ketThuc();
			}
			input.nextLine();
		}

	}

	public static void Toan() {
		a.setMonHoc(new MonToan());
		System.out.println(a.mangSachDiHoc());
	}

	public static void Ly() {
		a.setMonHoc(new MonLy());
		System.out.println(a.mangSachDiHoc());
	}

	public static void Hoa() {
		a.setMonHoc(new MonHoa());
		System.out.println(a.mangSachDiHoc());
	}

	public static void ketThuc() {
		System.out.println("ket thuc!!!!!");
		System.exit(0);
	}

}
