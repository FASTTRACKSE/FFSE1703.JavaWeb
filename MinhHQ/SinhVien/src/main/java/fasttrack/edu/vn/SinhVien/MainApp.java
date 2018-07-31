package fasttrack.edu.vn.SinhVien;

import java.util.Scanner;

import model.*;

public class MainApp {

	public static Scanner myScanner = new Scanner(System.in);
	public static SinhVien sv = new SinhVien();
	MonToan monToan;
	MonLy monLy;
	MonHoa monHoa;
	public static void main(String[] args) {
		
		nhapSV();
		chonMH();
	}
	public static void nhapSV() {
		System.out.println("Nhập danh sách sinh viên : ");
		String Name = myScanner.nextLine();
		sv.setHoTen(Name);
		
		
		myScanner.nextLine();
	}
	public static void ketthuc() {
		System.out.println("Kết thúc chương trình");
		System.exit(0);
	}
	public static void chonMH() {
		while (true) {
			try {
			System.out.println(">>                 MENU                 <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. môn Toán                             |");
			System.out.println("|2. môn Lý                               |");
			System.out.println("|3. môn Hóa                              |");
			System.out.println("|4. kết thúc chương trình                |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            Lựa chọn của bạn?         <<");
			
			int myOption = myScanner.nextInt();
			if (myOption == 1) {
				sv.setMonHoc(new MonToan());
				System.out.println(sv.mangSachDiHoc());
			} else if (myOption == 2) {
				sv.setMonHoc(new MonLy());
				System.out.println(sv.mangSachDiHoc());
			} else if (myOption == 3) {
				sv.setMonHoc(new MonHoa());
				System.out.println(sv.mangSachDiHoc());
			} else if (myOption == 4) {
				ketthuc();
			}else {
                throw new Exception();
			}
			
			
			} catch (Exception e) {
				System.out.println("Bạn ddaax nhập sai vui lòng nhập lại! Bạn phải nhập từ 1 -4!!!");
				myScanner.nextLine();
			}
			
			myScanner.nextLine();
			myScanner.nextLine();
			System.out.println("Nhấn Enter để vào menu chính");
			myScanner.nextLine();
		}
	}
	
}
