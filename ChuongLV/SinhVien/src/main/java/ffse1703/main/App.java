package ffse1703.main;

import java.util.ArrayList;
import java.util.Scanner;
import ffse1703.SinhVien.*;

public class App {
	public static Scanner input = new Scanner(System.in);
	public static ArrayList<SinhVien> arrHinhHoc = new ArrayList<SinhVien>();
	public static SinhVien a = new SinhVien();
	
	public static void main(String[] args) {
		a = new SinhVien();
		System.out.println("Nhập tên sinh viên:");
		String ten = input.nextLine();
		a.setHoTen(ten);
		showMyMenu();

	}
	
	public static void showMyMenu() {
		
		 {
			System.out.println(">>    SINH VIÊN ĐI HỌC     <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. Toán                       |");
			System.out.println("|2. Lý                         |");
			System.out.println("|3. Hóa                        |");
			System.out.println("|4. Kết thúc                   |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            Lựa chọn của bạn?         <<");
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
			input.nextInt();
				}
			
		 }
						
	
	public static void Toan() {
		a.mangSachToanDiHoc();
	}
	
	public static void Ly() {
		a.mangSachLyDiHoc();
	}
	
	public static void Hoa() {
		a.mangSachHoaDiHoc();
	}
	
	public static void ketThuc() {
		System.out.println("ket thuc");
		System.exit(0);
	}
}